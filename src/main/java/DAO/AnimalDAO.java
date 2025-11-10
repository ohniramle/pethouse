
package DAO;

import bean.Animal;
import bean.Cliente;
import conexao.ConnectionFactory;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Classe AnimalDAO
 * Responsável por realizar as operações no banco de dados relacionadas aos animais,
 * incluindo inserir, listar, atualizar e excluir.
 * Cada animal pertence a um cliente (relação de dependência).
 */
public class AnimalDAO {
    
    // Método para inserir novo animal no banco
    public void inserir(Animal animal) {
        String sql = "INSERT INTO animal (nome, data_nascimento, sexo, especie, peso, porte, id_cliente) VALUES (?, ?, ?, ?, ?,?,?)";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, animal.getNome());
            stmt.setString(2,animal.getDataNascimento());
            stmt.setString(3, animal.getSexo());
            stmt.setString(4, animal.getEspecie());
            
            stmt.setDouble(5, animal.getPeso());
            stmt.setString(6, animal.getPorte());
            stmt.setInt(7, animal.getIdCliente());
            
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar animal: " + e.getMessage());
        }
    }
    //método para atualizar dados no banco
     public void atualizar(Animal animal) {
        String sql = "UPDATE animal SET nome = ?, data_nascimento = ?, sexo = ?, especie= ?, peso = ?, porte = ? WHERE id_animal = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getDataNascimento());
            stmt.setString(3, animal.getSexo());
            stmt.setString(4, animal.getEspecie());
            stmt.setDouble(5, animal.getPeso());
            stmt.setString(6, animal.getPorte());
            stmt.setInt(7, animal.getIdAnimal());
           

            stmt.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
    
    
    // Método para excluir um animal pelo ID
    public void excluir(int idAnimal) {
        String sql = "DELETE FROM animal WHERE id_animal = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idAnimal);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Animal excluído com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir animal: " + e.getMessage());
        }
    }
    
    //método para buscar por ID o animal
    public Animal buscarPorId(int id){
       Animal animal = null;
       try{
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = con.prepareStatement("SELECT * FROM  animal WHERE id_animal= ?");
           stmt.setInt(1,id); // Substitui o "?" pelo valor do parâmetro id recebido no método
           ResultSet rs=stmt.executeQuery();
           
           //Preenche o objeto com os dados do banco
           if(rs.next()){
               animal = new Animal();
               animal.setIdAnimal(rs.getInt("id_animal"));
               
               animal.setNome(rs.getString("nome"));
               
               animal.setDataNascimento(rs.getString("data_nascimento"));
               animal.setSexo(rs.getString("sexo"));
               animal.setEspecie(rs.getString("especie"));
               animal.setPeso(rs.getDouble("peso"));
               animal.setPorte(rs.getString("porte"));
               animal.setIdCliente(rs.getInt("id_cliente"));
               
           }
           //Fecha os recursos para evitar gasto de memória
           rs.close();
           stmt.close();
           con.close();
           
       }catch(Exception e) {
            e.printStackTrace(); //caso aconteça erro , imprime no console
       }
       //retorna o cliente encontrado (ou null para não encontrado)
       return animal;
   }
    
    // Método para buscar animais de um animal específico
    public List<Animal> listarPorCliente(int idCliente) {
        List<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM animal WHERE id_cliente = ?";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Animal a = new Animal();
                a.setIdAnimal(rs.getInt("id_animal"));
                a.setNome(rs.getString("nome"));
                a.setDataNascimento(rs.getString("data_nascimento"));
                a.setSexo(rs.getString("sexo"));
                a.setEspecie(rs.getString("especie"));
                a.setPeso(rs.getDouble("peso"));
                a.setPorte(rs.getString("porte"));
                a.setIdCliente(rs.getInt("id_cliente"));
                lista.add(a);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
