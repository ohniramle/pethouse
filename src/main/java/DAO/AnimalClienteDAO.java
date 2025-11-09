
package DAO;

import bean.AnimalCliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexao.ConnectionFactory;

public class AnimalClienteDAO {
  
    // Método que retorna a lista de animais com dados do cliente
    public List<AnimalCliente> listarTodos() {
        List<AnimalCliente> lista = new ArrayList<>();

        String sql = """
            SELECT  
                a.id_animal AS idAnimal,
                a.nome AS nomeAnimal,
                c.id_cliente AS idCliente,
                c.nome AS nomeCliente,
                c.cpf AS cpfCliente
            FROM animal a
            INNER JOIN cliente c ON a.id_cliente = c.id_cliente
            ORDER BY a.id_animal;
        """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AnimalCliente ac = new AnimalCliente();
                ac.setIdAnimal(rs.getInt("idAnimal"));
                ac.setNomeAnimal(rs.getString("nomeAnimal"));
                ac.setIdCliente(rs.getInt("idCliente"));
                ac.setNomeCliente(rs.getString("nomeCliente"));
                ac.setCpfCliente(rs.getString("cpfCliente")); // corrigido

                lista.add(ac);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar animais: " + e.getMessage());
        }

        return lista;
    }
}