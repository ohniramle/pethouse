
package DAO;

import bean.Funcionario;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//classe repsonsável por conectar Funcionário Bean no banco de dados com métodos para manipulação e utilização dos dados
public class FuncionárioDAO {
     public void inserir(Funcionario f) throws SQLException{ //método de Inserir Funcionários na tabela
        String sql = "INSERT INTO funcinario(registro, cpf,nome,email,data_nascimento,sexo,cep,endereco,telefone) VALUES (?, ?, ? ,?, ?, ?, ?, ?, ?)";
        Connection con= ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, f.getRegistro());
        stmt.setString(2, f.getCPF());
        stmt.setString(3, f.getNome());
        stmt.setString(4, f.getEmail());
        stmt.setString(5, f.getDataNascimento());
        stmt.setString(6, f.getSexo());
        stmt.setString(7, f.getCEP());
        stmt.setString(8, f.getEndereco());
        stmt.setString(9, f.getTelefone());
        
        stmt.executeUpdate();
        con.close();
           
     
    }
    
    public void atualizar(Funcionario func) {
    String sql = "UPDATE func SET registro = ? , cpf = ?, nome = ?, email = ?, data_nascimento = ?, sexo = ?, cep = ?, endereco = ?, telefone = ? WHERE id_cliente = ?";
    
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, func.getRegistro());
        stmt.setString(2, func.getCPF());
        stmt.setString(3, func.getNome());
        stmt.setString(4, func.getEmail());
        stmt.setString(5, func.getDataNascimento());
        stmt.setString(6, func.getSexo());
        stmt.setString(7, func.getCEP());
        stmt.setString(8, func.getEndereco());
        stmt.setString(9, func.getTelefone());
        stmt.setInt(10, func.getId_funcionario());
        
        stmt.executeUpdate();
        
        
    } catch (SQLException e) {
        
        e.printStackTrace(); //resultado do erro
    }
}
    //Lista que lista todos os clientes
    public List<Funcionario> listarTodos() throws Exception {  //método de listar Funcionários na tabela
      List<Funcionario> ListaFuncionario = new ArrayList<>(); //cria lista de Funcionários para armazenar no ArrayList
      String sql = "SELECT id_funcionario,registro, cpf,nome,email,data_nascimento,sexo,cep,endereco,telefone FROM funcionario ORDER BY id_funcionario";
      
      try(Connection co = ConnectionFactory.getConnection(); //conexão com banco de dados utilizando a classe ConnectionFactory
          PreparedStatement stmt = co.prepareStatement(sql);
          ResultSet rs = stmt.executeQuery()){
          
          while(rs.next()){
              Funcionario f = new Funcionario();
                f.setId_funcionario(rs.getInt("id_funcionario"));
                f.setRegistro(rs.getString("registro"));
                f.setCPF(rs.getString("cpf"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setDataNascimento(rs.getString("data_nascimento"));
                f.setSexo(rs.getString("sexo"));
                f.setCEP(rs.getString("cep"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getString("telefone"));
                
                ListaFuncionario.add(f);
          }
      }
      return ListaFuncionario;
  
  }
   // Método que busca no banco de dados um funcionário específico pelo ID
   // Ele retorna um objeto Funcionário preenchido com os dados vindos do banco 
   public Funcionario buscarPorId(int id){
       Funcionario f = null;
       try{
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = con.prepareStatement("SELECT * FROM  cliente WHERE id_cliente= ?");
           stmt.setInt(1,id); // Substitui o "?" pelo valor do parâmetro id recebido no método
           ResultSet rs=stmt.executeQuery();
           
           //Preenche o objeto com os dados do banco
           if(rs.next()){
               f = new Funcionario();
               f.setId_funcionario(rs.getInt("id_funcionario"));
               f.setRegistro(rs.getString("registro"));
               f.setCPF(rs.getString("cpf"));
               f.setNome(rs.getString("nome"));
               f.setEmail(rs.getString("email"));
               f.setDataNascimento(rs.getString("data_nascimento"));
               f.setSexo(rs.getString("sexo"));
               f.setCEP(rs.getString("cep"));
               f.setEndereco(rs.getString("endereco"));
               f.setTelefone(rs.getString("telefone"));
               
           }
           //fecha a conexão para evitar gasto de memória desnecessário
           rs.close();
           stmt.close();
           con.close();
           
       }catch(Exception e) {
            e.printStackTrace(); //caso aconteça erro , imprime no console
       }
       //retorna o Funcionário encontrado (ou null para não encontrado)
       return f;
   }
   
   //Método utilizado para excluir Funcionário
   public void excluir (int id){
       try{
           Connection con  = ConnectionFactory.getConnection();
           PreparedStatement stmt = con.prepareStatement("DELETE FROM funcionario  WHERE id_funcionario = ?");
           // Substitui o ? pelo Id do Funcionário
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
  
   
        //buscar o ID por nome
        public int buscarIdPorNome(String nomeFuncionario) throws Exception {
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT id_funcionario FROM funcionario WHERE nome = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nomeFuncionario);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("id_funcionario");
        } else {
            throw new Exception("Funcionário não encontrado: " + nomeFuncionario);
        }
    }
    
 /*       //listar Clientes pelo nome para a tabela animal
    public List<Cliente> listarPorNome() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT id_cliente, nome FROM cliente ORDER BY nome";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }*/
        
}
