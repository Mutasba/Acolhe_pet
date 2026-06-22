package Dao;

import Database.DB;
import Model_Entety.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    private Connection conn;

    public AnimalDAO(Connection conn) throws SQLException {
        this.conn = conn;
    }
    
     private Connection getConn() throws SQLException {
        if (this.conn == null || this.conn.isClosed() || !this.conn.isValid(3)) {
            this.conn = DB.conectar(); // reconecta
        }
        return this.conn;
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
                estado,
                data_entrada
            )
            VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
   
    try (Connection conn = new DB().conectar();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
         
      

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

        if (animal.getDataEntrada() != null) {
            stmt.setDate(15, Date.valueOf(animal.getDataEntrada()));
        } else {
            stmt.setDate(15, Date.valueOf(java.time.LocalDate.now())); 
        }
        
        stmt.executeUpdate();
        
       
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                animal.setId(generatedKeys.getInt(1)); 
            }
        }
        
    }
}

    // LISTAR
    public List<Animal> listar() throws SQLException {

        List<Animal> lista
                = new ArrayList<>();

        String sql
                = "SELECT * FROM animal";

        PreparedStatement stmt
                = getConn().prepareStatement(sql);

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
                = getConn().prepareStatement(sql);

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

    public void atualizar(Animal a) throws SQLException {
       
        String sql = "UPDATE animal SET nome=?, tipo=?, cor=?, raca=?, idade=?, peso=?, " +
                     "genero=?, porte=?, deficiencia=?, castrado=?, fiv=?, felv=?, foto=? " +
                     "WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getTipo());
            stmt.setString(3, a.getCor());
            stmt.setString(4, a.getRaca());
            stmt.setInt(5, a.getIdade());
            stmt.setDouble(6, a.getPeso());
            stmt.setString(7, String.valueOf(a.getGenero()));
            stmt.setString(8, String.valueOf(a.getPorte()));
            stmt.setBoolean(9, a.isDeficiencia());
            stmt.setBoolean(10, a.isCastrado());
            stmt.setBoolean(11, a.isFIV());
            stmt.setBoolean(12, a.isFELV());
            stmt.setString(13, a.getFoto());
            stmt.setInt(14, a.getId()); 

            stmt.executeUpdate();
        }
    }
    public void atualizarStatus(int animalId, String novoStatus) throws SQLException {
   
        String sql = "UPDATE animal SET estado = ? WHERE id = ?"; 

        try (Connection conn = new DB().conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            if (!novoStatus.equals("NAO_ADOTADO") && 
                !novoStatus.equals("EM_PROCESSO") && 
                !novoStatus.equals("ADOTADO")) {
                throw new IllegalArgumentException("Status inválido para o banco: " + novoStatus);
            }

            stmt.setString(1, novoStatus);
            stmt.setInt(2, animalId);

            stmt.executeUpdate();
        }
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
                = getConn().prepareStatement(sql);

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
                = getConn().prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();

        stmt.close();
    }
}
