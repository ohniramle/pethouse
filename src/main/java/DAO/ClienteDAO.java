
package DAO;

import conexao.ConnectionFactory;
import java.util.*;
import java.sql.*;
import bean.Cliente;
import javax.swing.JOptionPane;
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
    
    public void atualizar(Cliente cliente) {
    String sql = "UPDATE clientes SET cpf = ?, nome = ?, email = ?, data_nascimento = ?, sexo = ?, cep = ?, endereco = ?, telefone = ? WHERE id = ?";
    
    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, cliente.getCPF());
        stmt.setString(2, cliente.getNome());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getDataNascimento());
        stmt.setString(5, cliente.getSexo());
        stmt.setString(6, cliente.getCEP());
        stmt.setString(7, cliente.getEndereco());
        stmt.setString(8, cliente.getTelefone());
        stmt.setInt(9, cliente.getId_cliente());
        
        stmt.executeUpdate();
        
        
    } catch (SQLException e) {
        
        e.printStackTrace();
    }
}
    //Lista que lista todos os clientes
    public List<Cliente> listarTodos() throws Exception {  //método de listar clientes na tabela
      List<Cliente> ListaCliente = new ArrayList<>(); //cria lista de clientes para armazenar no ArrayList
      String sql = "SELECT id_cliente,cpf,nome,email,data_nascimento,sexo,cep,endereco,telefone FROM cliente ORDER BY id_cliente";
      
      try(Connection co = ConnectionFactory.getConnection(); //conexão com banco de dados utilizando a classe ConnectionFactory
          PreparedStatement stmt = co.prepareStatement(sql);
          ResultSet rs = stmt.executeQuery()){
          
          while(rs.next()){
              Cliente c = new Cliente();
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setCPF(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setDataNascimento(rs.getString("data_nascimento"));
                c.setSexo(rs.getString("sexo"));
                c.setCEP(rs.getString("cep"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                
                ListaCliente.add(c);
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
           
       }catch(Exception e){
           e.printStackTrace();
       }
   }
  
   
        //buscar o ID por nome
        public int buscarIdPorNome(String nomeCliente) throws Exception {
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT id_cliente FROM cliente WHERE nome = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nomeCliente);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("id_cliente");
        } else {
            throw new Exception("Cliente não encontrado: " + nomeCliente);
        }
    }
    
        //listar Clientes pelo nome para a tabela animal
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
    }
   
}
