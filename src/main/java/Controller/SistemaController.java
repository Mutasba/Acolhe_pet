package Controller;

import Model_Entety.*;

import service.*;

import java.sql.SQLException;
import java.util.List;

public class SistemaController {

    private AnimalVacinaService animalVacinaService;
    private AnimalService animalService;

    private AdotanteService adotanteService;

    private AdocaoService adocaoService;

    private UserService userService;

    private VacinaService vacinaService;

    private HistoricoService historicoService;

    private EstatisticaService estatisticaService;

    private NotificacaoService notificacaoService;

    private MatchAutomaticoService matchAutomaticoService;

    public SistemaController()
            throws SQLException {
        animalVacinaService
                = new AnimalVacinaService();

        animalService
                = new AnimalService();

        adotanteService
                = new AdotanteService();

        adocaoService
                = new AdocaoService();

        userService
                = new UserService();

        vacinaService
                = new VacinaService();

        historicoService
                = new HistoricoService();

        estatisticaService
                = new EstatisticaService();

        notificacaoService
                = new NotificacaoService();

        matchAutomaticoService
                = new MatchAutomaticoService();

    }

    public void salvarAnimalVacina(
            AnimalVacina av
    ) throws SQLException {

        animalVacinaService.salvar(av);
    }

    public Adotante buscarPorCpf(String cpf) throws SQLException {
        return adotanteService.buscarPorCpf(cpf);
    }
    
    public List<AnimalVacina>
            listarAnimalVacina(
                    int animalId
            ) throws SQLException {

        return animalVacinaService
                .listarPorAnimal(
                        animalId
                );
    }

    public void salvarAnimalComFoto(
            Animal animal, String caminho
    ) throws Exception {

        animalService.salvarComFoto(
                animal, caminho
        );
    }

    public List<User> ListaUsuario()
            throws SQLException {

        return userService.listar();

    }

    public List<Animal> listarAnimais()
            throws SQLException {

        return animalService.listar();

    }

    public Animal BuscarAnimalPorId(
            int id
    ) throws SQLException {

        return animalService.buscarPorId(id);

    }

    public void atualizarAnimal(
            Animal animal
    ) throws SQLException {

        animalService.atualizar(animal);

    }

    public void deletarAnimal(
            int id
    ) throws SQLException {

        animalService.deletar(id);

    }

    public void salvarAdotante(
            Adotante adotante,
            Preferencias preferencias
    ) throws SQLException {

        adotanteService.salvar(
                adotante,
                preferencias
        );

    }

    public List<Adotante> listarAdotantes()
            throws SQLException {

        return adotanteService.listar();

    }

    public Preferencias buscarPreferencias(
            int adotanteId
    ) throws SQLException {

        return adotanteService
                .buscarPreferencias(
                        adotanteId
                );
    }

    public void atualizarAdotante(
            Adotante adotante,
            Preferencias preferencias
    ) throws SQLException {

        adotanteService.atualizar(
                adotante,
                preferencias
        );

    }

    public void deletarAdotante(
            int id
    ) throws SQLException {

        adotanteService.deletar(id);

    }

    public void salvarVacina(
            Vacina vacina
    ) throws SQLException {

        vacinaService.salvar(vacina);

    }

    public List<Vacina> listarVacinas() throws SQLException {

        return vacinaService
                .listar();
    }

    public void salvarAdocao(
            Adocao adocao
    ) throws SQLException {

        adocaoService.salvar(adocao);

    }

    public List<Adocao> listarAdocoes()
            throws SQLException {

        return adocaoService.listar();

    }

    public void salvarUsuario(
            User user
    ) throws SQLException {

        userService.salvar(user);

    }

    public User login(
            String email,
            String senha
    ) throws SQLException {

        return userService.login(
                email,
                senha
        );
    }

    public void salvarHistorico(
            Historico historico
    ) throws SQLException {

        historicoService.salvar(
                historico
        );

    }

    public List<Historico> listarHistorico()
            throws SQLException {

        return historicoService.listar();

    }

    public Estatistica buscarEstatisticas()
            throws SQLException {

        return estatisticaService
                .buscarEstatisticas();

    }

    public List<Notificacao> listarNotificacoes()
            throws SQLException {

        return notificacaoService.listar();

    }

    public void verificarVacinas()
            throws SQLException {

        notificacaoService
                .verificarVacinas();

    }

    public void marcarNotificacaoVisualizada(
            int id
    ) throws SQLException {

        notificacaoService
                .marcarComoVisualizada(id);

    }

    public void gerarMatchesAutomaticos()
            throws SQLException {

        matchAutomaticoService
                .gerarMatches();

    }

    public void gerarPdfEstatistica(
            String caminho
    ) throws Exception {

        Estatistica estatistica
                = estatisticaService
                        .buscarEstatisticas();

        PdfService pdf
                = new PdfService();

        pdf.gerarPdfEstatistica(
                estatistica,
                caminho
        );

    }

    public void gerarPdfHistorico(
            String caminho
    ) throws Exception {

        List<Historico> lista
                = historicoService.listar();

        PdfService pdf
                = new PdfService();

        pdf.gerarPdfHistorico(
                lista,
                caminho
        );

    }

    public void atualizarStatus(int animalId, String novoStatus) throws SQLException {
        animalService.atualizarStatus(animalId, novoStatus);
    }
}
