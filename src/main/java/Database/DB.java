package Database;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
    
    private static Connection instancia = null; 
    
    private static final String URL
            = "jdbc:mysql://localhost:3306/?allowMultiQueries=true";

    private static final String URL_DATABASE
            = "jdbc:mysql://localhost:3306/acolhe_pet?allowMultiQueries=true";

    private static final String USER
            = "root";

    private static final String PASSWORD
            = "123456";

    public static Connection conectar() {

        
        try {

            if(instancia == null || instancia.isClosed() || instancia.isValid(3)){
                    instancia = DriverManager.getConnection(
                            URL_DATABASE,
                            USER,
                            PASSWORD
                    );
                    System.out.println( "Banco conectado");
            }
            
        } catch (Exception e) {

            System.out.println(  "Banco nao encontrado");

          System.out.println( "Criando a banco ");

            try {

                Connection inicial =
                        DriverManager.getConnection(
                                URL,
                                USER,
                                PASSWORD
                        );

                Statement stmt =
                        inicial.createStatement();

                Path caminho =
                        Paths.get(
                                "src/main/java/Sql/DB.sql"
                        );

                String sql =
                        Files.readString(caminho);

                stmt.execute(sql);

                stmt.close();

                inicial.close();

          //      System.out.println( "Banco criado");

                instancia =
                        DriverManager.getConnection(
                                URL_DATABASE,
                                USER,
                                PASSWORD
                        );

              //  System.out.println("Banco conectado apos criacao" );

            } catch (Exception ex) {

                ex.printStackTrace();

            }
        }

        return instancia;
    }

}