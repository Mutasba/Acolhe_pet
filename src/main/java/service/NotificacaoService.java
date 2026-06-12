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

    public void verificarVacinas()
            throws SQLException {

        List<Animal> animais =
                animalService.listar();

        for (Animal animal : animais) {

            List<AnimalVacina> lista =
                    animalVacinaService
                            .listarPorAnimal(
                                    animal.getId()
                            );

            for (AnimalVacina av : lista) {

                if (av.getDataReforco()
                        != null) {

                    if (av.getDataReforco()
                            .minusDays(7)
                            .isBefore(
                                    LocalDate.now()
                            )) {

                        Notificacao n =
                                new Notificacao();

                        n.setTitulo(
                                "Vacina próxima"
                        );

                        n.setMensagem(
                                "Animal "
                                + animal.getNome()
                                + " possui vacina próxima do reforço"
                        );

                        n.setTipo(
                                "VACINA"
                        );

                        n.setVisualizada(
                                false
                        );

                        n.setData(
                                LocalDate.now()
                        );

                        notificacaoDAO.salvar(n);
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