package service;

import Dao.AnimalDAO;
import Model_Entety.Animal;

import java.sql.SQLException;
import java.util.List;

public class AnimalService {

    private AnimalDAO dao;

    public AnimalService() throws SQLException {

        dao = new AnimalDAO();

    }

    public void salvarComFoto(
            Animal animal, String caminho
    ) throws Exception {

        animal.setFoto(caminho);

        dao.salvar(animal);
    }

    /**
     * public void salvar(Animal animal) throws SQLException {
     *
     * dao.salvar(animal);
     *
     * }
     *
     */
    public List<Animal> listar()
            throws SQLException {

        List<Animal> animais = dao.listar();

        return animais.stream()
                .filter(a
                        -> "NAO_ADOTADO".equalsIgnoreCase(
                        a.getEstado()
                )
                )
                .toList();
    }

    public List<Animal> listarAll()
            throws SQLException {

        return dao.listar();

    }

    public Animal buscarPorId(int id)
            throws SQLException {

        return dao.buscarPorId(id);

    }

    public void atualizar(Animal animal)
            throws SQLException {

        dao.atualizar(animal);

    }

    public void deletar(int id)
            throws SQLException {

        dao.deletar(id);

    }
}
