package DAO;

import bean.Estoque;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import bean.Produto;


/* Classe EstoqueDAO
 Responsável pelas operações de CRUD do estoque:
  - Inserir produto no estoque
  - Atualizar quantidades
  - Remover quantidades
  - Consultar quantidade
 - Excluir estoque quando o produto é removido
 */
public class EstoqueDAO {

    
     //Insere um produto no estoque pela primeira vez.
      //Usado quando cadastra um produto novo.
     
    public void inserirNoEstoque(int produtoId, int quantidadeInicial) {
        String sql = "INSERT INTO estoque (id_produto, quantidade) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produtoId);
            stmt.setInt(2, quantidadeInicial);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
     // Aumenta a quantidade no estoque (usado na COMPRA).
     
    public void adicionarQuantidade(int produtoId, int quantidade) {
        String sql = "UPDATE estoque SET quantidade = quantidade + ? WHERE id_produto = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, quantidade);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove quantidade do estoque,
     //verificando se há produto suficiente disponível.
    
    public boolean removerQuantidade(int produtoId, int quantidade) {
        String sql = "UPDATE estoque SET quantidade = quantidade - ? " +
                     "WHERE id_produto = ? AND quantidade >= ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, quantidade);
            stmt.setInt(2, produtoId);
            stmt.setInt(3, quantidade);

            int linhas = stmt.executeUpdate();

            return linhas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
     //Atualiza diretamente uma quantidade no estoque.
     //Usado para correções manuais.
     
    public void definirQuantidade(int produtoId, int novaQuantidade) {
        String sql = "UPDATE estoque SET quantidade = ? WHERE id_produto = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
     // Consulta a quantidade atual do estoque.
     
    public int consultarQuantidade(int produtoId) {
        String sql = "SELECT quantidade FROM estoque WHERE id_produto = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produtoId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("quantidade");
            } else {
                return -1; // produto não encontrado no estoque
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    //método para listar todos os estoques
        public List<Estoque> listarTodos() {
         List<Estoque> lista = new ArrayList<>();

         String sql = "SELECT e.id_estoque, e.id_produto, e.quantidade, p.nome "
                    + "FROM estoque e "
                    + "INNER JOIN produto p ON p.id_produto = e.id_produto "
                    + "ORDER BY p.nome";

         try (Connection conn = ConnectionFactory.getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql);
              ResultSet rs = stmt.executeQuery()) {

             while (rs.next()) {
                 Estoque e = new Estoque();

                 // cria um produto para este estoque
                 Produto p = new Produto();
                 p.setId_produto(rs.getInt("id_produto"));
                 p.setNome(rs.getString("nome"));

                 e.setId_estoque(rs.getInt("id_estoque"));
                 e.setId_produto(p); // produto dentro do objeto estoque
                 e.setQuantidade(rs.getInt("quantidade"));

                 lista.add(e);
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }

       return lista;
}
    
     //Exclui o estoque quando o produto correspondente é excluído.
     // Geralmente chamado no ProdutoDAO.delete().
     
    public void excluirEstoquePorProduto(int produtoId) {
        String sql = "DELETE FROM estoque WHERE id_produto = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produtoId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}