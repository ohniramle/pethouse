
package view;

import DAO.AgendamentoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.cadastros.AgendamentoCadastro;
import bean.Agendamento;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class Agendamentos extends javax.swing.JFrame {

    
    public Agendamentos() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgendamento = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnMarcarComoFeito = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel1.setText("Agendamentos");

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
                .addGap(94, 94, 94)
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

        tblAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Horario", "Serviço", "Cliente", "Animal", "Funcionario", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(tblAgendamento);

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

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnMarcarComoFeito.setText("Marcar como feito");
        btnMarcarComoFeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarComoFeitoActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel3.setText("Pesquise:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMarcarComoFeito))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnAdicionar)
                    .addComponent(btnMarcarComoFeito))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaInicial tela = new TelaInicial(); //instancia tela inicial como objeto para uso
        tela.setVisible(true); // Isso quer dizer que a tela inicial é chamada para ficar visivel novamente
        this.dispose(); //fecha Agendamentos
       
    }//GEN-LAST:event_btnVoltarActionPerformed
     private void AtualizarPagina(){
         try {
            AgendamentoDAO dao = new AgendamentoDAO(); // instancia a classe DAO
            List<Agendamento> lista = dao.listarTodos(); // cria uma lista utilizando o método listarTodos do DAO
            DefaultTableModel tabelaAgendamento = (DefaultTableModel) tblAgendamento.getModel(); // tabela da interface
            tabelaAgendamento.setRowCount(0); // limpa linhas da tabela

            for (Agendamento a : lista) { // percorre a lista
                tabelaAgendamento.addRow(new Object[] { //adiciona valores em sua respectiva linha
                    a.getId_agendamento(),
                    a.getData(),
                    a.getHora(),
                    a.getNomeServico(),
                    a.getNomeCliente(),
                    a.getNomeAnimal(),
                    a.getFuncionario(),
                    a.getStatus()
                    
                    
                });
            }

       } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }
     //método para excluir um agendamento
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       // Verifica se uma linha está selecionada
    int linha = tblAgendamento.getSelectedRow();
    if (linha == -1) {
        JOptionPane.showMessageDialog(null, "Selecione um agendamento para excluir.");
        return;
    }

    // Recupera o ID da coluna 0
    int id_agendamento = Integer.parseInt(tblAgendamento.getValueAt(linha, 0).toString());

    // Confirmação
    int op = JOptionPane.showConfirmDialog(null, 
            "Tem certeza que deseja EXCLUIR este agendamento?",
            "Confirmar Exclusão", 
            JOptionPane.YES_NO_OPTION);

    if (op == JOptionPane.YES_OPTION) {

        try {
            AgendamentoDAO dao = new AgendamentoDAO();
            dao.excluir(id_agendamento);

            JOptionPane.showMessageDialog(null, "Agendamento excluído com sucesso!");

           AtualizarPagina();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
        }

     }
    
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            AgendamentoCadastro cadastro = new AgendamentoCadastro();
            cadastro.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(Agendamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnMarcarComoFeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarComoFeitoActionPerformed
        //  pegar linha selecionada
        int linha = tblAgendamento.getSelectedRow();

        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um agendamento!");
            return;
        }

        // pegar id da linha selecionada
        int id = Integer.parseInt(tblAgendamento.getValueAt(linha, 0).toString());

        // confirmar usando YES ou NO
        int opc = JOptionPane.showConfirmDialog(this,
                "Confirmar que o agendamento foi concluído?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (opc == JOptionPane.YES_OPTION) { //pegar confirmação YES (SIM)

            AgendamentoDAO dao = new AgendamentoDAO(); //Instancia dao
            dao.marcarComoFeito(id);

            // remove da tabela (some da lista)
            DefaultTableModel modelo = (DefaultTableModel) tblAgendamento.getModel(); //pega modelo da tabela
            modelo.removeRow(linha); //remove linha

            JOptionPane.showMessageDialog(null, "Agendamento marcado como concluído!");
         }
    }//GEN-LAST:event_btnMarcarComoFeitoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // 1) Pega a linha selecionada
    int linha = tblAgendamento.getSelectedRow();

    // 2) Se nenhuma linha foi selecionada, avisa o usuário
    if (linha < 0) {
        JOptionPane.showMessageDialog(this, "Selecione um agendamento para editar!");
        return;
    }

    try {
        // 3) Pega o ID do agendamento na tabela
        DefaultTableModel modelo = (DefaultTableModel) tblAgendamento.getModel();
        int id = Integer.parseInt(modelo.getValueAt(linha, 0).toString());

        // 4) Busca o agendamento no banco
        AgendamentoDAO dao = new AgendamentoDAO();
        Agendamento ag = dao.buscarPorId(id);

        // 5) Abre a tela de cadastro
        AgendamentoCadastro tela = new AgendamentoCadastro();

        // 6) Envia o ID para tela (modo EDIÇÃO)
        tela.setAgendamentoId(ag.getId_agendamento());

        // 7) Preenche todos os campos
        tela.preencherCampos(ag);

        // 8) Exibe a tela
        tela.setVisible(true);

    } catch (Exception erro) {
        erro.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao editar: " + erro.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       //recupera o texto digitado na aba de pesquisa
        String texto = txtPesquisa.getText();
        //obtém o modelo de dados da tabela JTable
        DefaultTableModel modelo = (DefaultTableModel) tblAgendamento.getModel();
        //Cria um TableRowSorter baseado na JTable que permite filtrar ela 
        TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<>(modelo);
        //define que a JTable vai usar filtros do sorter
        tblAgendamento.setRowSorter(filtro);

        //verifica se o campo de pesquisa está vazio 
        if(texto.trim().length() == 0){
            //se tiver vazio remove o filtro para aparecer todos os registros
            filtro.setRowFilter(null);
        } else {
            //aplica o filtro
            //faz a comparação dos caracteres da tabela
            //e o (?i) ignora maiúscula/minúscula 
            filtro.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Agendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Agendamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnMarcarComoFeito;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAgendamento;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
