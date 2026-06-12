package Dao;

import Database.DB;
import Model_Entety.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    private Connection conn;

    public AnimalDAO() throws SQLException {
        this.conn = new DB().conectar();
    }

    // SALVAR
    public void salvar(Animal animal) throws SQLException {

        String sql = """
            INSERT INTO animal
            (
                nome,
                foto,
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
                felv,
                estado
            )
            VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        PreparedStatement stmt
                = conn.prepareStatement(sql);

        stmt.setString(1, animal.getNome());
        stmt.setString(2, animal.getFoto());
        stmt.setString(3, animal.getTipo());
        stmt.setString(4, animal.getCor());
        stmt.setInt(5, animal.getIdade());
        stmt.setString(6, String.valueOf(animal.getGenero()));
        stmt.setString(7, animal.getRaca());
        stmt.setBoolean(8, animal.isDeficiencia());
        stmt.setBoolean(9, animal.isCastrado());
        stmt.setFloat(10, animal.getPeso());
        stmt.setString(11, String.valueOf(animal.getPorte()));
        stmt.setBoolean(12, animal.isFIV());
        stmt.setBoolean(13, animal.isFELV());
        stmt.setString(14, animal.getEstado());

        stmt.executeUpdate();

        stmt.close();
    }

    // LISTAR
    public List<Animal> listar() throws SQLException {

        List<Animal> lista
                = new ArrayList<>();

        String sql
                = "SELECT * FROM animal";

        PreparedStatement stmt
                = conn.prepareStatement(sql);

        ResultSet rs
                = stmt.executeQuery();

        while (rs.next()) {

            Animal animal
                    = new Animal();

            animal.setId(rs.getInt("id"));
            animal.setNome(rs.getString("nome"));
            animal.setFoto(rs.getString("foto"));
            animal.setTipo(rs.getString("tipo"));
            animal.setCor(rs.getString("cor"));
            animal.setIdade(rs.getInt("idade"));
            animal.setGenero(rs.getString("genero").charAt(0));

            animal.setRaca(rs.getString("raca"));

            animal.setDeficiencia(rs.getBoolean("deficiencia")
            );

            animal.setCastrado(
                    rs.getBoolean("castrado")
            );

            animal.setPeso(
                    rs.getFloat("peso")
            );

            animal.setPorte(
                    rs.getString("porte").charAt(0)
            );

            animal.setFIV(
                    rs.getBoolean("fiv")
            );

            animal.setFELV(
                    rs.getBoolean("felv")
            );

            animal.setEstado(
                    rs.getString("estado")
            );

            lista.add(animal);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    // BUSCAR POR ID
    public Animal buscarPorId(int id)
            throws SQLException {

        String sql
                = "SELECT * FROM animal WHERE id = ?";

        PreparedStatement stmt
                = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs
                = stmt.executeQuery();

        Animal animal = null;

        if (rs.next()) {

            animal = new Animal();

            animal.setId(rs.getInt("id"));
            animal.setNome(rs.getString("nome"));
        }

        rs.close();
        stmt.close();

        return animal;
    }

    // UPDATE
    public void atualizar(Animal animal)
            throws SQLException {

        String sql = """
            UPDATE animal
            SET
                nome = ?,
                cor = ?,
                idade = ?
            WHERE id = ?
        """;

        PreparedStatement stmt
                = conn.prepareStatement(sql);

        stmt.setString(1, animal.getNome());
        stmt.setString(2, animal.getCor());
        stmt.setInt(3, animal.getIdade());
        stmt.setInt(4, animal.getId());

        stmt.executeUpdate();

        stmt.close();
    }
    public void atualizarStatus(int id, String novoStatus) throws SQLException {
    String sql = """
        UPDATE animal
        SET status = ?
        WHERE id = ?
    """;

    PreparedStatement stmt = conn.prepareStatement(sql);

    stmt.setString(1, novoStatus);
    stmt.setInt(2, id);

    stmt.executeUpdate();
    stmt.close();
    }

    public void atualizarEstado(
            int idAnimal,
            String estado
    ) throws SQLException {

        String sql
                = "UPDATE animal "
                + "SET estado = ? "
                + "WHERE id = ?";

        PreparedStatement ps
                = conn.prepareStatement(sql);

        ps.setString(1, estado);
        ps.setInt(2, idAnimal);

        ps.executeUpdate();
    }

    // DELETE
    public void deletar(int id)
            throws SQLException {

        String sql
                = "DELETE FROM animal WHERE id = ?";

        PreparedStatement stmt
                = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        stmt.close();
    }
}
