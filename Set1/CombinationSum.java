public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int find = target;
        Array.sort(candidates);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Integer> oneway = new Stack<Integer>();
        DFS(index, target, result, oneway, candidates);

        return result;
    }


    public void DFS(int index, int target, ArrayList<List<Integer>> result, Stack<Integer> oneway, int[] candidates){
    	if (target == 0){
    		result.add(new ArrayList<Integer>(oneway));
    		return;
    	}

    	if (target < 0){
    		return;
    	}

    	for (int i = index; i < candidates.length; i++){
    		int temp = candidates[i];
    		oneway.push(temp);
    		DFS(i, target - temp, result, oneway, candidates);
    		oneway.pop();
    	}


    }

}