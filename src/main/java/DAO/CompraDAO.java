
package DAO;

import conexao.ConnectionFactory;
import java.sql.*;
import bean.Compra;
import javax.swing.JOptionPane;

//Classe CompraDAO é responsável por realizar operações no banco de dados relacionadas às compras.
 //permite inserir, listar, buscar e excluir compras.

public class CompraDAO {
    
    
     //método responsável por inserir uma nova compra no banco de dados.
     //recebe um objeto Compra e grava seus dados (id_produto, id_fornecedor, quantidade, valor_total, preco_unitario).
     
    public void inserirCompra(Compra compra) throws SQLException {
        // comando SQL de inserção
        String sql = "INSERT INTO compra (id_produto, id_fornecedor, quantidade, preco_unitario, valor_total) VALUES (?, ?, ?, ?, ?)";
        
        // abre conexão com o banco
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            // define os valores que serão inseridos
            stmt.setInt(1, compra.getIdProduto());       // ID do produto
            stmt.setInt(2, compra.getIdFornecedor());    // ID do fornecedor
            stmt.setInt(3, compra.getQuantidade());      // Quantidade comprada
            stmt.setDouble(4, compra.getPrecoUnitario()); // Preço unitário
            stmt.setDouble(5, compra.getValorTotal());   // Valor total calculado
            
            // executa o comando SQL
            stmt.executeUpdate();
            
            // exibe mensagen de sucesso
            JOptionPane.showMessageDialog(null, "Compra registrada com sucesso!");
            
        } catch (SQLException e) {
            // caso ocorra erro, exibe no console e mostra mensagem de erro ao usuário
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao registrar compra: " + e.getMessage());
        }
    }
    
     //método para excluir uma compra com base no ID
     
    public void excluirCompra(int idCompra) {
        String sql = "DELETE FROM compra WHERE id_compra = ?";
        
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, idCompra);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Compra excluída com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir compra: " + e.getMessage());
        }
    }
    
    
     //Método para buscar uma compra específica pelo ID.
     //Retorna um objeto Compra preenchido com os dados do banco.
     
    public Compra buscarPorId(int idCompra) {
        String sql = "SELECT * FROM compra WHERE id_compra = ?";
        Compra compra = null;
        
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, idCompra);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("id_compra"));
                compra.setIdProduto(rs.getInt("id_produto"));
                compra.setIdFornecedor(rs.getInt("id_fornecedor"));
                compra.setQuantidade(rs.getInt("quantidade"));
                compra.setPrecoUnitario(rs.getDouble("preco_unitario"));
                compra.setValorTotal(rs.getDouble("valor_total"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return compra;
    }
}

