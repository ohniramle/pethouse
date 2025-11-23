
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
    
    //método para inserir agendamento 
    public void inserir(Agendamento a) {
        try {
            String sql = "INSERT INTO agendamento "
                    + "(dataAgendamento, horario, status, FK_id_cliente, FK_id_funcionario, FK_id_servico, FK_id_animal) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, a.getData());
            stmt.setString(2, a.getHora());
            stmt.setString(3, a.getStatus());
            stmt.setInt(4, a.getCliente().getId_cliente());
            stmt.setInt(5, a.getFuncionario().getId_funcionario());
            stmt.setInt(6, a.getServico().getId_servico());
            stmt.setInt(7, a.getAnimal().getIdAnimal()); 

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
     

   public List<Agendamento> listarTodos() throws Exception {
    List<Agendamento> lista = new ArrayList<>();
    
    String sql = "SELECT a.id_agendamento, a.dataAgendamento, a.horario, a.status, "
               + "c.id_cliente, c.nome AS cliente_nome, "
               + "f.id_funcionario, f.nome AS funcionario_nome, "
               + "s.id_servico, s.nome AS servico_nome, "
               + "an.id_animal, an.nome AS animal_nome "
               + "FROM agendamento a "
               + "INNER JOIN cliente c ON c.id_cliente = a.FK_id_cliente "
               + "INNER JOIN funcionario f ON f.id_funcionario = a.FK_id_funcionario "
               + "INNER JOIN servico s ON s.id_servico = a.FK_id_servico "
               + "INNER JOIN animal an ON an.id_animal = a.FK_id_animal ";

    try (Connection con = ConnectionFactory.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Agendamento ag = new Agendamento();

            ag.setId_agendamento(rs.getInt("id_agendamento"));
            ag.setData(rs.getString("dataAgendamento"));
            ag.setHora(rs.getString("horario"));
            ag.setStatus(rs.getString("status"));

            // ID E NOME DO CLIENTE
            Cliente cli = new Cliente();
            cli.setId_cliente(rs.getInt("id_cliente"));
            cli.setNome(rs.getString("cliente_nome"));
            ag.setCliente(cli);
            ag.setNomeCliente(cli.getNome());

            // ID E NOME DO FUNCIONARIO
            Funcionario fun = new Funcionario();
            fun.setId_funcionario(rs.getInt("id_funcionario"));
            fun.setNome(rs.getString("funcionario_nome"));
            ag.setFuncionario(fun);
            ag.setNomeFuncionario(fun.getNome());

            // SERVIÇO
            Servico serv = new Servico();
            serv.setId_servico(rs.getInt("id_servico"));
            serv.setNome(rs.getString("servico_nome"));
            ag.setServico(serv);
            ag.setNomeServico(serv.getNome());

            // ANIMAL
            Animal ani = new Animal();
            ani.setIdAnimal(rs.getInt("id_animal"));
            ani.setNome(rs.getString("animal_nome"));
            ag.setAnimal(ani);
            ag.setNomeAnimal(ani.getNome());

            lista.add(ag);
        }
    }

    return lista;
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
     
     // Método de listar os agendamentos mas pelo nome do cliente e funcionário
     
     public List<Agendamento> listar() {

        List<Agendamento> lista = new ArrayList<>();

        try {
            String sql = "SELECT a.id_agendamento, a.data, a.hora, a.status, "
                       + "c.nome AS nome_cliente, "
                       + "f.nome AS nome_funcionario, "
                       + "s.nome AS nome_servico, "
                       + "an.nome AS nome_animal "
                       + "FROM agendamento a "
                       + "INNER JOIN cliente c ON a.id_cliente = c.id_cliente "
                       + "INNER JOIN funcionario f ON a.id_funcionario = f.id_funcionario "
                       + "INNER JOIN servico s ON a.id_servico = s.id_servico "
                       + "INNER JOIN animal an ON a.id_animal = an.id_animal";

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Agendamento a = new Agendamento();
                a.setId_agendamento(rs.getInt("id_agendamento"));
                a.setData(rs.getString("data"));
                a.setHora(rs.getString("hora"));
                a.setStatus(rs.getString("status"));

                // nomes vindo do JOIN
                a.setNomeCliente(rs.getString("nome_cliente")); //pegando da tabela cliente o nome
                a.setNomeFuncionario(rs.getString("nome_funcionario"));
                a.setNomeServico(rs.getString("nome_servico"));
                a.setNomeAnimal(rs.getString("nome_animal"));

                lista.add(a);
            }

            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao listar agendamentos: " + erro.getMessage());
        }

        return lista;
    }
 }

