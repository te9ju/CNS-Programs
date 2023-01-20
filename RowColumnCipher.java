import java.util.*;
class RowColumnCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message: ");
        String message = scanner.nextLine();
        message = message.toLowerCase();
        System.out.println("Enter depth: ");
        int depth = scanner.nextInt();
        System.out.println(encryption(message, depth));
        System.out.println(decryption("holewdlo1lr2", depth));
    }
    
    public static String encryption(String message, int depth){
        String result = "";
        int cols = (message.length() % depth == 0) ? (message.length() / depth) : (message.length() / depth)+1 ;
        char[][] matrix = new char[depth][cols];
        int index = 0;
        for(int i = 0; i < depth; i++){
            for(int j = 0; j < cols; j++){
                if(index == message.length()){
                    break;
                }
                matrix[i][j] = message.charAt(index);
                index += 1;
            }
        }
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < depth; j++){
                if(matrix[j][i] == 0){
                    break;
                }
                result += String.valueOf(matrix[j][i]);
            }
        }
        return result;
    }
    
    public static String decryption(String message, int depth){
        String result = "";
        int cols = (message.length() % depth == 0) ? (message.length() / depth) : (message.length() / depth)+1 ;
        char[][] matrix = new char[depth][cols];
        int index = 0;
        int remainder = message.length() % cols;
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < depth; j++){
                if(index == message.length()){
                    break;
                }
                if(remainder > 0 && i == (depth-1) && j >= remainder){
                    continue;
                }
                matrix[j][i] = message.charAt(index);
                index += 1;
            }
        }
        for(int i = 0; i < depth; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    break;
                }
                result += String.valueOf(matrix[i][j]);
            }
        }
        return result;
    }
}
