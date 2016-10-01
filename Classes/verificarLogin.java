/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Juliano P
 */
public class verificarLogin extends Connecting.conectarDB {
            
        //Metodo para validar login.
        public boolean validate_login(String username,String password) {
            try{           
                conecta();    
                PreparedStatement pst = Conexao.prepareStatement("Select * from login where username=? and password=?");
                pst.setString(1, username); 
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();  
                
                if(rs.next())            
                    return true;    
                else
                    return false;            
                }
            catch(Exception e){
                e.printStackTrace();
                return false;
                } 
        }  
}
