package Dao;

import Database.DB;
import Model_Entety.Vacina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacinaDAO {

    private Connection conn;

    public VacinaDAO()
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
     
     public void atualizar(Vacina v) throws SQLException {
        String sql = "UPDATE vacina SET nome = ? WHERE id = ?";
        PreparedStatement stmt = getConn().prepareStatement(sql);

        stmt.setString(1, v.getNome());
        stmt.setInt(2, v.getId());

        stmt.executeUpdate();
        stmt.close();
    }
    public void salvar(
            Vacina vacina
    ) throws SQLException {

        String sql =
                "INSERT INTO vacina(nome) VALUES(?)";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setString(
                1,
                vacina.getNome()
        );

        stmt.executeUpdate();

        stmt.close();
    }
    public Vacina buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM vacina WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Vacina v = new Vacina();
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                return v;
            }
        }
        return null;
    }

    public List<Vacina> listar()
            throws SQLException {

        List<Vacina> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM vacina";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        ResultSet rs =
                stmt.executeQuery();

        while(rs.next()){

            Vacina vacina =
                    new Vacina();

            vacina.setId(
                    rs.getInt("id")
            );

            vacina.setNome(
                    rs.getString("nome")
            );

            lista.add(vacina);
        }

        rs.close();
        stmt.close();

        return lista;
    }
}