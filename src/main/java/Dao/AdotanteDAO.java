package Dao;

import Database.DB;
import Model_Entety.Adotante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdotanteDAO {

    private Connection conn;

    public AdotanteDAO() throws SQLException {

        this.conn
                = new DB().conectar();

    }

    public void salvar(Adotante adotante)
            throws SQLException {

        String sql = """
        INSERT INTO adotante
        (
            nome,
            cpf,
            email,
            telefone,
            endereco,
            data_cadastro
        )
        VALUES (?, ?, ?, ?, ?, ?)
    """;

        PreparedStatement stmt
                = conn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS
                );

        stmt.setString(
                1,
                adotante.getNome()
        );

        stmt.setString(
                2,
                adotante.getCpf()
        );

        stmt.setString(
                3,
                adotante.getEmail()
        );

        stmt.setString(
                4,
                adotante.getTelefone()
        );

        stmt.setString(
                5,
                adotante.getEndereco()
        );

        stmt.setDate(
                6,
                Date.valueOf(
                        adotante.getDataCadastro()
                )
        );

        stmt.executeUpdate();

        ResultSet rs
                = stmt.getGeneratedKeys();

        if (rs.next()) {

            adotante.setId(
                    rs.getInt(1)
            );

        }

        rs.close();
        stmt.close();
    }

    public Adotante buscarPorCpf(String cpf) throws SQLException {

        String sql
                = "SELECT * FROM adotante WHERE cpf = ?";

        PreparedStatement ps
                = conn.prepareStatement(sql);

        ps.setString(1, cpf);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            Adotante a = new Adotante();

            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setCpf(rs.getString("cpf"));

            return a;
        }

        return null;
    }

    public List<Adotante> listar()
            throws SQLException {

        List<Adotante> lista
                = new ArrayList<>();

        String sql
                = "SELECT * FROM adotante";

        PreparedStatement stmt
                = conn.prepareStatement(sql);

        ResultSet rs
                = stmt.executeQuery();

        while (rs.next()) {

            Adotante adotante
                    = new Adotante();

            adotante.setId(
                    rs.getInt("id")
            );

            adotante.setNome(
                    rs.getString("nome")
            );

            adotante.setCpf(
                    rs.getString("cpf")
            );

            adotante.setEmail(
                    rs.getString("email")
            );

            adotante.setTelefone(
                    rs.getString("telefone")
            );

            adotante.setEndereco(
                    rs.getString("endereco")
            );

            adotante.setDataCadastro(
                    rs.getDate("data_cadastro")
                            .toLocalDate()
            );

            lista.add(adotante);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    public Adotante buscarPorId(int id)
            throws SQLException {

        String sql
                = "SELECT * FROM adotante WHERE id = ?";

        PreparedStatement stmt
                = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs
                = stmt.executeQuery();

        Adotante adotante = null;

        if (rs.next()) {

            adotante
                    = new Adotante();

            adotante.setId(
                    rs.getInt("id")
            );

            adotante.setNome(
                    rs.getString("nome")
            );

            adotante.setCpf(
                    rs.getString("cpf")
            );

            adotante.setEmail(
                    rs.getString("email")
            );

            adotante.setTelefone(
                    rs.getString("telefone")
            );

            adotante.setEndereco(
                    rs.getString("endereco")
            );

            adotante.setDataCadastro(
                    rs.getDate("data_cadastro")
                            .toLocalDate()
            );
        }

        rs.close();
        stmt.close();

        return adotante;
    }

    public void atualizar(Adotante adotante)
            throws SQLException {

        String sql = """
        UPDATE adotante
        SET
            nome = ?,
            cpf = ?,
            email = ?,
            telefone = ?,
            endereco = ?
        WHERE id = ?
    """;

        PreparedStatement stmt
                = conn.prepareStatement(sql);

        stmt.setString(1, adotante.getNome());

        stmt.setString(2, adotante.getCpf());

        stmt.setString(3, adotante.getEmail());

        stmt.setString(4, adotante.getTelefone());

        stmt.setString(5, adotante.getEndereco());

        stmt.setInt(6, adotante.getId());

        stmt.executeUpdate();

        stmt.close();
    }

    public void deletar(int id)
            throws SQLException {

        String sql
                = "DELETE FROM adotante WHERE id = ?";

        PreparedStatement stmt
                = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        stmt.close();
    }

}
