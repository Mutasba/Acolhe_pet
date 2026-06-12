/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author danie
 */
//public class TesteUser {
//    public static void main(String args[]){
//        try {             
//            SistemaController sc = new SistemaController();
//            List<User> usr = sc.ListaUsuario();
//            for(User us: usr){
//                System.out.println(us.getNome());
//            }
//        } catch (SQLException ex) {
//            System.getLogger(TesteUser.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
//        }
//               
//    }    
   

public class TesteUser {
    public static void main(String[] args) {
        Properties prop = new Properties();

        // Automatically closes the stream to prevent memory leaks
        try (InputStream input = new FileInputStream("src\\main\\java\\Database\\Properties.properties")) {
            // Load the properties file
            prop.load(input);

            // Get values using their keys.
            prop.setProperty("nome", "Mamadu");
            String nome = prop.getProperty("nome");
            
            // 3. Guardar as alterações no ficheiro
            FileOutputStream out = new FileOutputStream("src\\main\\java\\Database\\Properties.properties");
            prop.store(out, "Ficheiro atualizado com sucesso");
            out.close();

            // Provide a fallback default value if the key does not exist
           // String dbPort = prop.getProperty("database.port", "3306");

            System.out.println("URL: " + nome);
          //  System.out.println("Port: " + dbPort);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

