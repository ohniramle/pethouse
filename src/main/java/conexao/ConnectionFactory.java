//Classe que conecta ao banco de dados

package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {
  
    private static final String URL =
            "jdbc:mysql://localhost:3306/PetHouse";  //String recebe o camnho do diretório do driver até o banco

    private static final String USER = "root"; //String recebe o user do banco
    private static final String PASSWORD = "root"; //String recebe a senha do banco
   
   public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD); 
        }
          
 }

