package Dao;

import Database.DB;
import Model_Entety.Estatistica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstatisticaDAO {

    private Connection conn;

    public EstatisticaDAO() throws SQLException {
        conn = new DB().conectar();
    }

   
    public Estatistica buscarEstatisticas() throws SQLException {
        Estatistica e = new Estatistica();
        String[] queries = {
            "SELECT COUNT(*) total FROM animal WHERE estado = 'ADOTADO'",
            "SELECT COUNT(*) total FROM animal WHERE estado = 'NAO_ADOTADO'",
            "SELECT COUNT(*) total FROM animal WHERE estado = 'EM_PROCESSO'",
            "SELECT COUNT(*) total FROM animal",
            "SELECT COUNT(*) total FROM adocao",
            "SELECT COUNT(*) total FROM adotante"
        };

        try (PreparedStatement stmt = conn.prepareStatement(queries[0]); ResultSet rs = stmt.executeQuery()) { if (rs.next()) e.setAnimaisAdotados(rs.getInt("total")); }
        try (PreparedStatement stmt = conn.prepareStatement(queries[1]); ResultSet rs = stmt.executeQuery()) { if (rs.next()) e.setAnimaisNaoAdotados(rs.getInt("total")); }
        try (PreparedStatement stmt = conn.prepareStatement(queries[2]); ResultSet rs = stmt.executeQuery()) { if (rs.next()) e.setAnimaisEmProcesso(rs.getInt("total")); }
        try (PreparedStatement stmt = conn.prepareStatement(queries[3]); ResultSet rs = stmt.executeQuery()) { if (rs.next()) e.setTotalAnimais(rs.getInt("total")); }
        try (PreparedStatement stmt = conn.prepareStatement(queries[4]); ResultSet rs = stmt.executeQuery()) { if (rs.next()) e.setTotalAdocoes(rs.getInt("total")); }
        try (PreparedStatement stmt = conn.prepareStatement(queries[5]); ResultSet rs = stmt.executeQuery()) { if (rs.next()) e.setTotalAdotantes(rs.getInt("total")); }

        return e;
    }

    
    public Estatistica buscarPorPeriodo(int mes, int ano) throws SQLException {
        Estatistica e = new Estatistica();
        String sqlAdotados = "SELECT COUNT(*) total FROM adocao WHERE status = 'FINALIZADA' AND MONTH(data_adocao) = ? AND YEAR(data_adocao) = ?";
        String sqlCadastrados = "SELECT COUNT(*) total FROM animal WHERE MONTH(data_entrada) = ? AND YEAR(data_entrada) = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlAdotados)) {
            stmt.setInt(1, mes);
            stmt.setInt(2, ano);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) e.setAnimaisAdotados(rs.getInt("total"));
            }
        }
        try (PreparedStatement stmt = conn.prepareStatement(sqlCadastrados)) {
            stmt.setInt(1, mes);
            stmt.setInt(2, ano);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) e.setAnimaisCadastrados(rs.getInt("total"));
            }
        }
        return e;
    }
}