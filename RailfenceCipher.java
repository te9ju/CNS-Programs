import java.util.*;

public class RailfenceCipher { 
    public static void main(String[] args){
        int depth;
        String message;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter message: ");
        message = scanner.nextLine();
        System.out.println("Enter depth: ");
        depth = scanner.nextInt();
        System.out.println("Encrypted text:"+encryption(message,depth));
    }
    
    public static String encryption(String message, int depth){
        String result = "";
        boolean check = false;
        int j = 0;
        int rows = depth;
        int cols = message.length();
        char[][] matrix = new char[rows][cols];
        for(int i = 0; i < cols; i++){
            if(j ==0 || j == depth-1){
                check = !check;
            }
            matrix[j][i] = message.charAt(i);
            if(check){
                j++;
            }
            else{
                j--;
            }
        }
        for(int i = 0; i < rows; i++){
            for(j = 0; j < cols; j++){
                if(matrix[i][j] != 0){
                    result += matrix[i][j];
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(j = 0; j < cols; j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        return result;
    }
}