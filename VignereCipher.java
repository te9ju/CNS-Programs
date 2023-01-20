import java.util.*;
class VignereCipher {
    public static void main(String[] args) {
        ArrayList<Character> alphabets = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message: ");
        String message = scanner.nextLine();
        message = message.toLowerCase();
        System.out.println("Enter key: ");
        String key = scanner.nextLine();
        key = key.toLowerCase();
        System.out.println(encryption(message, key));
        System.out.println(decryption("wbukeeqkhk txnk", "company"));
    }
    
    public static String encryption(String message, String key){
        ArrayList<Character> alphabets = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        String result = "";
        int index = 0;
        for(int i = 0; i < message.length(); i++){
            if(Character.isWhitespace(message.charAt(i))){
                result += " ";
                continue;
            }
            result += String.valueOf(alphabets.get((alphabets.indexOf(Character.valueOf(message.charAt(i))) + alphabets.indexOf(Character.valueOf(key.charAt(index)))) % 26));
            index += 1;
            if(index == key.length()){
                index = 0;
            }
        }
        return result;
    }
    
    public static String decryption(String message, String key){
        ArrayList<Character> alphabets = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        String result = "";
        int index = 0;
        for(int i = 0; i < message.length(); i++){
            if(Character.isWhitespace(message.charAt(i))){
                result += " ";
                continue;
            }
            result += String.valueOf(alphabets.get(Math.floorMod((alphabets.indexOf(Character.valueOf(message.charAt(i))) - alphabets.indexOf(Character.valueOf(key.charAt(index)))), 26)));
            index += 1;
            if(index == key.length()){
                index = 0;
            }
        }
        return result;
    }
}