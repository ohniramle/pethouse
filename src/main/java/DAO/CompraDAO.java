
package DAO;

import conexao.ConnectionFactory;
import java.sql.*;
import bean.Compra;
import bean.Fornecedor;
import bean.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//Classe CompraDAO é responsável por realizar operações no banco de dados relacionadas às compras.
 //permite inserir, listar, buscar e excluir compras.

public class CompraDAO {
    
    
     //método responsável por inserir uma nova compra no banco de dados.
     //recebe um objeto Compra e grava seus dados (id_produto, id_fornecedor, quantidade, valor_total, preco_unitario).
     
    public void inserirCompra(Compra compra) throws SQLException {
        // comando SQL de inserção
        String sql = "INSERT INTO compra (dataCompra, id_produto, id_fornecedor, qt_produtos, preco_unitario, valor_total) VALUES (?,?, ?, ?, ?, ?)";
        
        // abre conexão com o banco
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            // define os valores que serão inseridos
            stmt.setString(1,compra.getDataCompra());
            stmt.setInt(2, compra.getProduto().getId_produto());      // ID do produto
            stmt.setInt(3, compra.getFornecedor().getId_fornecedor());   // ID do fornecedor
            stmt.setInt(4, compra.getQuantidade());      // Quantidade comprada
            stmt.setDouble(5, compra.getPrecoUnitario()); // Preço unitário
            stmt.setDouble(6, compra.getValorTotal());   // Valor total calculado
            
            // executa o comando SQL
            stmt.executeUpdate();
            
            
            
        } catch (SQLException e) {
            // caso ocorra erro, exibe no console e mostra mensagem de erro ao usuário
            e.printStackTrace();
            
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
            
        }
    }
    
    // ATUALIZAR COMPRA
    public void atualizarCompra(Compra c) {
        try {
            String sql = "UPDATE compra SET "
                       + "id_produto = ?, "
                       + "dataCompra = ?, "
                       + "id_fornecedor = ?, "
                       + "preco_unitario = ?, "
                       + "qt_produtos = ?, "
                       + "valor_total = ? "
                       + "WHERE id_compra = ?";

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, c.getProduto().getId_produto());
            stmt.setString(2, c.getDataCompra());
            stmt.setInt(3, c.getFornecedor().getId_fornecedor());
            stmt.setDouble(4, c.getPrecoUnitario());
            stmt.setInt(5, c.getQuantidade());
            stmt.setDouble(6, c.getValorTotal());
            stmt.setInt(7, c.getIdCompra());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao atualizar compra: " + erro.getMessage());
        }
    }
    
    //método para listar todas as compras
   public List<Compra> listarTodas() throws SQLException {
    List<Compra> lista = new ArrayList<>();

    String sql = 
            "SELECT c.id_compra, c.dataCompra, c.qt_produtos, c.preco_unitario, c.valor_total, "
          + "p.id_produto, p.nome AS produto_nome, p.descricao AS produto_descricao, p.preco AS produto_preco, "
          + "f.id_fornecedor, f.nome AS fornecedor_nome "
          + "FROM compra c "
          + "JOIN produto p ON c.id_produto = p.id_produto "
          + "JOIN fornecedor f ON c.id_fornecedor = f.id_fornecedor";

    try (Connection con = ConnectionFactory.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {

            Compra compra = new Compra();
            compra.setIdCompra(rs.getInt("id_compra"));
            compra.setDataCompra(rs.getString("dataCompra"));
            compra.setQuantidade(rs.getInt("qt_produtos"));
            compra.setPrecoUnitario(rs.getDouble("preco_unitario"));
            compra.setValorTotal(rs.getDouble("valor_total"));

            // PRODUTO
            Produto produto = new Produto();
            produto.setId_produto(rs.getInt("id_produto"));
            produto.setNome(rs.getString("produto_nome"));
            produto.setDescricao(rs.getString("produto_descricao"));
            produto.setPreco(rs.getDouble("produto_preco"));
            compra.setProduto(produto);

            // FORNECEDOR
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId_fornecedor(rs.getInt("id_fornecedor"));
            fornecedor.setNome(rs.getString("fornecedor_nome"));
            compra.setFornecedor(fornecedor);

            lista.add(compra);
        }
    }

    return lista;
}

     //Método para buscar uma compra específica pelo ID.
     //Retorna um objeto Compra preenchido com os dados do banco.
     
    public Compra buscarPorId(int idCompra) {
        String sql = 
            "SELECT c.*, p.nome AS produto_nome, p.descricao AS produto_desc, "
            + "f.nome AS fornecedor_nome "
            + "FROM compra c "
            + "JOIN produto p ON c.id_produto = p.id_produto "
            + "JOIN fornecedor f ON c.id_fornecedor = f.id_fornecedor "
            + "WHERE c.id_compra = ?";

        Compra compra = null;

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idCompra);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("id_compra"));
                compra.setDataCompra(rs.getString("dataCompra"));
                compra.setQuantidade(rs.getInt("qt_produtos"));
                compra.setPrecoUnitario(rs.getDouble("preco_unitario"));
                compra.setValorTotal(rs.getDouble("valor_total"));

                // Produto completo
                Produto p = new Produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setNome(rs.getString("produto_nome"));
                p.setDescricao(rs.getString("produto_desc"));
                compra.setProduto(p);

                // Fornecedor completo
                Fornecedor f = new Fornecedor();
                f.setId_fornecedor(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("fornecedor_nome"));
                compra.setFornecedor(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compra;
       }
}

