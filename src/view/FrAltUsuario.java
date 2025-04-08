/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuarioController;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Usuario;
import utils.Utils;

/**
 *
 * @author aluno.saolucas
 */
public class FrAltUsuario extends javax.swing.JDialog {

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void gravar() {

        Usuario usu = new Usuario();

        usu.setId(id);
        usu.setNome(txtNome.getText());
        usu.setEmail(txtEmail.getText());

        if (txtSenha.isEditable()) {

            //define uma string, como senha é uma password, n é string, esse comando faz a transição de password pra string.
            String senha = new String(txtSenha.getPassword());
            String senhaHash = Utils.calcularHash(senha);
            usu.setSenha(senhaHash);

        }
        Date data = Utils.converterStringToDate(dateNascimento.getText());
        usu.setDataNasc(data);

        usu.setAtivo(chkAtivo.isSelected());

        //passar o usuario usu para controller
        //enviar para o banco de dados
        UsuarioController controller = new UsuarioController();

        if (controller.alterarUsuario(usu)) {
            JOptionPane.showMessageDialog(null, "Usuario: " + usu.getNome() + " Alterado com sucesso");

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario não será alterado!");
        }

    }

    public boolean verificarNome() {

        String nome = txtNome.getText();

        if (nome.matches("^[a-zA-ZÀ-ÿ ]+$")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "O campo nome não pode conter números, ou caracteres especíais, como !,@...");
            return false;
        }
    }

    public boolean verificarEmail() {
        String email = txtEmail.getText();
        if (email.matches("^[^\\s@]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "O campo 'email' n deve conter espaços, e deve contar @");
            return false;
        }
    }

    public boolean verificarSenha() {

        String senha = new String(txtSenha.getPassword()); // Converte char[] para String
        if (txtSenha.isEditable()) {

            if (senha.length() < 6 || senha.contains(" ")) {
                JOptionPane.showMessageDialog(null, "Tem menos de 6 caracteres ou contem espaços.");
                return false;
            }
        } else {
            return true;
        }
        return true;
    }

    public boolean verificarNasc() {

        String nasc = dateNascimento.getText();

        if (nasc.length() < 10) {
            JOptionPane.showMessageDialog(null, "Data inválida");
            return false;

        } else {
            return true;
        }
    }

    public boolean verificarCampos() {

        if (verificarEmail() == false) {
            return false;
        }
        if (verificarSenha() == false) {
            return false;
        }

        if (txtNome.getText().equals("")) {

            JOptionPane.showMessageDialog(null,
                    "O Campo 'Nome' tá em branco");

            return false;
        }

        if (txtEmail.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Campo 'Email' vazio");

            return false;
        }
        if (txtSenha.isEditable()) {
            if (new String(txtSenha.getPassword()).equals("")) {

                JOptionPane.showMessageDialog(null, "Campo 'Senha' em branco");

                return false;
            }
        }

        String lSenha = new String(txtSenha.getPassword());
        String lConfirmaSenha = new String(txtConfirmarSenha.getPassword());

        if (!lSenha.equals(lConfirmaSenha)) {
            JOptionPane.showMessageDialog(null, "As senhas não Coincidem");

            return false;
        }
        if (verificarNome() == false) {
            return false;
        }
        JOptionPane.showMessageDialog(null, "Tudo certo");
        return true;

    }

    /**
     * Creates new form FrAltUsuario
     */
    public FrAltUsuario(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);

        setId(id);

        carregarUsuario();
    }

    public void carregarUsuario() {

        UsuarioController controle = new UsuarioController();
        Usuario user = controle.buscarPorId(id);

        String codigo = String.valueOf(user.getId());
        txtCod.setText(codigo);
        txtNome.setText(user.getNome());
        txtEmail.setText(user.getEmail());
        dateNascimento.setText(Utils.converterDateToString(user.getDataNasc()));
        chkAtivo.setSelected(user.isAtivo());

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
        lbCodigo = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        IconMail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        IconNascimento = new javax.swing.JLabel();
        dateNascimento = new javax.swing.JFormattedTextField();
        chkAtivo = new javax.swing.JCheckBox();
        lbConfirmarSenha = new javax.swing.JLabel();
        txtConfirmarSenha = new javax.swing.JPasswordField();
        btCancelar = new javax.swing.JButton();
        btAlterarSenha = new javax.swing.JButton();
        iconSenha = new javax.swing.JLabel();
        IconSenha = new javax.swing.JLabel();
        lbEmail1 = new javax.swing.JLabel();
        lbDataNascimento1 = new javax.swing.JLabel();
        IconSalvar = new javax.swing.JLabel();
        IconCancelar = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lbNome1 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userIcon.png"))); // NOI18N
        lbTitulo.setText("Alteração De Usuario");
        jPanel1.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 590, 130));

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbCodigo.setText("Código");
        jPanel1.add(lbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        txtCod.setEditable(false);
        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodKeyReleased(evt);
            }
        });
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 90, -1));

        IconMail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IconMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mailIcon.png"))); // NOI18N
        jPanel1.add(IconMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 220, -1));

        lbSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbSenha.setText("Senha");
        jPanel1.add(lbSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        txtSenha.setEditable(false);
        jPanel1.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 200, 30));

        IconNascimento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IconNascimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nascimentoIcon.png"))); // NOI18N
        jPanel1.add(IconNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 650, -1, 30));

        dateNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jPanel1.add(dateNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 200, 30));

        chkAtivo.setText("Ativo");
        jPanel1.add(chkAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 670, -1, -1));

        lbConfirmarSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbConfirmarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/passwordIcon].png"))); // NOI18N
        jPanel1.add(lbConfirmarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, -1, -1));

        txtConfirmarSenha.setEditable(false);
        jPanel1.add(txtConfirmarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 200, 30));

        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelarMouseClicked(evt);
            }
        });
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        btCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btCancelarKeyPressed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 730, -1, -1));

        btAlterarSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAlterarSenha.setText("Alterar Senha");
        btAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarSenhaActionPerformed(evt);
            }
        });
        btAlterarSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btAlterarSenhaKeyPressed(evt);
            }
        });
        jPanel1.add(btAlterarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, -1, -1));

        iconSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iconSenha.setText("Confirmar Senha");
        jPanel1.add(iconSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        IconSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IconSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/passwordIcon].png"))); // NOI18N
        jPanel1.add(IconSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, -1, -1));

        lbEmail1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbEmail1.setText("Email");
        jPanel1.add(lbEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        lbDataNascimento1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbDataNascimento1.setText("Data de nascimento");
        jPanel1.add(lbDataNascimento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));

        IconSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IconSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvarIcon.png"))); // NOI18N
        jPanel1.add(IconSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 730, -1, -1));

        IconCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IconCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelarIcon.png"))); // NOI18N
        jPanel1.add(IconCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 730, -1, 30));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 340, -1));

        lbNome1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbNome1.setText("Nome");
        jPanel1.add(lbNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        btSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 730, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void txtCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyReleased

    }//GEN-LAST:event_txtCodKeyReleased

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseClicked
        dispose();
    }//GEN-LAST:event_btCancelarMouseClicked

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCancelarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dispose();
        }
    }//GEN-LAST:event_btCancelarKeyPressed

    private void btAlterarSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAlterarSenhaKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_SPACE) {

            verificarCampos();
        }
    }//GEN-LAST:event_btAlterarSenhaKeyPressed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeKeyReleased

    private void btAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarSenhaActionPerformed

        if (txtSenha.isEditable() == false) {
            txtSenha.setEditable(true);
            txtConfirmarSenha.setEditable(true);
//edtSenha.setBackground (Color.white); 
//edtConfirmaSenha.setBackground (Color.white); 
            btAlterarSenha.setText("Cancelar alteração");
            txtSenha.setText("");
            txtConfirmarSenha.setText("");
        } else {
            txtSenha.setEditable(false);
            txtConfirmarSenha.setEditable(false);
//edtSenha.setBackground (Color.gray); 
//edtConfirmaSenha.setBackground (Color.gray); 
            btAlterarSenha.setText("Alterar Senha");
            txtSenha.setText("");
            txtConfirmarSenha.setText("");
        }

    }//GEN-LAST:event_btAlterarSenhaActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (verificarCampos()) {
            gravar();

        }

    }//GEN-LAST:event_btSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(FrAltUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrAltUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrAltUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrAltUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrAltUsuario dialog = new FrAltUsuario(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JLabel IconCancelar;
    private javax.swing.JLabel IconMail;
    private javax.swing.JLabel IconNascimento;
    private javax.swing.JLabel IconSalvar;
    private javax.swing.JLabel IconSenha;
    private javax.swing.JButton btAlterarSenha;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JCheckBox chkAtivo;
    private javax.swing.JFormattedTextField dateNascimento;
    private javax.swing.JLabel iconSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbConfirmarSenha;
    private javax.swing.JLabel lbDataNascimento1;
    private javax.swing.JLabel lbEmail1;
    private javax.swing.JLabel lbNome1;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField txtCod;
    private javax.swing.JPasswordField txtConfirmarSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
