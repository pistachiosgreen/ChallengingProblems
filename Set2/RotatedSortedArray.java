public class Solution {
   public int search(int[] nums, int target) {
    //find pivot
    int pivot = pivot(nums,0, nums.length - 1);
    if (nums[pivot] == target){
    	return pivot;
    }
    if (nums[0] <= target){
    	return binarySearch(nums,0,pivot - 1, target);
    }
    return binarySearch(nums,pivot + 1, nums.length - 1,target);

    }

    public int pivot(int[] nums, int low, int high){
    	if (low > high){
    		return -1;
    	}
    	if (low == high){
    		return low;
    	}

    	//456 712
    	int mid = (low + high)/2;
    	if (mid < high && nums[mid] > nums[mid + 1]){
    		return mid;
    	}

    	if (mid > low && nums[mid] < nums[mid - 1]){
    		return mid - 1;
    	}

    	if (nums[low] > nums[mid]){
    		return pivot(nums,low, mid - 1);
    	}
    	
    	return pivot(nums,mid + 1, high);

    }

    public int binarySearch(int[] nums, int low, int high, int target){
    	if (low > high){
    		return -1;
    	}
    	int mid = (low + high)/2;
    	if (target == nums[mid]){
    		return mid;
    	}

    	
    	if (target > nums[mid]){
    		return binarySearch(nums,mid + 1,high,target);
    	}

    	return binarySearch(nums,low, mid - 1, target);
    }
}
