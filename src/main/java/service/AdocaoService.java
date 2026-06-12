package service;

import Dao.AdocaoDAO;
import Dao.AnimalDAO;
import Model_Entety.Adocao;
import Model_Entety.Animal;

import java.sql.SQLException;
import java.util.List;

public class AdocaoService {

    private AdocaoDAO dao;

    public AdocaoService() throws SQLException {

        dao = new AdocaoDAO();

    }

    public void salvar(Adocao adocao) throws SQLException {

        // Salva a adoção
        dao.salvar(adocao);

        // Atualiza o animal
        Animal animal = new Animal();
        animal.setId(adocao.getAnimalId());
        animal.setEstado("ADOTADO");

        AnimalDAO animalDAO = new AnimalDAO();
        animalDAO.atualizarEstado(
                animal.getId(),
                "ADOTADO"
        );
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
