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

/*O PREPAREDSTATEMENT É IMPORTADO DO JAVA, 
O COMANDO É PARA INTERPRETAR O COMANDO Q EU ESCREVER EM STRING, E TRADUZIR PRO SQL
QUANDO EU ESCREVO comando = gerenciador.prepararComando(sql) EU DIGO
COMANDO = FAZ A CONEXÃO COM O BANCO Q PASSEI (NESSE CASO O SQL), SE FUNCIONAR INTERPRETE O COMANDO Q DIGITEI*/
public class UsuarioController {

    public boolean autenticar(String email, String senha) {

        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT * from USUARIO "
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

    public boolean inserirUsuario(Usuario usu) {

        String sql = "INSERT INTO USUARIO(nome, email, senha, datanasc, ativo) "
                + " VALUES (?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            //prepara o sql, analisando o formato e as variaveis
            comando = gerenciador.prepararComando(sql);

            //define o valor de cada variavel(?) pela posição em que aparece no sql
            comando.setString(1, usu.getNome());
            comando.setString(2, usu.getEmail());
            comando.setString(3, usu.getSenha());
            comando.setDate(4, new java.sql.Date(usu.getDataNasc().getTime()));
            comando.setBoolean(5, usu.isAtivo());

            //Executa o insert
            comando.executeUpdate();

            return true;

        } catch (SQLException e) { //caso aconteça um erro relacionado ao banco de dados
            JOptionPane.showMessageDialog(null, e.getMessage()); //exibe um pop-up com o erro 
        } finally { //depois de executar o try, dando erro ou não, executa o finally
            gerenciador.fecharConexao(comando);

        }

        return false;
    }

    public boolean alterarUsuario(Usuario usu) {

        String sql = "UPDATE USUARIO SET NOME = ?, EMAIL = ?, SENHA = ?, DATANASC = ?, ATIVO = ? WHERE ID = ?";

        GerenciadorConexao conexão = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = conexão.prepararComando(sql);

            comando.setString(1, usu.getNome());
            comando.setString(2, usu.getEmail());
            comando.setString(3, usu.getSenha());
            comando.setDate(4, new java.sql.Date(usu.getDataNasc().getTime()));
            comando.setBoolean(5, usu.isAtivo());
            comando.setInt(6, usu.getId());

            comando.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }finally {
            conexão.fecharConexao(comando);
        }
        return false;
    }

}
