package Dao;

import Database.DB;
import Model_Entety.Adocao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdocaoDAO {

    
    public AdocaoDAO() {}

    
    public void salvar(Adocao adocao) throws SQLException {
        String sql = "INSERT INTO adocao (adotante_id, animal_id, data_adocao, status, observacao) VALUES (?, ?, ?, ?, ?)";
     
        try (Connection conn = DB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, adocao.getAdotanteId());
            stmt.setInt(2, adocao.getAnimalId());
            stmt.setDate(3, Date.valueOf(adocao.getDataAdocao()));
            
            String status = adocao.getStatus();
           
            if (status == null || (!status.equals("EM_PROCESSO") && !status.equals("FINALIZADA") && !status.equals("CANCELADA"))) {
                throw new IllegalArgumentException("Status inválido para o banco: " + status);
            }
            
            stmt.setString(4, status);
            stmt.setString(5, adocao.getObservacao());
            
            stmt.executeUpdate();
        }
    }

 
    public List<Adocao> listar() throws SQLException {
        List<Adocao> lista = new ArrayList<>();
        String sql = "SELECT * FROM adocao";
        
        try (Connection conn = DB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Adocao a = new Adocao();
                a.setId(rs.getInt("id"));
                a.setAdotanteId(rs.getInt("adotante_id"));
                a.setAnimalId(rs.getInt("animal_id"));
                a.setDataAdocao(rs.getDate("data_adocao").toLocalDate());
                a.setStatus(rs.getString("status"));
                a.setObservacao(rs.getString("observacao"));
                lista.add(a);
            }
        }
        return lista;
    }

    
    public Adocao buscarPorAnimal(int animalId) throws SQLException {
        String sql = "SELECT * FROM adocao WHERE animal_id = ?";
        
        try (Connection conn = DB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, animalId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Adocao a = new Adocao();
                    a.setId(rs.getInt("id"));
                    a.setAdotanteId(rs.getInt("adotante_id"));
                    a.setAnimalId(rs.getInt("animal_id"));
                    a.setStatus(rs.getString("status"));
                    a.setObservacao(rs.getString("observacao"));
                    return a;
                }
            }
        }
        return null;
    }

    
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM adocao WHERE id = ?";
        
        try (Connection conn = DB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}