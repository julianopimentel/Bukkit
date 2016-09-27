package LoginDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juliano Pimentel
 */

public class conectarDB extends StringsDB {             

        private Connection Conexao;  
        public boolean result;
        
        //Metodo para conectar.
        public boolean conecta()
        {  
            boolean result = true;  
            try   
            {  
                Class.forName(driver);  
                Conexao = DriverManager.getConnection(urlDB, usuarioDB, senhaDB);  
            }  
            catch(ClassNotFoundException Driver)   
            {  
               JOptionPane.showMessageDialog(null,"Driver não localizado: " + driver);  
            }  
            catch(SQLException Fonte)   
            {  
                JOptionPane.showMessageDialog(null,"Deu erro na conexão "+  
                        "com a fonte de dados: "+Fonte);  
               result = false;  
                result = false;  
            }  
            return result;   
        } 
        
        //Metodo para desconectar.
        public void desconecta()  
        {  
            boolean result = true;  
            try   
            {  
                Conexao.close();  
                JOptionPane.showMessageDialog(null,"Banco fechado");  
            }  
            catch(SQLException fecha)   
            {  
                JOptionPane.showMessageDialog(null,"Não foi possível "+  
                        "fechar o banco de dados: "+ fecha);  
                result = false;  
            }  
  
       }          
        
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