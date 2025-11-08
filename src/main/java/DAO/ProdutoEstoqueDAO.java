
package DAO;

import bean.ProdutoEstoque;
import conexao.ConnectionFactory;
import java.util.*;
import java.sql.*;

/**
 * DAO responsável por consultas que juntam dados de produto + estoque
 * para exibição (não altera o banco).
 */
public class ProdutoEstoqueDAO {

    
    public List<ProdutoEstoque> listarComValorTotal() {
        List<ProdutoEstoque> lista = new ArrayList<>();

       
        String sql = "SELECT p.id_produto AS id_produto, p.nome, p.preco_unitario, e.quantidade, " +
                     "(p.preco_unitario * e.quantidade) AS valor_total " +
                     "FROM produto p " +
                     "INNER JOIN estoque e ON p.id_produto = e.id_produto";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Cria o bean e preenche com os valores vindos do ResultSet
                ProdutoEstoque produtoEstoque = new ProdutoEstoque();

               
                produtoEstoque.setId(rs.getInt("id_produto"));          
                produtoEstoque.setNome(rs.getString("nome"));
                produtoEstoque.setPrecoUnitario(rs.getDouble("preco_unitario"));
                produtoEstoque.setQuantidade(rs.getInt("quantidade"));
                produtoEstoque.setValorTotal(rs.getDouble("valor_total"));

                lista.add(produtoEstoque);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
