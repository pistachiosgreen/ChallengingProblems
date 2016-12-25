public class Solution {
     public int[] plusOne(int[] digits) {
    	int insert = 1;
    	Stack<Integer> stk = new Stack<Integer>();
        for (int i = digits.length - 1; i >= 0; i--){
        	int digit = digits[i];
        	if ((digit + insert) > 9){
        		stk.push(0);
        	}
        	else{
        		stk.push(digit + insert);
        		insert = 0;
        	}
        }
        if (insert == 1){
        	stk.push(1);
        }
        while (stk.peek() == 0 && stk.size() > 1){
        	stk.pop();
        }
        

        int length = stk.size();
        int[] arr = new int[length];
        for (int j = 0; j < length;j++){
        	arr[j] = stk.pop();
        }
        return arr;
    }
}