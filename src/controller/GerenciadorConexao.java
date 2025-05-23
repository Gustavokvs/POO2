package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GerenciadorConexao {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Conta";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Connection conexao;
    
    public GerenciadorConexao() {
        
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) { //CASO OCORRA UM SQLExeption, Irá executar o seguinte tratamento.
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }
        
    }
    
    public PreparedStatement prepararComando(String sql) {
        PreparedStatement comando = null;
        
        try {
            comando = conexao.prepareStatement(sql);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Preparar Comando: " + erro);
        }
        return comando;
    }
    
    public void fecharConexao() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException erro) {
            Logger.getLogger(GerenciadorConexao.class.getName()).log(Level.SEVERE, null, erro);
            //Pega qual foi o comando (select, create, etc...)
        }
    }
    
    public void fecharConexao(PreparedStatement comando) {
        fecharConexao();
        
        try {
            if (comando != null) {
                comando.close();
            }
        } catch (SQLException erro) {
            Logger.getLogger(GerenciadorConexao.class.getName()).log(Level.SEVERE, null, erro);
            
        }
        
    }
    
    public void fecharConexao(PreparedStatement comando, ResultSet resultado) {
        
        fecharConexao(comando);
        
        try {
            if (resultado != null) {
                resultado.close();
            }
        } catch (SQLException erro) {
            Logger.getLogger(GerenciadorConexao.class.getName())
                    .log(Level.SEVERE, null, erro);
        }
        
    }
    
}
