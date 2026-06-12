package service;

import Dao.AdocaoDAO;
import Dao.AnimalDAO;
import Database.DB;
import Model_Entety.Adocao;
import Model_Entety.Animal;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

public class AdocaoService {

    private AdocaoDAO dao;

    public AdocaoService(Connection conn) throws SQLException {

        this.dao = new AdocaoDAO();

    }

    public void salvar(Adocao adocao) throws SQLException {
            
            try (Connection conn = new DB().conectar()) {

                
                AdocaoDAO adocaoDAO = new AdocaoDAO();
                AnimalDAO animalDAO = new AnimalDAO(conn);

                
                adocaoDAO.salvar(adocao);
                animalDAO.atualizarEstado(adocao.getAnimalId(), "ADOTADO");
            }
        }

    public List<Adocao> listar()
            throws SQLException {

        return dao.listar();

    }

    public Adocao buscarPorAnimal(int animalId)
            throws SQLException {

        return dao.buscarPorAnimal(animalId);

    }

    public void deletar(int id)
            throws SQLException {

        dao.deletar(id);

    }
}
