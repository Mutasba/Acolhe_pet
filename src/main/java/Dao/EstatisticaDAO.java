package Dao;

import Database.DB;
import Model_Entety.Estatistica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstatisticaDAO {

    public EstatisticaDAO() {}

    // MÉTODO PARA ESTATÍSTICAS GERAIS (DA TELA PRINCIPAL)
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

        try (Connection conn = DB.conectar()) {
            for (int i = 0; i < queries.length; i++) {
                try (PreparedStatement stmt = conn.prepareStatement(queries[i]); ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int total = rs.getInt("total");
                        switch (i) {
                            case 0 -> e.setAnimaisAdotados(total);
                            case 1 -> e.setAnimaisNaoAdotados(total);
                            case 2 -> e.setAnimaisEmProcesso(total);
                            case 3 -> e.setTotalAnimais(total);
                            case 4 -> e.setTotalAdocoes(total);
                            case 5 -> e.setTotalAdotantes(total);
                        }
                    }
                }
            }
        }
        return e;
    }

    
    public Estatistica buscarPorPeriodo(int mes, int ano) throws SQLException {
        Estatistica e = new Estatistica();

        
        String sqlAdotados = "SELECT COUNT(*) total FROM adocao WHERE status = 'FINALIZADA' AND MONTH(data_adocao) = ? AND YEAR(data_adocao) = ?";
        String sqlCadastrados = "SELECT COUNT(*) total FROM animal WHERE MONTH(data_entrada) = ? AND YEAR(data_entrada) = ?";

        try (Connection conn = DB.conectar()) {
            
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
                    if (rs.next()) {
                        int total = rs.getInt("total");
                        e.setAnimaisCadastrados(total);
                     
                        System.out.println("DEBUG: Para " + mes + "/" + ano + ", a query de 'data_entrada' retornou: " + total);
                    }
                }
            }
        }
        return e;
    }
}