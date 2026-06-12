package Dao;

import Database.DB;
import Model_Entety.AnimalVacina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalVacinaDAO {

    private Connection conn;

    public AnimalVacinaDAO()
            throws SQLException {

        conn =
                new DB().conectar();
    }
    
     private Connection getConn() throws SQLException {
        if (this.conn == null || this.conn.isClosed() || !this.conn.isValid(3)) {
            this.conn = DB.conectar(); // reconecta
        }
        return this.conn;
    }

    public void salvar(
            AnimalVacina av
    ) throws SQLException {

        String sql = """
            INSERT INTO animal_vacina
            (
                animal_id,
                vacina_id,
                data_aplicacao,
                data_reforco
            )
            VALUES (?, ?, ?, ?)
        """;

        PreparedStatement stmt =
                conn.prepareStatement(sql);

        stmt.setInt(
                1,
                av.getAnimalId()
        );

        stmt.setInt(
                2,
                av.getVacinaId()
        );

        stmt.setDate(
                3,
                Date.valueOf(
                        av.getDataAplicacao()
                )
        );

        stmt.setDate(
                4,
                Date.valueOf(
                        av.getDataReforco()
                )
        );

        stmt.executeUpdate();

        stmt.close();
    }

    public List<AnimalVacina> listarPorAnimal(
            int animalId
    ) throws SQLException {

        List<AnimalVacina> lista =
                new ArrayList<>();

        String sql = """
            SELECT * FROM animal_vacina
            WHERE animal_id = ?
        """;

        PreparedStatement stmt =
                conn.prepareStatement(sql);

        stmt.setInt(1, animalId);

        ResultSet rs =
                stmt.executeQuery();

        while(rs.next()){

            AnimalVacina av =
                    new AnimalVacina();

            av.setId(
                    rs.getInt("id")
            );

            av.setAnimalId(
                    rs.getInt("animal_id")
            );

            av.setVacinaId(
                    rs.getInt("vacina_id")
            );

            av.setDataAplicacao(
                    rs.getDate(
                            "data_aplicacao"
                    ).toLocalDate()
            );

            av.setDataReforco(
                    rs.getDate(
                            "data_reforco"
                    ).toLocalDate()
            );

            lista.add(av);
        }

        rs.close();
        stmt.close();

        return lista;
    }
}