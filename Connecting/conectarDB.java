package Connecting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juliano Pimentel
 */

public class conectarDB extends StringsDB {             

        public Connection Conexao;  
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
}


    