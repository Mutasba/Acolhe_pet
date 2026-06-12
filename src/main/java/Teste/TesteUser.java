/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teste;

import Controller.SistemaController;
import Model_Entety.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author danie
 */
public class TesteUser {
    public static void main(String args[]){
        try {             
            SistemaController sc = new SistemaController();
            List<User> usr = sc.ListaUsuario();
            for(User us: usr){
                System.out.println(us.getNome());
            }
        } catch (SQLException ex) {
            System.getLogger(TesteUser.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
               
    }    
}
