import java.math.BigInteger; 
import java.security.*;

public class SHA { 
    public static void main(String[] args){
        System.out.println("Encrypted by SHA-1: "+encryption("hello world"));
    }
    public static String encryption(String input) { 
        try { 
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
            byte[] messageDigest = md.digest(input.getBytes()); 
            BigInteger no = new BigInteger(1, messageDigest); 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
             return hashtext; 
        }catch(NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
}