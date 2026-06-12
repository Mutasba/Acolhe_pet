package Dao;

import Database.DB;
import Model_Entety.Historico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {

    private Connection conn;

    public HistoricoDAO() throws SQLException {

        conn =
                new DB().conectar();

    }
    
     private Connection getConn() throws SQLException {
        if (this.conn == null || this.conn.isClosed() || !this.conn.isValid(3)) {
            this.conn = DB.conectar(); // reconecta
        }
        return this.conn;
    }

    public void salvar(Historico historico)
            throws SQLException {

        String sql = """
            INSERT INTO historico
            (
                usuario_id,
                animal_id,
                adotante_id,
                acao
            )
            VALUES (?, ?, ?, ?)
        """;

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setObject(
                1,
                historico.getUsuarioId()
        );

        stmt.setObject(
                2,
                historico.getAnimalId()
        );

        stmt.setObject(
                3,
                historico.getAdotanteId()
        );

        stmt.setString(
                4,
                historico.getAcao()
        );

        stmt.executeUpdate();

        stmt.close();
    }

    public List<Historico> listar()
            throws SQLException {

        List<Historico> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM historico ORDER BY data_evento DESC";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        ResultSet rs =
                stmt.executeQuery();

        while(rs.next()){

            Historico historico =
                    new Historico();

            historico.setId(
                    rs.getInt("id")
            );

            historico.setUsuarioId(
                    rs.getInt("usuario_id")
            );

            historico.setAnimalId(
                    rs.getInt("animal_id")
            );

            historico.setAdotanteId(
                    rs.getInt("adotante_id")
            );

            historico.setAcao(
                    rs.getString("acao")
            );

            historico.setDataEvento(
                    rs.getTimestamp("data_evento")
                    .toLocalDateTime()
            );

            lista.add(historico);
        }

        rs.close();
        stmt.close();

        return lista;
    }
}