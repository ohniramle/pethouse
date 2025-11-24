
package DAO;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import bean.Fornecedor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    
     public void cadastrarFornecedor(Fornecedor fornecedor) {
       //Método para inserir novos fornecedores
         try {
            Connection con= ConnectionFactory.getConnection(); //conectar ao banco de dados
            String sql = "INSERT INTO fornecedor (cnpj, nome, email, telefone, endereco, cep) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql); //preparar para executar a query

            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getEndereco());
            stmt.setString(6, fornecedor.getCep());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar fornecedor: " + e.getMessage(), e);
        }
    }
     
     //método para atualizar dados do fornecedor
      public void atualizarFornecedor(Fornecedor fornecedor) {
        try {
            Connection con= ConnectionFactory.getConnection(); //conectar ao banco de dados
            String sql = "UPDATE fornecedor SET cnpj=?, nome=?, email=?, telefone=?, endereco=?, cep=? "
                       + "WHERE id_fornecedor=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.setString(5, fornecedor.getEndereco());
            stmt.setString(6, fornecedor.getCep());
            stmt.setInt(7, fornecedor.getId_fornecedor());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar fornecedor: " + e.getMessage(), e);
        }
    }
      public void excluirFornecedor(int id) {
        try {
            Connection con= ConnectionFactory.getConnection(); //conectar ao banco de dados
            String sql = "DELETE FROM fornecedor WHERE id_fornecedor=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir fornecedor: " + e.getMessage(), e);
        }
    }
      
      //método para buscar um fornecedor pelo seu ID
       public Fornecedor buscarPorId(int id) {
      
        try {
            String sql = "SELECT * FROM fornecedor WHERE id_fornecedor=?";
            Connection con= ConnectionFactory.getConnection(); //conectar ao banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            Fornecedor f = null;

            if (rs.next()) {
                f = new Fornecedor();
                f.setId_fornecedor(rs.getInt("id_fornecedor"));
                f.setCnpj(rs.getString("cnpj"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setCep(rs.getString("cep"));
            }

            rs.close();
            stmt.close();

            return f;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar fornecedor: " + e.getMessage(), e);
        }
    }
       
       //método para listar todos os fornecedores
        public List<Fornecedor> listarFornecedores() {
        List<Fornecedor> lista = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM fornecedor ORDER BY nome";
            Connection con= ConnectionFactory.getConnection(); //conectar ao banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId_fornecedor(rs.getInt("id_fornecedor"));
                f.setCnpj(rs.getString("cnpj"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setCep(rs.getString("cep"));

                lista.add(f);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar fornecedores: " + e.getMessage(), e);
        }

        return lista;
    }
        
}
