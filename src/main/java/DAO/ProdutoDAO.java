
package DAO;
import conexao.ConnectionFactory;
import java.util.*;
import java.sql.*;
import bean.Produto;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    
    public void inserir(Produto p) throws SQLException{ //método de Inserir produtos na tabela
        String sql = "INSERT INTO cliente(id_produto,nome,valor,descricao,id_fornecedor) VALUES (?, ? ,?, ?,?)";
        Connection con= ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, p.getId_produto());
        stmt.setString(2, p.getNome());
        stmt.setDouble(1, p.getPreco());
        stmt.setString(3, p.getDescricao());
        stmt.setInt(4,p.getFornecedor());
        
        stmt.executeUpdate();
        con.close();
           
     
    }
    
    public void atualizar(Produto produto) {
    String sql = "UPDATE produto SET id_produto = ?, nome = ?, preco = ?, descricao = ?";
    
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, produto.getId_produto());
        stmt.setString(2, produto.getNome());
        stmt.setDouble(3, produto.getPreco());
        stmt.setString(4,produto.getDescricao());
        
        stmt.executeUpdate();
        
        
    } catch (SQLException e) {
        
        e.printStackTrace();
    }
}
    //Lista que lista todos os produtos
    public List<Produto> listarTodos() throws Exception {  //método de listar produto na tabela
      List<Produto> ListaProduto= new ArrayList<>(); //Cria lista de produto para armazenar no ArrayList
      String sql = "SELECT id_produto,nome, preco, descrcao FROM produto ORDER BY id_produto";
      
      try(Connection c = ConnectionFactory.getConnection(); //conexão com banco de dados utilizando a classe ConnectionFactory
          PreparedStatement stmt = c.prepareStatement(sql);
          ResultSet rs = stmt.executeQuery()){
          
          while(rs.next()){
              Produto produto = new Produto();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setDescricao(rs.getString("descricao"));
                
                ListaProduto.add(produto);
          }
      }
      return ListaProduto;
  
  }
   // Método que busca no banco de dados um produto específico pelo ID
   // Ele retorna um objeto Produto preenchido com os dados vindos do banco 
   public Produto buscarPorId(int id){
       Produto produto = null;
       try{
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = con.prepareStatement("SELECT * FROM  produto WHERE id_produto= ?");
           stmt.setInt(1,id); // Substitui o "?" pelo valor do parâmetro id recebido no método
           ResultSet rs=stmt.executeQuery();
           
           //Preenche o objeto com os dados do banco
           if(rs.next()){
               produto = new Produto();
               produto.setNome(rs.getString("nome"));
               produto.setPreco(rs.getDouble("preco"));
               produto.setDescricao(rs.getString("descricao"));
               
           }
           //Fecha os recursos para evitar gasto de memória desnecessário
           rs.close();
           stmt.close();
           con.close();
           
       }catch(Exception e) {
            e.printStackTrace(); //caso aconteça erro , imprime no console
       }
       //retorna o produto encontrado (ou null para não encontrado)
       return produto;
   }
   
   //Método utilizado para excluir produto
   public void excluir (int id){
       try{
           Connection con  = ConnectionFactory.getConnection();
           PreparedStatement stmt = con.prepareStatement("DELETE FROM produto  WHERE id_produto = ?");
           // Substitui o ? pelo Id do Produto
           stmt.setInt(1,id);
           //executa o comando
           stmt.executeUpdate();
           //fecha a conexão
           stmt.close();
           con.close();
           
       }catch(Exception e){
           e.printStackTrace();
       }
   }
    // método responsável por inserir um produto no banco de dados
    // e retornar o ID gerado automaticamente (chave primária).
    public int inserirERetornarID(Produto p) throws SQLException {
    // comando SQL para inserir os dados do produto.
    // os valores serão substituídos pelos parâmetros definidos no PreparedStatement.
    String sql = "INSERT INTO produto (nome, preco, descricao, id_fornecedor) VALUES (?, ?, ?, ?)";
    
    // variável para armazenar o ID gerado após a inserção.
    int idGerado = -1;

    // bloco para garantir que a conexão seja fechada automaticamente
    try (Connection con = ConnectionFactory.getConnection();
         // o parâmetro "Statement.RETURN_GENERATED_KEYS" permite recuperar o ID gerado pelo banco.
         PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        // substitui os parâmetros da query pelos valores vindos do objeto Produto
        stmt.setString(1, p.getNome());          // define o nome do produto
        stmt.setDouble(2, p.getPreco());         // define o preço unitário
        stmt.setString(3, p.getDescricao());     // define a descrição do produto
        stmt.setInt(4, p.getFornecedor());       // define o ID do fornecedor

        // executa o comando de inserção.
        stmt.executeUpdate();

        // recupera o ID gerado automaticamente pelo banco (chave primária).
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1); // pega o primeiro valor retornado (o ID)
        }
    }

    // retorna o ID gerado para que possa ser usado em outras operações (compra, estoque, etc).
    return idGerado;
    }

   
  
}


