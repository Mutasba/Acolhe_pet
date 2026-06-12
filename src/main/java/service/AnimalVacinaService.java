package service;

import Dao.AnimalVacinaDAO;
import Model_Entety.AnimalVacina;
import java.sql.Connection; 
import java.sql.SQLException;
import java.util.List;

public class AnimalVacinaService {

    private AnimalVacinaDAO dao;

    public AnimalVacinaService(Connection conn)
            throws SQLException {

        this.dao =
                new AnimalVacinaDAO();
    }

    public void salvar(
            AnimalVacina av
    ) throws SQLException {

        dao.salvar(av);
    }

    public List<AnimalVacina>
    listarPorAnimal(
            int animalId
    ) throws SQLException {

        return dao.listarPorAnimal(
                animalId
        );
    }
}