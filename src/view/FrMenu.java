/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author aluno.saolucas
 */
public class FrMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrMenu
     */
    public FrMenu() {
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
        IconUser = new javax.swing.JLabel();
        barMenu = new javax.swing.JMenuBar();
        meCadastro = new javax.swing.JMenu();
        miCadUsuario = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();
        meConsulta = new javax.swing.JMenu();
        miConUsuario = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        meSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user512px.png"))); // NOI18N
        jPanel1.add(IconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        meCadastro.setText("Cadastro");

        miCadUsuario.setText("Usuário");
        miCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadUsuarioActionPerformed(evt);
            }
        });
        meCadastro.add(miCadUsuario);

        jMenuItem2.setText("???");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        meCadastro.add(jMenuItem2);

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        meCadastro.add(miSair);

        barMenu.add(meCadastro);

        meConsulta.setText("Consulta");

        miConUsuario.setText("Usuario");
        miConUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConUsuarioActionPerformed(evt);
            }
        });
        meConsulta.add(miConUsuario);

        jMenuItem3.setText("???");
        meConsulta.add(jMenuItem3);

        barMenu.add(meConsulta);

        meSobre.setText("Sobre");
        meSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                meSobreMouseClicked(evt);
            }
        });
        barMenu.add(meSobre);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadUsuarioActionPerformed

        //Crio a tela;
        FrCadUsuario telaCadastro = new FrCadUsuario(this, rootPaneCheckingEnabled);

        telaCadastro.setVisible(true);

    }//GEN-LAST:event_miCadUsuarioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        URL caminhoImagem = getClass().getResource("/images/title icon.png");

        ImageIcon icon = new ImageIcon(caminhoImagem);

        this.setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowOpened

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_miSairActionPerformed

    private void miConUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConUsuarioActionPerformed

        FrConUsuario tabelaUsu = new FrConUsuario(this, rootPaneCheckingEnabled);

        tabelaUsu.setVisible(true);

    }//GEN-LAST:event_miConUsuarioActionPerformed

    private void meSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_meSobreMouseClicked
        FrSobre sobre = new FrSobre(this, rootPaneCheckingEnabled);

        sobre.setVisible(true);
    }//GEN-LAST:event_meSobreMouseClicked

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
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconUser;
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu meCadastro;
    private javax.swing.JMenu meConsulta;
    private javax.swing.JMenu meSobre;
    private javax.swing.JMenuItem miCadUsuario;
    private javax.swing.JMenuItem miConUsuario;
    private javax.swing.JMenuItem miSair;
    // End of variables declaration//GEN-END:variables
}
