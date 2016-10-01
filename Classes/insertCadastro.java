package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juliano Pimentel
 */
public class insertCadastro extends Connecting.conectarDB {
    


        
        //Metodo para validar login.
        public boolean Cadastro (String cpf, String nome, String sobrenome, String telefone, String email, String rua, String bairro, String numero, String estado, String dt_nascimento, String est_civil, String observacao) {
            
            
            String sql = "INSERT INTO clientes(cpf,nome,sobrenome,telefone,email,rua,bairro,numero,estado,dt_nascimento,est_civil,observacao) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)"; 
            try{  
                conecta();
                PreparedStatement pst = Conexao.prepareStatement(sql);
                pst.setString(1, cpf);  
                pst.setString(2, nome);
                pst.setString(3, sobrenome);
                pst.setString(4, telefone);
                pst.setString(5, email);
                pst.setString(6, rua);
                pst.setString(7, bairro);
                pst.setString(8, numero);
                pst.setString(9, estado);
                pst.setString(10, dt_nascimento);
                pst.setString(11, est_civil);
                pst.setString(12, observacao);
                
                pst.execute();  
                pst.close();

                } 
            catch (SQLException u) 
            {                  
                
                JOptionPane.showMessageDialog(null, u);
                return false;
            } return true; 
           
        }
}
