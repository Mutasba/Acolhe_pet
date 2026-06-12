package Dao;


import Database.DB;
import Model_Entety.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection conn;

    public UserDAO() throws SQLException {

       this.conn = new DB().conectar();

    }
    
     private Connection getConn() throws SQLException {
        if (this.conn == null || this.conn.isClosed() || !this.conn.isValid(3)) {
            this.conn = DB.conectar(); // reconecta
        }
        return this.conn;
    }

    // SALVAR
    public void salvar(User user)
            throws SQLException {

        String sql = """
            INSERT INTO user
            (
                nome,
                email,
                senha_hash,
                tipo,
                ativo
            )
            VALUES (?, ?, ?, ?, ?)
        """;

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setString(
                1,
                user.getNome()
        );

        stmt.setString(
                2,
                user.getEmail()
        );

        stmt.setString(
                3,
                user.getSenhaHash()
        );

        stmt.setString(
                4,
                user.getTipo()
        );

        stmt.setBoolean(
                5,
                user.isAtivo()
        );

        stmt.executeUpdate();

        stmt.close();
    }

    // LISTAR
    public List<User> listar()
            throws SQLException {

        List<User> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM user";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        ResultSet rs =
                stmt.executeQuery();

        while(rs.next()){

            User user =
                    new User();

            user.setId(
                    rs.getInt("id")
            );

            user.setNome(
                    rs.getString("nome")
            );

            user.setEmail(
                    rs.getString("email")
            );

            user.setSenhaHash(
                    rs.getString("senha_hash")
            );

            user.setTipo(
                    rs.getString("tipo")
            );

            user.setAtivo(
                    rs.getBoolean("ativo")
            );

            lista.add(user);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    // BUSCAR POR ID
    public User buscarPorId(int id)
            throws SQLException {

        String sql =
                "SELECT * FROM user WHERE id = ?";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs =
                stmt.executeQuery();

        User user = null;

        if(rs.next()){

            user = new User();

            user.setId(
                    rs.getInt("id")
            );

            user.setNome(
                    rs.getString("nome")
            );

            user.setEmail(
                    rs.getString("email")
            );

            user.setSenhaHash(
                    rs.getString("senha_hash")
            );

            user.setTipo(
                    rs.getString("tipo")
            );

            user.setAtivo(
                    rs.getBoolean("ativo")
            );
        }

        rs.close();
        stmt.close();

        return user;
    }

    // LOGIN
    public User login(
            String email
    ) throws SQLException {

        String sql =
                "SELECT * FROM user WHERE email = ?";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setString(1, email);

        ResultSet rs =
                stmt.executeQuery();

        User user = null;

        if(rs.next()){

            user = new User();

            user.setId(
                    rs.getInt("id")
            );

            user.setNome(
                    rs.getString("nome")
            );

            user.setEmail(
                    rs.getString("email")
            );

            user.setSenhaHash(
                    rs.getString("senha_hash")
            );

            user.setTipo(
                    rs.getString("tipo")
            );

            user.setAtivo(
                    rs.getBoolean("ativo")
            );
        }

        rs.close();
        stmt.close();

        return user;
    }

    // UPDATE
    public void atualizar(User user)
            throws SQLException {

        String sql = """
            UPDATE user
            SET
                nome = ?,
                email = ?,
                tipo = ?,
                ativo = ?
            WHERE id = ?
        """;

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setString(
                1,
                user.getNome()
        );

        stmt.setString(
                2,
                user.getEmail()
        );

        stmt.setString(
                3,
                user.getTipo()
        );

        stmt.setBoolean(
                4,
                user.isAtivo()
        );

        stmt.setInt(
                5,
                user.getId()
        );

        stmt.executeUpdate();

        stmt.close();
    }

    // UPDATE SENHA
    public void atualizarSenha(
            int id,
            String novaSenhaHash
    ) throws SQLException {

        String sql = """
            UPDATE user
            SET senha_hash = ?
            WHERE id = ?
        """;

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setString(1, novaSenhaHash);

        stmt.setInt(2, id);

        stmt.executeUpdate();

        stmt.close();
    }

    // DELETE
    public void deletar(int id)
            throws SQLException {

        String sql =
                "DELETE FROM user WHERE id = ?";

        PreparedStatement stmt =
                getConn().prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        stmt.close();
    }

}