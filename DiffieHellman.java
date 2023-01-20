import java.util.*;

public class DiffieHellman {
    public static void main(String[] args) {
        int XA, XB, YA, YB, KSA, KSB, α;
        int q;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter prime: ");
        q = scanner.nextInt();
        System.out.println("Enter private key XA: ");
        XA = scanner.nextInt();
        System.out.println("Enter private key XB: ");
        XB = scanner.nextInt();
        System.out.println("Enter primitive root α: ");
        α = scanner.nextInt();
        YA = (int)Math.pow(α, XA) % q;
        YB = (int)Math.pow(α, XB) % q;
        System.out.println("Public key of A: "+YA);
        System.out.println("Public key of B: "+YB);
        KSA = (int)Math.pow(YA, XB) % q;
        KSB = (int)Math.pow(YB, XA) % q;
        System.out.println("Shared secret key of A: "+KSA);
        System.out.println("Shared secret key of B: "+KSB);
    }
}