import java.util.*;
class CaesarCipher{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alphabets = "abcdefghijklmnopqrstuvwxyz", upperAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", result = "";
        int shiftKey;
        char charToReplace = 'a';
        System.out.println("Enter string: ");
        String ipString = scanner.nextLine();
        System.out.println("Enter shift key: ");
        shiftKey = scanner.nextInt();
        for(int i = 0; i < ipString.length(); i++){
            if(Character.isWhitespace(ipString.charAt(i))){
                result += " ";
                continue;
            }
            if(Character.isUpperCase(ipString.charAt(i))){
                for(int j = 0; j < upperAlphabets.length(); j++){
                    if(upperAlphabets.charAt(j) == ipString.charAt(i)){
                        charToReplace = upperAlphabets.charAt((j+shiftKey)%26); //- for decryption
                        break;
                    }
                }    
            }
            else{
                for(int j = 0; j < alphabets.length(); j++){
                    if(alphabets.charAt(j) == ipString.charAt(i)){
                        charToReplace = alphabets.charAt((j+shiftKey)%26); //- for decryption
                        break;
                    }
                }
            }
            result += charToReplace;
        }
        System.out.println("Encrypted string: "+result);
    }
}

