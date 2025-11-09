
package DAO;

import bean.Animal;
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
    
    // Método para listar todos os animais
    public List<Animal> listarTodos() {
        List<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM animal";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
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
    
    // Método para buscar animais de um cliente específico
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
