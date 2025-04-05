package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Utils {

    public static String converterDateToString(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String texto = "";
        try {
            //Irá formatar a data para o formato dd/MM/yyyy 
            texto = formato.format(data);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao formatar a data");
        }
        return texto;
    }

    public static Date converterStringToDate(String texto) {

        //construo o formato que quero transformar o texto
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");

        Date data = null;

        try {
            data = formato.parse(texto);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter data");
        }

        return data;

    }

    public static String calcularHash(String senha) {
        String hashSHA1 = "";

        try {
            //crie uma instância do MessageDigest
            //com o algorítimo SHA1
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");

            //Atualize o digest com os bytes do texto
            sha1.update(senha.getBytes());
            //calcule o hash SHA1
            byte[] digest = sha1.digest();

            //converta o hash de bytes para uma representação hexadecimal.
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            hashSHA1 = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algorítimo SHA1 não encontrado");

        }

        return hashSHA1;
    }

}
