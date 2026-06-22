package service;

import Dao.VacinaDAO;
import Model_Entety.Vacina;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;

public class VacinaService {

    private VacinaDAO dao;

    public VacinaService(Connection conn)
            throws SQLException {

        dao =
                new VacinaDAO();
    }
    
    public void atualizar(Vacina v) throws SQLException {
        dao.atualizar(v);
    }
    
    public Vacina buscarPorId(int id) throws SQLException {
       return dao.buscarPorId(id);
   }
    

    public void salvar(
            Vacina vacina
    ) throws SQLException {

        dao.salvar(vacina);
    }

    public List<Vacina> listar()
            throws SQLException {

        return dao.listar();
    }
}