package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Usuario;
//import utils.Utils

public class UsuarioController {

    public boolean autenticar(String email, String senha) {

        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT * from TBUSUARIO "
                + " WHERE email = ? and senha = ? "
                + " and ativo = true";

        //Cria uma instância do gerenciador de conexão (conexão com o banco de dados)
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variaveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            //prepara o sql, analisando o formato e as variaveis
            comando = gerenciador.prepararComando(sql);

            //define o valor de cada variavel(?) pela posição em que aparece no sql
            comando.setString(1, email);
            comando.setString(2, senha);

            //Executa o comando e guarda o resultado da consulta, o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            //resultado.next() - tenta avançar para a próxima linha, caso consiga retornar true
            if (resultado.next()) {
                //se conseguiu avançar para a próxima linha, é porque achou o usuário com aquele nome e senha
                return true;
            }
        } catch (SQLException e) {//caso ocorra um erro relacionado ao banco de cados
            JOptionPane.showMessageDialog(null, e.getMessage()); // exibe popup com o erro

        } finally {//depois de executar o trym dando erro ou não executa o finally
            gerenciador.fecharConexao(comando, resultado);

        }
        return false;
    }

}
