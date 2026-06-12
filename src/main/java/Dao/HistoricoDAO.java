package Dao;

import Database.DB;
import Model_Entety.Historico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {

    public void salvar(Historico historico) throws SQLException {
        String sql = """
            INSERT INTO historico (usuario_id, animal_id, adotante_id, acao)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = new DB().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setObject(1, historico.getUsuarioId() != null ? historico.getUsuarioId() : null);
            stmt.setObject(2, historico.getAnimalId() != null ? historico.getAnimalId() : null);
            stmt.setObject(3, historico.getAdotanteId() != null ? historico.getAdotanteId() : null);
            stmt.setString(4, historico.getAcao());

            stmt.executeUpdate();
        }
    }

    public List<Historico> listar() throws SQLException {
        List<Historico> lista = new ArrayList<>();
        String sql = "SELECT * FROM historico ORDER BY data_evento DESC";

        try (Connection conn = new DB().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Historico historico = new Historico();
                historico.setId(rs.getInt("id"));
                historico.setUsuarioId(rs.getInt("usuario_id"));
                historico.setAnimalId(rs.getInt("animal_id"));
                historico.setAdotanteId(rs.getInt("adotante_id"));
                historico.setAcao(rs.getString("acao"));

                Timestamp ts = rs.getTimestamp("data_evento");
                if (ts != null) {
                    historico.setDataEvento(ts.toLocalDateTime());
                }
                lista.add(historico);
            }
        }
        return lista;
    }
}