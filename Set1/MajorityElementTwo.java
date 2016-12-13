public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int num1  = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        boolean found1 = false;
        boolean found2 = false;
        int numTimes = nums.length/3;
        for (int x : nums){
        	if (x == num1 && found1 == true){
        		count1++;
        	}
        	else if (x == num2 && found2 == true){
        		count2++;
        	}
        	else if (count1== 0){
        		num1 = x;
        		count1 = 1;
        		found1 = true;
        	}
        	else if (count2 == 0){
        		num2 = x;
        		count2 = 1;
        		found2 = true;
        	}
        	else{
        		count1--;
        		count2--;
        	}
        }

        count1 = 0;
        count2 = 0;

        for (int y: nums){
        	if (num1 == y){
        		count1++;
        	}
        	if (num2 == y){
        		count2++;
        	}
        }
        
        

        if (count1 > numTimes){
        	result.add(num1);
        }
        
        if(num1 != num2){

        if (count2 > numTimes){
        	result.add(num2);
        }

        }
        return result;
    }
}