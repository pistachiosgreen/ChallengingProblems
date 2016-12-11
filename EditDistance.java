public class Solution {
    public int minDistance(String word1, String word2) {
        int row = word1.length() + 1;
        int col = word2.length() + 1;
        int[][] matrix = new int[row][col];
        int result = 0;
        if (word1.equals(word2)){
            return 0;
        }
         for(int r=0; r < matrix[0].length; r++){
            matrix[0][r] = r;
        }
        
        for(int c=0; c < matrix.length; c++){
            matrix[c][0] = c;
}
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                char r = word1.charAt(i - 1);
                char c = word2.charAt(j - 1);
                if (r == c){
                    matrix[i][j] = matrix[i - 1][j-1];
                }
                else{
                    matrix[i][j] = Math.min(matrix[i - 1][j-1],Math.min(matrix[i - 1][j],matrix[i][j-1])) + 1;
                }
            }
        }
        result = matrix[row - 1][col - 1];
        return result;
    }
}