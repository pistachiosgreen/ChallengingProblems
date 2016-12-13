public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int numTimes = nums.length/2;
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length;i++){
            if (nums[i] == prev){
                count++;
                if (count > numTimes){
                    return nums[i];
                }
            }
            else{
                count = 1;
                prev = nums[i];
            }
        }
        return nums[0];
    }
    
}