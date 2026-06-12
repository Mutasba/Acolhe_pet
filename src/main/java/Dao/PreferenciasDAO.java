package Dao;

import Database.DB;
import Model_Entety.Preferencias;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreferenciasDAO {

    private Connection conn;

    public PreferenciasDAO(Connection conn1) throws SQLException {
        this.conn = new DB().conectar();
    }
    
     private Connection getConn() throws SQLException {
        if (this.conn == null || this.conn.isClosed() || !this.conn.isValid(3)) {
            this.conn = DB.conectar(); // reconecta
        }
        return this.conn;
    }

    // SALVAR
    public void salvar(Preferencias p) throws SQLException {

        String sql = """
            INSERT INTO preferencias
            (
                adotante_id,
                tipo,
                cor,
                idade,
                genero,
                raca,
                deficiencia,
                castrado,
                peso,
                porte,
                fiv,
                felv
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        PreparedStatement stmt
                = getConn().prepareStatement(sql);

        stmt.setInt(1, p.getId());
        stmt.setString(2, p.getTipo());
        stmt.setString(3, p.getCor());
        stmt.setInt(4, p.getIdade());
        stmt.setString(5, String.valueOf(p.getGenero()));
        stmt.setString(6, p.getRaca());
        stmt.setBoolean(7, p.isDeficiencia());
        stmt.setBoolean(8, p.isCastrado());
        stmt.setFloat(9, p.getPeso());
        stmt.setString(10, String.valueOf(p.getPorte()));
        stmt.setBoolean(11, p.isFIV());
        stmt.setBoolean(12, p.isFELV());

        stmt.executeUpdate();

        stmt.close();
    }

    // LISTAR
    public List<Preferencias> listar()
            throws SQLException {

        List<Preferencias> lista
                = new ArrayList<>();

        String sql
                = "SELECT * FROM preferencias";

        PreparedStatement stmt
                = getConn().prepareStatement(sql);

        ResultSet rs
                = stmt.executeQuery();

        while (rs.next()) {

            Preferencias p
                    = new Preferencias();

            p.setId(rs.getInt("id"));
            p.setTipo(rs.getString("tipo"));
            p.setCor(rs.getString("cor"));
            p.setIdade(rs.getInt("idade"));
            p.setGenero(
                    rs.getString("genero").charAt(0)
            );

            p.setRaca(rs.getString("raca"));

            p.setDeficiencia(
                    rs.getBoolean("deficiencia")
            );

            p.setCastrado(
                    rs.getBoolean("castrado")
            );

            p.setPeso(
                    rs.getFloat("peso")
            );

            p.setPorte(
                    rs.getString("porte").charAt(0)
            );

            p.setFIV(
                    rs.getBoolean("fiv")
            );

            p.setFELV(
                    rs.getBoolean("felv")
            );

            lista.add(p);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    // BUSCAR POR ID
    public Preferencias buscarPorId(int id)
            throws SQLException {

        String sql
                = "SELECT * FROM preferencias WHERE id = ?";

        PreparedStatement stmt
                = getConn().prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs
                = stmt.executeQuery();

        Preferencias p = null;

        if (rs.next()) {

            p = new Preferencias();

            p.setId(rs.getInt("id"));
            p.setTipo(rs.getString("tipo"));
            p.setCor(rs.getString("cor"));
            p.setIdade(rs.getInt("idade"));
            p.setGenero(
                    rs.getString("genero").charAt(0)
            );

            p.setRaca(rs.getString("raca"));

            p.setDeficiencia(
                    rs.getBoolean("deficiencia")
            );

            p.setCastrado(
                    rs.getBoolean("castrado")
            );

            p.setPeso(
                    rs.getFloat("peso")
            );

            p.setPorte(
                    rs.getString("porte").charAt(0)
            );

            p.setFIV(
                    rs.getBoolean("fiv")
            );

            p.setFELV(
                    rs.getBoolean("felv")
            );
        }

        rs.close();
        stmt.close();

        return p;
    }

    // UPDATE
    public void atualizar(Preferencias p)
            throws SQLException {

        String sql = """
            UPDATE preferencias
            SET
                tipo = ?,
                cor = ?,
                idade = ?
            WHERE id = ?
        """;

        PreparedStatement stmt
                = getConn().prepareStatement(sql);

        stmt.setString(1, p.getTipo());
        stmt.setString(2, p.getCor());
        stmt.setInt(3, p.getIdade());
        stmt.setInt(4, p.getId());

        stmt.executeUpdate();

        stmt.close();
    }

    // DELETE
    public void deletar(int id)
            throws SQLException {

        String sql
                = "DELETE FROM preferencias WHERE id = ?";

        PreparedStatement stmt
                = getConn().prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        stmt.close();
    }
}
