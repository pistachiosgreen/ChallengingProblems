public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0){
            return result;
        }
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        result.add(prev);
        if (numRows == 1){
            return result;
        }
        
        for (int i =  2; i <= numRows; i++){
            List<Integer> next = new ArrayList<Integer>();
            next.add(1);
            if (prev.size() >= 2){
                for (int j = 1; j < prev.size(); j++){
                    int insert = prev.get(j) + prev.get(j - 1);
                    next.add(insert);

                }
            }

            next.add(1);
            result.add(next);
            prev = next;
        }
    return result;
        
    }
}