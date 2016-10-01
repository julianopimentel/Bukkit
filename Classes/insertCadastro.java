package Classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Juliano P
 */
public class insertCadastro extends Connecting.conectarDB {
            //Metodo para validar login.
        public boolean Cadastro (int cpf,String nome) {
            
            String sql = "INSERT INTO clientes(cpf,nome) VALUES(?,?)"; 
            try{  
                conecta();
                PreparedStatement pst = Conexao.prepareStatement(sql);
                pst.setInt(1, cpf);  
                pst.setString(2, nome);
                
                 pst.execute();  
                pst.close();  
                } 
            catch (SQLException u) 
            {  
                throw new RuntimeException(u);  
            } return true; 
        }
}
