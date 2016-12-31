public class Solution {
    public void wiggleSort(int[] nums) {
    // 0 1 2 3 4
    // 0 1 2 3

    for (int i = 1; i < nums.length; i = i + 2){
        int current = nums[i];
        int prev = nums[i - 1];
        if (prev > current){
            nums[i] = prev;
            nums[i - 1] = current;
            current = prev;
        }

        if ((i + 1) <= (nums.length - 1)){
            int next = nums[i + 1];
            if (next > current){
                nums[i + 1] = current;
                nums[i] = next;

            }

        }

    }
}
//[1,3,2,2,3,1]
//[1,2,2,1,2,1,1,1,1,2,2,2] input
//[1,2,1,2,1,2,1,1,1,2,2,2] wrong
}