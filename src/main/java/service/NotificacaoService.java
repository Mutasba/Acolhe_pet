package service;

import Dao.NotificacaoDAO;

import Model_Entety.*;

import java.sql.SQLException;

import java.time.LocalDate;

import java.util.List;
import java.sql.Connection;

public class NotificacaoService {

    private NotificacaoDAO notificacaoDAO;

    private AnimalService animalService;

    private AnimalVacinaService animalVacinaService;

    public NotificacaoService(Connection conn)
            throws SQLException {

        notificacaoDAO =
                new NotificacaoDAO(conn);

        animalService =
                new AnimalService(conn);

        animalVacinaService =
                new AnimalVacinaService(conn);

    }
    public boolean jaExisteNotificacaoMatch(String nomeAnimal, String nomeAdotante) throws SQLException {
        return notificacaoDAO.existeNotificacaoMatch(nomeAnimal, nomeAdotante);
    }


    public void verificarVacinas() throws SQLException {
        List<Animal> animais = animalService.listar(); 
        List<Notificacao> historicoNotif = notificacaoDAO.listar(); 

        for (Animal animal : animais) {
            List<AnimalVacina> vacinas = animalVacinaService.listarPorAnimal(animal.getId());

            for (AnimalVacina av : vacinas) {
                LocalDate dataReforco = av.getDataReforco();
                
                
                if (dataReforco != null && 
                    !LocalDate.now().isBefore(dataReforco.minusDays(7)) && 
                    LocalDate.now().isBefore(dataReforco)) {
                    
                    String msg = "Animal " + animal.getNome() + " possui reforço de vacina em breve: " + dataReforco;
                    
                    
                    boolean jaNotificado = historicoNotif.stream().anyMatch(n -> 
                        n.getMensagem().equals(msg) && !n.isVisualizada()
                    );

                    if (!jaNotificado) {
                        Notificacao n = new Notificacao();
                        n.setTitulo("Alerta de Vacina");
                        n.setMensagem(msg);
                        n.setTipo("VACINA");
                        n.setVisualizada(false);
                        n.setData(LocalDate.now());
                        
                        notificacaoDAO.salvar(n);
                        historicoNotif.add(n); 
                    }
                }
            }
        }
    }

    public List<Notificacao> listar()
            throws SQLException {

        return notificacaoDAO.listar();

    }

    public void marcarComoVisualizada(
            int id
    ) throws SQLException {

        notificacaoDAO
                .marcarComoVisualizada(id);

    }

    public void salvar(
            Notificacao notificacao
    ) throws SQLException {

        notificacaoDAO
                .salvar(notificacao);

    }
  
}