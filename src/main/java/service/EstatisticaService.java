package service;

import Dao.EstatisticaDAO;
import Model_Entety.Estatistica;
import java.sql.SQLException;

public class EstatisticaService {
    private EstatisticaDAO dao;

    
    public EstatisticaService() throws SQLException {
        dao = new EstatisticaDAO();
    }

    public Estatistica buscarEstatisticas() throws SQLException {
        return dao.buscarEstatisticas();
    }

    public Estatistica buscarPorPeriodo(int mes, int ano) throws SQLException {
        return dao.buscarPorPeriodo(mes, ano);
    }
}