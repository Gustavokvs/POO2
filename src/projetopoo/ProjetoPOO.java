package projetopoo;

import controller.UsuarioController;
import javax.swing.JOptionPane;
import model.Usuario;
import utils.Utils;
import view.FrLogin;

public class ProjetoPOO {

    public static void main(String[] args) {

        /*    Usuario teste1 = new Usuario();

        teste1.setNome("Auberto");
        teste1.setAtivo(true);
        teste1.setDataNasc(Utils.converterStringToDate("18/12/2004"));
        teste1.setEmail("gustavokruger612@gmail.com");
        teste1.setSenha("198522");
        teste1.setId(1);

        UsuarioController controller = new UsuarioController();
        if (controller.alterarUsuario(teste1)) {
            JOptionPane.showMessageDialog(null, "Usuário gravado com sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "O cadastro não foi gravado");

        }
         */
        new FrLogin().setVisible(true);

    }

}
