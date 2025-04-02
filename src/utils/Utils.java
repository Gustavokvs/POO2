package utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

public static String calcularHash(String senha) {
    String hashSHA1 = "";
    
    try{
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
       
    }catch (NoSuchAlgorithmException e) {
        System.err.println("Algorítimo SHA1 não encontrado");
        
    }
    
    return hashSHA1;
}
    
    
    
}
