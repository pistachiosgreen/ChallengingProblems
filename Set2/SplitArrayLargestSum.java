public class Solution {
    public int splitArray(int[] nums, int m) {
    int sum = 0;
    int max = 0;
    for (int x : nums){
        sum += x;
        if (x > max){
            max = x;
        }
    }
    int l = max;
    int r = sum;


    while (l <= r){
        int mid = (l + r)/2;

        int count = getNum(nums,m,mid);
        if (count > m){
            l = mid + 1;
        }else{
            r = mid;
        }
    }

    }

    public int getNum(int[] nums, int m, int target){
        int count = 1;
        int sum = 0;
        for (int x: nums){
            sum += x;
            if (sum > target){
                count++;
                sum = x;
            }
        }

        return count;

        //A : 3
//B : 10
//C : [ 185, 186, 938, 558, 655, 461, 441, 234, 902, 681 ]



    }

}