package service;

import Dao.HistoricoDAO;
import Model_Entety.Historico;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

public class HistoricoService {

    private HistoricoDAO dao;

    public HistoricoService(Connection conn)
            throws SQLException {

        dao =
                new HistoricoDAO();

    }

    public void salvar(
            Historico historico
    ) throws SQLException {

        dao.salvar(historico);

    }

    public List<Historico> listar()
            throws SQLException {

        return dao.listar();

    }
}