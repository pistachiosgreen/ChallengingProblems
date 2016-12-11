import java.util.*;
public class Solution {
    //225/311 with string
    //Input:[-2,-7,9,0,4,-1,9,-3,-9,8,9,2,-5,-6,2,-10,-3,1,2]
    //Expected Output:[[-10,1,9],[-10,2,8],[-9,0,9],[-9,1,8],[-7,-2,9],[-7,-1,8],
    //[-6,-3,9],[-6,-2,8],[-6,2,4],[-5,-3,8],[-5,1,4],[-3,-1,4],[-3,1,2],[-2,0,2],[-1,0,1]]
    //what I got: [[-2,0,2],[-6,-2,8],[-7,-2,9],[-7,-1,8],[-10,1,9],[-6,-3,9],[-9,0,9],[-6,2,4],
    //[-5,1,4],[-3,-1,4],[-3,1,2],[-5,-3,8],[-9,1,8],[-10,2,8]]
    /* 238/311 with hashmap
    [13,4,-6,-7,-15,-1,0,-1,0,-12,-12,9,3,-14,-2,-5,-6,7,8,2,-4,6,-5,
    -10,-4,-9,-14,-14,12,-13,-7,3,7,2,11,7,9,-4,13,-6,-1,-14,-12,9,9,
    -6,-11,10,-14,13,-2,-11,-4,8,-6,0,7,-12,1,4,12,9,14,-4,-3,11,10,
    -9,-8,8,0,-1,1,3,-15,-12,4,12,13,6,10,-4,10,13,12,12,-2,4,
    7,7,-15,-4,1,-15,8,5,3,3,11,2,-11,-12,-14,5,-1,9,0,-12,6,-1,1,1,2,-3]
    */

    public List<List<Integer>> threeSum(int[] nums) {
    
    	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> hmap = new HashMap<Integer,Integer>();
        String storage = "";
        for (int x: nums){
        	if (hmap.containsKey(x)){
        		int lastval = hmap.get(x);
        		hmap.put(x,lastval + 1); 
        	}
        	else{
        		hmap.put(x,1);
        	}
        }
        Arrays.sort(nums);
        int index = nums.length/2;
        if (nums[index] < 0){

            while(index < nums.length && temp >= 0){
                temp = nums[index];
                index++;
            }
        }
        if (nums[index] > 0){
            while(index > 0 && temp <= 0){
                temp = nums[index];
                index--;
            }

        }

        for (int i = 0; i < nums.length - 2; i++){
            for (int j = nums.length - 1; j > i; j--){
            	int sum = nums[i] + nums[j];
            	int find = 0 - sum;
            	if(hmap.containsKey(find)){
            		int num = hmap.get(find);
            		if (find == nums[i]){
            			num--;
            		}
            		if (find == nums[j]){
            			num--;
            		}
            		if (num > 0){
            			List<Integer> toAdd = new ArrayList<Integer>();
            			toAdd.add(nums[i]);
            			toAdd.add(nums[j]);
            			toAdd.add(find);
                        Collections.sort(toAdd);
                        String temp = "";
                        for (int z: toAdd){
                            temp += String.valueOf(z);
                        }
                        if (!storage.contains(temp)){
                            result.add(toAdd);
                        }
                        /*
            			boolean duplicate = false;
            			Collections.sort(toAdd);
            			for (List y: result){
            				if (y.equals(toAdd)){
            					duplicate = true;
            					break;
            				}
            			}
            			if (duplicate == false){
            				result.add(toAdd);
            			}

                        */
            		}

            	}

        }
        }
        return result;
    }
}