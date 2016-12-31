public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
    // Search for the left one
        while (i < j)
        {
            int mid = (i + j) /2;
            if (nums[mid] < target) i = mid + 1;
            else j = mid;
        }
        if (nums[i]!=target) return arr;
        else arr[0] = i;
        //j = Math.min(nums.length - 1, j + 1);
    // Search for the right one
        j = nums.length-1;  // We don't have to set i to 0 the second time.
        while (i < j)
        {
            int mid = (i + j) /2 + 1;   // Make mid biased to the right
            if (nums[mid] > target) j = mid - 1;  
            else i = mid;               // So that this won't make the search range stuck.
        }
        arr[1] = j;
        return arr; 
    }
}