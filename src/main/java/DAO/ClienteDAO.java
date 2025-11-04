
package DAO;

import conexao.ConnectionFactory;
import java.util.*;
import java.sql.*;
import bean.Cliente;
public class ClienteDAO {
    
    public void inserir(Cliente c) throws SQLException{ //método de Inserir clientes na tabela
        String sql = "INSERT INTO cliente(cpf,nome,email,data_nascimento,sexo,cep,endereco,telefone) VALUES (?, ? ,?, ?, ?, ?, ?, ?)";
        Connection con= ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, c.getCPF());
        stmt.setString(2, c.getNome());
        stmt.setString(3, c.getEmail());
        stmt.setString(4, c.getDataNascimento());
        stmt.setString(5, c.getSexo());
        stmt.setString(6, c.getCEP());
        stmt.setString(7, c.getEndereco());
        stmt.setString(8, c.getTelefone());
        
        stmt.executeUpdate();
        con.close();
           
       
   

    }
    //Lista que lista todos os clientes
    public List<Cliente> listarTodos() throws Exception {  //método de listar clientes na tabela
      List<Cliente> ListaCliente = new ArrayList<>(); //Cria lista de clientes para armazenar no ArrayList
      String sql = "SELECT id_cliente,cpf,nome,email,data_nascimento,sexo,cep,endereco,telefone FROM cliente ORDER BY id_cliente";
      
      try(Connection c = ConnectionFactory.getConnection(); //conexão com banco de dados utilizando a classe ConnectionFactory
          PreparedStatement stmt = c.prepareStatement(sql);
          ResultSet rs = stmt.executeQuery()){
          
          while(rs.next()){
              Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setCEP(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                
                ListaCliente.add(cliente);
          }
      }
      return ListaCliente;
  
  }
   // Método que busca no banco de dados um cliente específico pelo ID
   // Ele retorna um objeto Cliente preenchido com os dados vindos do banco 
   public Cliente buscarPorId(int id){
       Cliente cliente = null;
       try{
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = con.prepareStatement("SELECT * FROM  cliente WHERE id_cliente= ?");
           stmt.setInt(1,id); // Substitui o "?" pelo valor do parâmetro id recebido no método
           ResultSet rs=stmt.executeQuery();
           
           //Preenche o objeto com os dados do banco
           if(rs.next()){
               cliente = new Cliente();
               cliente.setId_cliente(rs.getInt("id_cliente"));
               cliente.setCPF(rs.getString("cpf"));
               cliente.setNome(rs.getString("nome"));
               cliente.setNome(rs.getString("nome"));
               cliente.setEmail(rs.getString("email"));
               cliente.setDataNascimento(rs.getString("data_nascimento"));
               cliente.setSexo(rs.getString("sexo"));
               cliente.setCEP(rs.getString("cep"));
               cliente.setEndereco(rs.getString("endereco"));
               cliente.setTelefone(rs.getString("telefone"));
               
           }
           //Fecha os recursos para evitar gasto de memória desnecessário
           rs.close();
           stmt.close();
           con.close();
           
       }catch(Exception e) {
            e.printStackTrace(); //caso aconteça erro , imprime no console
       }
       //retorna o cliente encontrado (ou null para não encontrado)
       return cliente;
   }
   
   //Método utilizado para excluir cliente
   public void excluir (int id){
       try{
           Connection con  = ConnectionFactory.getConnection();
           PreparedStatement stmt = con.prepareStatement("DELETE FROM cliente  WHERE id_cliente = ?");
           // Substitui o ? pelo Id do Cliente
           stmt.setInt(1,id);
           //executa o comando
           stmt.executeUpdate();
           //fecha a conexão
           stmt.close();
           con.close();
           System.out.println("Excluído com sucesso");
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
}
