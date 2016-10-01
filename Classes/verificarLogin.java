package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Juliano Pimentel
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
                e.printStackTrace();desconecta();
                return false;
                } 
        }  
}
