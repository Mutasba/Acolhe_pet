package service;

import Dao.AnimalVacinaDAO;
import Model_Entety.AnimalVacina;
import java.sql.Connection; 
import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;

public class AnimalVacinaService {

    private AnimalVacinaDAO dao;

    public AnimalVacinaService(Connection conn) throws SQLException {
        // Nota: O seu DAO original parece não receber a conexão no construtor.
        // Se precisar passar, use: this.dao = new AnimalVacinaDAO(conn);
        this.dao = new AnimalVacinaDAO();
    }

    /**
     * Salva a vacina do animal calculando a data de reforço.
     * @param av O objeto com os dados da vacinação
     * @param tempoReforcoAnos O número de anos para o próximo reforço
     */
    public void salvar(AnimalVacina av, int tempoReforcoAnos) throws SQLException {

        av.setDataReforco(tempoReforcoAnos); 

        dao.salvar(av);
    }

    public List<AnimalVacina> listarPorAnimal(int animalId) throws SQLException {
        return dao.listarPorAnimal(animalId);
    }
}