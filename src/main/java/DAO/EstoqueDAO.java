
package DAO;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class EstoqueDAO {
    
/**
 * Classe EstoqueDAO
 * Responsável por realizar todas as operações relacionadas ao estoque dos produtos,
 * como adicionar, remover, consultar e atualizar a quantidade disponível.
 */
    //metodo para adicionar produto no estoque, e caso ele não exista ele cria o registro
     public void adicionarEstoque(int produtoId, int quantidade) {
        String sql = "UPDATE estoque SET quantidade = quantidade + ? WHERE id_produto = ?"; //código sql que soma a quantidade que já possui no banco (caso tiver)

        try (Connection conn = ConnectionFactory.getConnection(); //tenta conexão com banco de dados pegando a classe do pacote conexao e a classe Connection
             PreparedStatement stmt = conn.prepareStatement(sql)) { //prepara para executar o comando sql
            //define os parametros da query
            stmt.setInt(1, quantidade); 
            stmt.setInt(2, produtoId);
            //executa a atualização
            int linhasAfetadas = stmt.executeUpdate();
            
            // se o produto ainda não existe no estoque, cria o registro
            if (linhasAfetadas == 0) {
                // se o produto ainda não existe no estoque, cria o registro
                String insertSql = "INSERT INTO estoque (id_produto, quantidade) VALUES (?, ?)";
                try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                    insertStmt.setInt(1, produtoId);
                    insertStmt.setInt(2, quantidade);
                    insertStmt.executeUpdate(); //executa a query
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     //método para REMOVER uma quantidade de produtos no estoque
     //ele apenas realiza a operação caso a quantidade disponível for suficiente, caso contrário não executa
      public void removerEstoque(int produtoId, int quantidade) {
        // SQL que subtrai a quantidade desejada, garantindo que não fique negativa
        String sql = "UPDATE estoque SET quantidade = quantidade - ? WHERE id_produto = ? AND quantidade >= ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // define os parâmetros: quantidade a remover e ID do produto
            stmt.setInt(1, quantidade);
            stmt.setInt(2, produtoId);
            stmt.setInt(3, quantidade);

            // executa a atualização
            int linhasAfetadas = stmt.executeUpdate();

            // caso nenhuma linha seja alterada, significa que o produto não existe
            // ou não tem estoque suficiente
            if (linhasAfetadas == 0) {
                JOptionPane.showMessageDialog(null,"Estoque insuficiente ou produto inexistente!");
            }else{
                JOptionPane.showMessageDialog(null,"Produto retirado!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
      /*Método para ATUALIZAR diretamente a quantidade de um produto no estoque.
        É útil para correções manuais ou ajustes.*/
      
       public void atualizarQuantidade(int produtoId, int novaQuantidade) {
        // SQL que define a nova quantidade do produto
        String sql = "UPDATE estoque SET quantidade = ? WHERE id_produto = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define os valores dos parâmetros
            stmt.setInt(1, novaQuantidade);
            stmt.setInt(2, produtoId);

            // Executa a atualização
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
