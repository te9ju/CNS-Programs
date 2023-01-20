import java.util.*;

public class RSA {
    public static void main(String[] args) {
        int d = 0, p, q, e, message;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message: ");
        message = scanner.nextInt();
        System.out.println("Enter prime p: ");
        p = scanner.nextInt();
        System.out.println("Enter prime q: ");
        q = scanner.nextInt();
        int n = p * q;
        int phi_n = (p - 1) * (q - 1);
        System.out.println("n is: "+n);
        System.out.println("phi_n is: "+phi_n);
        for(e = 2; e < phi_n; e++){
            if(gcd(e,phi_n) == 1){
                break;
            }
        }
        System.out.println("e is: "+e);
        for(int i = 0; i <= 9; i++){
            int x = 1 + (i * phi_n);
            if(x % e == 0){
                d = x / e;
                break;
            }
        }
        System.out.println("d is: "+d);
        int cipher = (int) Math.pow(message, e) % n;
        System.out.println("Ciphertext: "+cipher);
        int decrypt = (int) Math.pow(cipher, d) % n;
        System.out.println("Decrypted text: "+decrypt);
    }
    
    public static int gcd(int e, int phi_n){
        if(e == 0){
            return phi_n;
        }
        else{
            return gcd(phi_n % e, e);
        }
    }
}