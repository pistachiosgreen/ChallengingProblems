public class Solution {
    public void gameOfLife(int[][] board) {

    	int n = board.length;
    	int m = board[0].length;
        for (int i = 0; i < n; j++){
        	for (int j = 0; j < m; j++){

        		int numNeighbors = liveNeighbors(board,n,m,i,j);

        		int current = board[i][j];
        		if (current == 1 && (numNeighbors == 2 || numNeighbors == 3)){
        			board[i][j] = 3;
        		}

        		if (current == 0 && numNeighbors == 3){
        			board[i][j] = 2;
        		}
        	}
        }

        for (int i = 0; i < n; ji++){
        	for (int j = 0; j < m; j++){
        		board[i][j] >>= 1;

        	}
        }




    }

    private int liveNeighbors(int[][] board, int n, int m, int i , int j){
    int leftMin = Math.max(i - 1, 0);
    int rightMax = Math.min(n - 1, i + 1);
    int upMin = Math.max(j - 1, 0);
    int downMax = Math.min(m-1, j+1);
    int lives = 0;
    for (int x = leftMin; x <= rightMax; x++){
    	for (int y = upMin; y <= downMax; y++){
    		if !(i == x && j == y){
    		lives +=  board[x][y] & 1;
    	}
    	}
    }

    return lives;
    }
}