package service;

import Model_Entety.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MatchAutomaticoService {

    private AnimalService animalService;
    private AdotanteService adotanteService;
    private MatchService matchService;
    private NotificacaoService notificacaoService;

    public MatchAutomaticoService(Connection conn) throws SQLException {
        this.animalService = new AnimalService(conn);
        this.adotanteService = new AdotanteService(conn);
        this.matchService = new MatchService(conn);
        this.notificacaoService = new NotificacaoService(conn);
    }

  
    public void gerarMatches() throws SQLException {
    List<Adotante> adotantes = adotanteService.listar();

    for (Adotante adotante : adotantes) {
        Preferencias preferencias = adotanteService.buscarPreferencias(adotante.getId());
        if (preferencias == null) continue;

        List<ResultadoMatch> matches = matchService.buscarAnimaisCompativeis(preferencias);
        if (matches.isEmpty()) continue;

        ResultadoMatch melhor = matches.get(0);

        if (melhor.getPontos() >= 5) {
            Animal animal = melhor.getAnimal();
            String nomeAnimal = melhor.getAnimal().getNome();
            String nomeAdotante = adotante.getNome();
            String emailAdotante = adotante.getEmail();
            String mensagem = "O animal " + nomeAnimal + " combina com o adotante " + nomeAdotante;

            
            if (!notificacaoService.jaExisteNotificacaoMatch(nomeAnimal, nomeAdotante)) {
                
                
                Notificacao n = new Notificacao();
                n.setTitulo("Novo correspondecia encontrado");
                n.setMensagem(mensagem);
                n.setTipo("MATCH");
                n.setVisualizada(false);
                n.setData(java.time.LocalDate.now());
                notificacaoService.salvar(n);

              
                new Thread(() -> {
                    try {
                        EmailService emailService = new EmailService();
                        String castradoTxt = animal.isCastrado() ? "Sim" : "Não";
                        String deficienciaTxt = animal.isDeficiencia() ? "Sim" : "Não";
                        String fivFelv = (animal.isFIV() ? "FIV+ " : "") + (animal.isFELV() ? "FELV+" : "");
                        if (fivFelv.isEmpty()) fivFelv = "Saudável";
                        

                        String mensagemHtml = "<html><body style='font-family: Arial, sans-serif; color: #333;'>" +
                            "<div style='max-width: 500px; margin: auto; border: 1px solid #ddd; padding: 20px; border-radius: 10px;'>" +
                                "<h2 style='color: #005A51; text-align: center;'>Novo Match Encontrado!</h2>" +
                                "<p>Olá <b>" + adotante.getNome() + "</b>, encontramos um novo pet compatível com você:</p>"+

                                "<h3 style='color: #005A51;'>" + animal.getNome() + "</h3>" +
                                "<ul style='list-style: none; padding: 0;'>" +
                                    "<li><b>Especie:</b> " + animal.getTipo()+ "</li>"+
                                    "<li><b>Raça:</b> " +animal.getRaca() + "</li>"+
                                    "<li><b>Idade:</b> " + animal.getIdade() + " anos</li>" +
                                    "<li><b>Peso:</b> " + animal.getPeso() + " kg</li>" +
                                    "<li><b>Cor:</b> " + animal.getCor() + "</li>" +
                                    "<li><b>Porte:</b> " + animal.getPorte() +   "</li>" +
                                    "<li><b>Gênero:</b> " + animal.getGenero() + "</li>"+
                                    "<li><b>Castrado:</b> " + castradoTxt + "</li>" +
                                    "<li><b>Deficiência:</b> " + deficienciaTxt + "</li>" +
                                    "<li><b>Saúde:</b> " + fivFelv + "</li>" +
                                    "<li><b>Estado:</b> " + animal.getEstado() + "</li>" +
                                "</ul>" +
                                "<p style='font-size: 12px; color: #777; text-align: center;'>Para mais informações, visite-nos no AcolhePet!</p>" +
                            "</div>" +
                        "</body></html>";

                        emailService.enviarEmail(adotante.getEmail(), "Match no AcolhePet!", mensagemHtml);
                    } catch (Exception e) {
                        System.err.println("Erro ao enviar e-mail: " + e.getMessage());
                    }
                }).start();
            }
        }
    }
}
}