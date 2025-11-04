
package DAO;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.Login;


public class LoginDAO {
   
    public boolean verificarLogin(String usuarioDigitado, String senhaDigitada) throws SQLException {
       boolean resposta=false;
        try{
           Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt =con.prepareStatement("SELECT * FROM login WHERE usuario = ? AND senha= ? ");
             stmt.setString(1,usuarioDigitado);
             stmt.setString(2, senhaDigitada);
             ResultSet rs = stmt.executeQuery();
             
             Login login = null;
             if(rs.next()){
                 System.out.println("Bem vindo");
                 resposta=true;
              }else{
                     resposta=false;
                 }
             
           rs.close();
           stmt.close();
           con.close();    
        }catch(Exception e){
            e.printStackTrace(); //caso aconteça erro , imprime no console
        }
        return resposta;
    }
}
    
