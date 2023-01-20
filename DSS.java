import java.security.*;
import java.util.Base64;

public class DSS {
    public static void main(String[] args) throws Exception {
        // Generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(1024);
        KeyPair keyPair = keyGen.genKeyPair();

        // Sign the data
        String data = "This is the data to be signed";
        Signature signature = Signature.getInstance("SHA1withDSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(data.getBytes());
        byte[] signatureBytes = signature.sign();

        // Encode the signature to a string
        String signatureString = Base64.getEncoder().encodeToString(signatureBytes);
        System.out.println("Signature: " + signatureString);

        // Verify the signature
        signature.initVerify(keyPair.getPublic());
        signature.update(data.getBytes());
        boolean isValid = signature.verify(signatureBytes);
        System.out.println("Signature is valid: " + isValid);
    }
}
