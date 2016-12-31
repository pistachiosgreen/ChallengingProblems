public class Solution {
    public void rotate(int[][] matrix) {
    int length = matrix.length;

    for (int i = 0; i < outers/2; i++){
    	//int first = i;
    	int end = length - 1 - i;
    	for (int j = i; j < end; j++){
    	int change = end - 1 - j;
    	int temp = matrix[i][j];
    	matrix[i][j] = matrix[change][i];
    	matrix[change][i] = matrix[end][change];
    	matrix[end][change] = matrix[j][end];
    	matrix[j][end] = temp;

    	}

    }

    }
}

/*
Input: [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
Output: [[13,9,5,1],[14,10,6,2],[15,7,11,3],[16,12,8,4]]
Expected: [[13,9,5,1],[14,10,6,2],[15,11,7,3],[16,12,8,4]]
*/