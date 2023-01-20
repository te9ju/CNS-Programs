import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESCipher {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] plainText = "Hello, World!".getBytes();
        byte[] cipherText = cipher.doFinal(plainText);

        System.out.println("Ciphertext: " + new String(cipherText));
        
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] textDecrypted = cipher.doFinal(cipherText);
        
        System.out.println("Decrypted text: " + new String(textDecrypted));
    }
}