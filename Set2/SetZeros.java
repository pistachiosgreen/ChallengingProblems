public class Solution {
    public void setZeroes(int[][] matrix) {
        int rowMax = matrix.length;
    	int colMax = matrix[0].length;
    	int colOne = 1;

    	for (int i = 0; i < rowMax; i++){
    		if (matrix[i][0] == 0){
    				colOne = 0;
    			}
    		for (int j = 1; j < colMax; j++){
    			if (matrix[i][j] == 0){
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
    			}

    		}
    	}

    	for (int i = rowMax - 1; i >= 0; i--){   	  
    		for (int j = colMax - 1; j >= 1; j--){
    			if (matrix[0][j] == 0 || matrix[i][0] == 0){
    				matrix[i][j] = 0;
    			}
    		}
    		  if (colOne == 0){
    		    matrix[i][0] = 0;
    		}
    		
    	}
    }
}