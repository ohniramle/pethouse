
package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.ClienteDAO;
import view.cadastros.ClienteCadastro;

import bean.Cliente;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class Clientes extends javax.swing.JFrame {
    
    
    public Clientes() {
        initComponents();
        setLocationRelativeTo(null);
        AtualizarPagina();    
       
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(java.awt.SystemColor.controlHighlight);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(java.awt.SystemColor.controlHighlight);

        jPanel3.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.focusColor"));
        jPanel3.setForeground(java.awt.SystemColor.activeCaption);

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 33)); // NOI18N
        jLabel1.setText("PetHouse");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addGap(123, 123, 123)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Clientes");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF", "Nome", "Email", "Data de Nascimento", "Sexo", "CEP", "Endereço", "Telefone"
            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAdicionar.setText("+ Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisar)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionar)
                .addGap(31, 31, 31)
                .addComponent(btnAtualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnPesquisar)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnAdicionar)
                    .addComponent(btnAtualizar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //DefaultTableModel tabelaCliente = (DefaultTableModel) tblClientes.getModel();
        //1) pega a linha selecionada
        int linha = tblClientes.getSelectedRow();
        
        //2) se nao tiver nenhuma linha , avisa o usuário
        if (linha<0){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir!");
        }else{
        
        //3) confirmação antes de excluir
            int confirmacao = JOptionPane.showConfirmDialog(this,"Tem certeza que deseja excluir esse cliente?","Confirmação",
                        JOptionPane.YES_NO_OPTION);
            if(confirmacao == JOptionPane.YES_OPTION){
                //4)Pega  o id  do cliente  na tabela
               DefaultTableModel tabelaCliente = (DefaultTableModel) tblClientes.getModel();
                int id  = Integer.parseInt(tabelaCliente.getValueAt(linha,0).toString());
                //5 Chama o DAO para excluir no banco 
                ClienteDAO dao = new ClienteDAO();
                dao.excluir(id);

                //6)remove também a linha que o cliente estava para limpar a tabela
                tabelaCliente.removeRow(linha);

                JOptionPane.showMessageDialog(null,"Cliente excluído com sucesso");
            }
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaInicial tela = new TelaInicial(); //instancia tela inicial como objeto para uso
        this.dispose();
        tela.setVisible(true); // Isso quer dizer que a tela inicial é chamada para ficar visivel novamente
        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        ClienteCadastro clienteNovo = new ClienteCadastro();
        clienteNovo.setVisible(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void AtualizarPagina(){
          try{
        ClienteDAO dao = new ClienteDAO(); //instancia a classe DAO
        List<Cliente> lista = dao.listarTodos(); //cria uma lista utilizando o método listarTodos do DAO
       DefaultTableModel tabelaCliente = (DefaultTableModel) tblClientes.getModel(); //instancia uma tabela referenciando a JTable na interface
        tabelaCliente.setRowCount(0); // limpa linhas
        
        for(Cliente c : lista){ //for para percorrer a lista criada
            tabelaCliente.addRow(new Object[] { //adiciona cada dado em suas linhas na tabela especificamente na ordem 
                
                c.getId_cliente(),
                c.getCPF(),
                c.getNome(),
                c.getEmail(),
                c.getDataNascimento(),
                c.getSexo(),
                c.getCEP(),
                c.getEndereco(),
                c.getTelefone()

            });
        }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }
    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        
       AtualizarPagina();
        
       
    }//GEN-LAST:event_btnAtualizarActionPerformed

       
    
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       DefaultTableModel tblCliente = (DefaultTableModel) tblClientes.getModel();
       int linha  = tblClientes.getSelectedRow();
       if(linha<0){
           JOptionPane.showMessageDialog(this, "SELECIONE UMA LINHA PARA EDITAR");
       }
       else{
           int id = Integer.parseInt(tblClientes.getValueAt(linha, 0).toString());
       

        //Usa o DAO para buscar o cliente no banco de dados
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente  = dao.buscarPorId(id);

        ClienteCadastro telaCadastro = new ClienteCadastro ();
        
       telaCadastro.setClienteId(cliente.getId_cliente());
        telaCadastro.preencherCampos(cliente);
        dao.excluir(id);
        telaCadastro.setVisible(true);
       }
    }//GEN-LAST:event_btnEditarActionPerformed
    
    //Método para pesquisar o nome de algum Cliente
    private void pesquisarCliente(){
        
        //recupera o texto digtado na aba de pesquisa
        String texto = txtPesquisa.getText();
        //obtém o modelo de dados da tabela Jtable
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        //Cria um TableRowSorter baseado na JTable que permite filtrar ela 
        TableRowSorter<DefaultTableModel> sorter  = new TableRowSorter<>(modelo);
        //define que a JTable vai usar filtros do sorter
        tblClientes.setRowSorter(sorter);
        
        //verifica  se o campo de pesquisa está vazio 
        if(texto.trim().length()==0){
            //se tiver vazio remove o filtro para aparecer todos os registros
            sorter.setRowFilter(null);
        }else{
            //aplica o filtro
            //faz a comparação dos caracteres da tabela
            // e o (?i) ignora maiúscula/minúscula 
            sorter.setRowFilter(RowFilter.regexFilter("(?i)"+texto));
        }
        
        
        
    }
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pesquisarCliente();
    }//GEN-LAST:event_btnPesquisarActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
