
package DAO;
import bean.ProdutoEstoque;
import conexao.ConnectionFactory;
import java.util.*;
import java.sql.*;


public class ProdutoEstoqueDAO {
    /*public List<ProdutoEstoqueDAO> listarComValorTotal() {
    List<ProdutoEstoqueDAO> lista = new ArrayList<>();

    String sql = "SELECT p.id, p.nome, p.preco_unitario, e.quantidade, " +
                 "(p.preco_unitario * e.quantidade) AS valor_total " +
                 "FROM produto p " +
                 "INNER JOIN estoque e ON p.id = e.produto_id";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            ProdutoEstoqueDAO dao = new ProdutoEstoqueDAO ();
            dao.setId(rs.getInt("id"));
            dao.setNome(rs.getString("nome"));
            dao.setPrecoUnitario(rs.getDouble("preco_unitario"));
            dao.setQuantidade(rs.getInt("quantidade"));
            dao.setValorTotal(rs.getDouble("valor_total"));
            lista.add(dao);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}*/
}
