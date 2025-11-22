
package DAO;
import bean.Agendamento;
import java.sql.Connection;
import conexao.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.*;
import java.util.ArrayList;
import java.util.List;


//Classe DAO responsável por criar métodos para manipular, inserir e excluir informações de Agendamento

public class AgendamentoDAO {
    
    //método para inserir um agendamento
     public void inserir(Agendamento a) {
        try {
            String sql = "INSERT INTO agendamento (id_agendamento, data, hora, status, FK_id_cliente, FK_id_funcionario , FK_id_servico,FK_id_animal"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,a.getId_agendamento());
            stmt.setString(2, a.getData());
            stmt.setString(3, a.getHora());
            stmt.setString(4, a.getStatus());
            stmt.setInt(5, a.getCliente().getId_cliente());
            stmt.setInt(6, a.getFuncionario().getId_funcionario());
            stmt.setInt(7, a.getServico().getId_servico());  
            stmt.setInt(8, a.getAnimal().getIdAnimal());
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao inserir agendamento: " + erro.getMessage());
        }
    }
     
     //método de atualizar um agendamento
     
     public void alterar(Agendamento a) {

        try {
            String sql = "UPDATE agendamento SET dataAgendamento = ?, "
                    + "horario = ?, "
                    + "status = ?, "
                    + "FK_id_cliente = ?, "
                    + "FK_id_funcionario = ?, "
                    + "FK_id_servico = ?, "
                    + "FK_id_animal = ? "
                    + "WHERE id_agendamento = ?";

            Connection con = ConnectionFactory.getConnection(); //conexão com banco de dados
            PreparedStatement stmt = con.prepareStatement(sql); //prepara para executar

            stmt.setString(1, a.getData());
            stmt.setString(2, a.getHora());
            stmt.setString(3, a.getStatus());
            stmt.setInt(4, a.getCliente().getId_cliente());
            stmt.setInt(5, a.getFuncionario().getId_funcionario());
            stmt.setInt(6, a.getServico().getId_servico());
            stmt.setInt(7, a.getAnimal().getIdAnimal());
            stmt.setInt(8, a.getId_agendamento());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao alterar agendamento: " + erro.getMessage());
        }
    }
     
     //método para excluir um agendamento
     public void excluir(int id) {

        try {
            String sql = "DELETE FROM agendamento WHERE id_agendamento = ?";

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao excluir agendamento: " + erro.getMessage());
        }
    }
     //método para buscar um agendamento pelo id
      public Agendamento buscarPorId(int id) {

        try {
            String sql = "SELECT * FROM agendamento WHERE id_agendamento = ?";

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Agendamento a = new Agendamento();
                a.setId_agendamento(rs.getInt("id_agendamento"));
                a.setData(rs.getString("dataAgendamento"));
                a.setHora(rs.getString("horario"));
                a.setStatus(rs.getString("status"));

                // instancia os objetos relacionados
                Cliente c = new Cliente();
                c.setId_cliente(rs.getInt("FK_id_cliente"));
                a.setCliente(c);

                Funcionario f = new Funcionario();
                f.setId_funcionario(rs.getInt("FK_id_funcionario"));
                a.setFuncionario(f);

                Servico s = new Servico();
                s.setId_servico(rs.getInt("FK_id_servico"));
                a.setServico(s);

                Animal an = new Animal();
                an.setIdAnimal(rs.getInt("FK_id_animal"));
                a.setAnimal(an);

                stmt.close();
                return a;
            }

            stmt.close();
            return null;

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao buscar agendamento por ID: " + erro.getMessage());
        }
    }
      
      ///método para Listar todos os agendamentos
      public List<Agendamento> listarTodos() {

    try {
        List<Agendamento> lista = new ArrayList<>();

        String sql = "SELECT * FROM agendamento";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Agendamento a = new Agendamento();

            a.setId_agendamento(rs.getInt("id_agendamento"));
            a.setData(rs.getString("dataAgendamento"));
            a.setHora(rs.getString("horario"));
            a.setStatus(rs.getString("status"));

            // cliente
            Cliente c = new Cliente();
            c.setId_cliente(rs.getInt("FK_id_cliente"));
            a.setCliente(c);

            // funcionário
            Funcionario f = new Funcionario();
            f.setId_funcionario(rs.getInt("FK_id_funcionario"));
            a.setFuncionario(f);

            // serviço
            Servico s = new Servico();
            s.setId_servico(rs.getInt("FK_id_servico"));
            a.setServico(s);

            // animal
            Animal an = new Animal();
            an.setIdAnimal(rs.getInt("FK_id_animal"));
            a.setAnimal(an);

            lista.add(a);
        }

        stmt.close();
        return lista;

    } catch (SQLException erro) {
        throw new RuntimeException("Erro ao listar agendamentos: " + erro.getMessage());
        }
     }
      
     //método para marcar um agendamento como FEITO. Somente muda o valor de status
     public void marcarComoFeito(int id) {

        try {
            String sql = "UPDATE agendamento SET status = 'FEITO' WHERE id_agendamento = ?";

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao marcar agendamento como feito: " + erro.getMessage());
        }
     }
 }

