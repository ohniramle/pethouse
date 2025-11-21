
package DAO;
import bean.Servico;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ServicoDAO {
    
    //método para inserir um novo servico
    
    public void inserirServico(Servico servico){
        // comando SQL de inserção
        String sql = "INSERT INTO servico (id_servico, nome, descricao, preco) VALUES (?, ?, ?, ?)";
        
        // abre conexão com o banco
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            // define os valores que serão inseridos
            stmt.setInt(1, servico.getId_servico());     // ID do produto
            stmt.setString(2, servico.getNome());    // nome do serviço
            stmt.setString(3,servico.getDescricao());  //descrição
            stmt.setDouble(4, servico.getPreco()); // Preço
  
            // executa o comando SQL
            stmt.executeUpdate();
            
          
            
        } catch (SQLException e) {
            // caso ocorra erro, exibe no console e mostra mensagem de erro ao usuário
            e.printStackTrace();
            
        }
        
    }
    //método para atualizar dados na tabela de serviços
    public void atualizarServico(Servico servico){
        
        //código sql para atualizar banco
        String sql = "UPDATE servico SET nome = ? , descricao = ? , preco= ? WHERE id_servico = ?";
        //abre conexão com banco utilizando a nossa classe ConnectionFactory no pacote conexao
        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            
            stmt.setString(1, servico.getNome());
            stmt.setString(2,servico.getDescricao());
            stmt.setDouble(3,servico.getPreco());
            stmt.setInt(4, servico.getId_servico());
            
            stmt.executeUpdate();
            
        }catch( SQLException e){
             e.printStackTrace(); //resultado do erro
        }
    }
    
    //método para escluir um serviço
    public void excluirServico (int id){
       try{
           Connection con  = ConnectionFactory.getConnection();
           PreparedStatement stmt = con.prepareStatement("DELETE FROM servico  WHERE id_servico = ?");
           // Substitui o ? pelo Id do Servico
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
    
     public Servico buscarPorId(int id){
       Servico servico = null;
       try{
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = con.prepareStatement("SELECT * FROM  servico WHERE id_servico= ?");
           stmt.setInt(1,id); // Substitui o "?" pelo valor do parâmetro id recebido no método
           ResultSet rs=stmt.executeQuery();
           
           //Preenche o objeto com os dados do banco
           if(rs.next()){
               servico = new Servico();
               servico.setId_servico(rs.getInt("id_servico"));
               servico.setNome(rs.getString("nome"));
               servico.setDescricao(rs.getString("descricao"));
               servico.setPreco(rs.getDouble("preco"));
              
               
           }
           //fecha a conexão com bancos para evitar gasto de memória desnecessário
           rs.close();
           stmt.close();
           con.close();
           
       }catch(Exception e) {
            e.printStackTrace(); //caso aconteça erro , imprime no console
       }
       //retorna o serviço encontrado (ou null para não encontrado)
       return servico;
   }
     
     //Lista que lista todos os Serviços cadastrados
    public List<Servico> listarTodos() throws Exception {  //método de listar serviços na tabela
      List <Servico> ListaServico = new ArrayList<>(); //cria lista de clientes para armazenar no ArrayList
      String sql = "SELECT id_servico,nome,descricao,preco FROM servico ORDER BY id_servico";
      
      try(Connection co = ConnectionFactory.getConnection(); //conexão com banco de dados utilizando a classe ConnectionFactory
          PreparedStatement stmt = co.prepareStatement(sql);
          ResultSet rs = stmt.executeQuery()){
          
          while(rs.next()){
              Servico s = new Servico(); //instancia um objeto do tipo Serviço do pacote Bean (classe)
                s.setId_servico(rs.getInt("id_servico"));
                s.setNome(rs.getString("nome"));
                s.setDescricao(rs.getString("descricao"));
                s.setPreco(rs.getDouble("preco"));
               
                
                ListaServico.add(s); //adiciona na lista os itens do tipo Serviço
          }
      }
      return ListaServico;
  
    }
}
