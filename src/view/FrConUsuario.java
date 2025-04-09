/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuarioController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import utils.Utils;

/**
 *
 * @author aluno.saolucas
 */
public class FrConUsuario extends javax.swing.JDialog {

    /**
     * Creates new form FrConUsuario
     */
    public FrConUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btmPesquisar = new javax.swing.JButton();
        btmCancelar = new javax.swing.JButton();
        btmAlterar = new javax.swing.JButton();
        btmExcluir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbTitulo.setText("Consulta de Usuários");
        jPanel1.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nome", "Email", "Data de Nascimento", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 620, 330));

        btmPesquisar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btmPesquisar.setText("Pesquisar");
        btmPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(btmPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, -1, -1));

        btmCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btmCancelar.setText("Cancelar");
        jPanel1.add(btmCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, -1));

        btmAlterar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btmAlterar.setText("Alterar");
        btmAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btmAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, -1, -1));

        btmExcluir1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btmExcluir1.setText("Excluir");
        btmExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmExcluir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btmExcluir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btmPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmPesquisarActionPerformed

        pesquisar();


    }//GEN-LAST:event_btmPesquisarActionPerformed

    public void pesquisar() {
        DefaultTableModel modeloTabela = (DefaultTableModel) tblUsuarios.getModel();

        modeloTabela.setNumRows(0);

        UsuarioController conexao = new UsuarioController();

        List<Usuario> listaUsuarios = conexao.consultar();

        //preencher a grade
        //percorre todos os usuarios presentes na linha
        for (Usuario usu : listaUsuarios) {
            //cria um array onde cada posição é o valor das colunas da grade
            Object[] linha = {
                usu.getId(), //coluna 0
                usu.getNome(), //coluna 1
                usu.getEmail(), //coluna 2
                Utils.converterDateToString(usu.getDataNasc()), //coluna 3
                usu.ativoToString() //coluna 4
            };

            //adiciona o array com os dados do usuario na grade
            modeloTabela.addRow(linha);

        }
    }

    private void btmAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmAlterarActionPerformed

        /*verificar se tem uma linha de grade selecionada
        lembre-se de que a tabela é um array, arrays sempre começam do 0
        então técnicamente falando a linha 1 é a linha 0
         */
        if (tblUsuarios.getSelectedRow() != -1) {
            //se alguma linha estiver selecionada, pega o ID do usuário
            int linhaSelecionada = tblUsuarios.getSelectedRow();
            String textoCelula = tblUsuarios.getValueAt(linhaSelecionada, 0).toString();
            /*O código acima faz o seguinte, ele verifica qual linha tá selecionada
    ai ele dá pra linhaSelecionada o valor da linha
    no String textoCelula, ele tá pegando o valor que tá na linha selecionada, na coluna 0 (lembre-se do array)
    e tá transformando esse valor em String.
             */

            //converter o texto da célula em inteiro.
            int id = Integer.parseInt(textoCelula);

            /* com o id agora descoberto (pego) eu vou inicializar a tela de alterar usuário
             */
            FrAltUsuario telaAlt = new FrAltUsuario(null, rootPaneCheckingEnabled, id);

            telaAlt.setVisible(true);

            pesquisar();
        }


    }//GEN-LAST:event_btmAlterarActionPerformed

    private void btmExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmExcluir1ActionPerformed

        if (tblUsuarios.getSelectedRow() != -1) {

            int linhaSelecionada = tblUsuarios.getSelectedRow();
            String textoCelula = tblUsuarios.getValueAt(linhaSelecionada, 0).toString();

            int id = Integer.parseInt(textoCelula);

            //com o id vou chamar o método de deletar do controller
            UsuarioController controller = new UsuarioController();
            if (controller.deletar(id)) {

                pesquisar();

                JOptionPane.showMessageDialog(null, "Usuário apagado com sucesso");

            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar.");
            }
        }

    }//GEN-LAST:event_btmExcluir1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrConUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrConUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrConUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrConUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrConUsuario dialog = new FrConUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmAlterar;
    private javax.swing.JButton btmCancelar;
    private javax.swing.JButton btmExcluir1;
    private javax.swing.JButton btmPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
