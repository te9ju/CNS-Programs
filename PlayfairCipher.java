import java.util.*;
class PlayfairCipher {
    public static void main(String[] args) {
        String result = "";
        ArrayList<Character> alphabetsList = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        char[][] matrix = new char[5][5];
        String keyword, message;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter keyword: ");
        keyword = scanner.nextLine();
        int x = 0;
        for(int i = 0; i < 5; i++){
            if(x >= keyword.length()){
                break;
            }
            for(int j = 0; j < 5; j++){
                if(x >= keyword.length()){
                    break;
                }
                matrix[i][j] = keyword.charAt(x);
                alphabetsList.remove(Character.valueOf(keyword.charAt(x)));
                x += 1;
            }
        }
        x = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(matrix[i][j] == 0){
                    matrix[i][j] = alphabetsList.get(x);
                    x += 1;
                }
            }
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("Enter message: ");
        message = scanner.nextLine();
        for(int i = 0; i < message.length(); i += 2){
            char char1 = message.charAt(i);
            char char2 = message.charAt(i+1);
            int[] char1Indices = getIndices(matrix, char1);
            int[] char2Indices = getIndices(matrix, char2);
            
            if(char1Indices[0] == char2Indices[0]){
                char1Indices[1] = (char1Indices[1] + 1) % 5;
                char2Indices[1] = (char2Indices[1] + 1) % 5;
            }
            else if(char1Indices[1] == char2Indices[1]){
                char1Indices[0] = (char1Indices[0] + 1) % 5;
                char2Indices[0] = (char2Indices[0] + 1) % 5;
            }
            else{
                int temp = char1Indices[1];
                char1Indices[1] = char2Indices[1];
                char2Indices[1] = temp;
            }
            
            result += String.valueOf(matrix[char1Indices[0]][char1Indices[1]])+String.valueOf(matrix[char2Indices[0]][char2Indices[1]]);
        }
        System.out.println(result);
    }
    public static int[] getIndices(char[][] matrix, char ch){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(matrix[i][j] == ch){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
