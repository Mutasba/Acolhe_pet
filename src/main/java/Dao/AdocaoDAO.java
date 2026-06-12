package Dao;


import Database.DB;
import Model_Entety.Adocao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdocaoDAO {

    private Connection conn;
    
   
    public AdocaoDAO(Connection conn) throws SQLException {
         this.conn = conn;
    }
    
     private Connection getConn() throws SQLException {
        if (this.conn == null || this.conn.isClosed() || !this.conn.isValid(3)) {
            this.conn = DB.conectar(); // reconecta
        }
        return this.conn;
    }

    // SALVAR
    public void salvar(Adocao adocao)
            throws SQLException {

        String sql = """
            INSERT INTO adocao
            (
                adotante_id,
                animal_id,
                data_adocao,
                status,
                observacao
            )
            VALUES (?, ?, ?, ?, ?)
        """;

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setInt(
                1,
                adocao.getAdotanteId()
        );

        stmt.setInt(
                2,
                adocao.getAnimalId()
        );

        stmt.setDate(
                3,
                Date.valueOf(adocao.getDataAdocao())
        );

        stmt.setString(
                4,
                adocao.getStatus()
        );

        stmt.setString(
                5,
                adocao.getObservacao()
        );

        stmt.executeUpdate();

        stmt.close();
    }

    // LISTAR
    public List<Adocao> listar()
            throws SQLException {

        List<Adocao> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM adocao";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        ResultSet rs =
                stmt.executeQuery();

        while(rs.next()){

            Adocao a =
                    new Adocao();

            a.setId(rs.getInt("id"));

            a.setAdotanteId(
                    rs.getInt("adotante_id")
            );

            a.setAnimalId(
                    rs.getInt("animal_id")
            );

            a.setDataAdocao(
                    rs.getDate("data_adocao")
                    .toLocalDate()
            );

            a.setStatus(
                    rs.getString("status")
            );

            a.setObservacao(
                    rs.getString("observacao")
            );

            lista.add(a);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    // BUSCAR POR ANIMAL
    public Adocao buscarPorAnimal(int animalId)
            throws SQLException {

        String sql =
                "SELECT * FROM adocao WHERE animal_id = ?";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setInt(1, animalId);

        ResultSet rs =
                stmt.executeQuery();

        Adocao a = null;

        if(rs.next()){

            a = new Adocao();

            a.setId(rs.getInt("id"));

            a.setAnimalId(
                    rs.getInt("animal_id")
            );
        }

        rs.close();
        stmt.close();

        return a;
    }

    // DELETE
    public void deletar(int id)
            throws SQLException {

        String sql =
                "DELETE FROM adocao WHERE id = ?";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        stmt.close();
    }
}