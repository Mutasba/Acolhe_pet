package service;

import Dao.EstatisticaDAO;
import Model_Entety.Estatistica;
import java.sql.SQLException;
import java.sql.Connection;

public class EstatisticaService {
    private EstatisticaDAO dao;

    public EstatisticaService(Connection conn) throws SQLException {
        dao = new EstatisticaDAO();
    }

    public Estatistica buscarEstatisticas() throws SQLException {
        return dao.buscarEstatisticas();
    }

    
    public Estatistica buscarPorPeriodo(int mes, int ano) throws SQLException {
        return dao.buscarPorPeriodo(mes, ano);
    }
}