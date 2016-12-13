public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> negmap = new HashMap<Integer,Integer>();
        HashMap<Integer, Integer> posmap = new HashMap<Integer,Integer>();
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        ArrayList<Integer> plist = new ArrayList<Integer>();
        int numZeros = 0;

        for (int x: nums){
            if(x == 0){
                numZeros++;
            }

            if(x < 0){
                if(negmap.containsKey(x)){
                    int lastval = negmap.get(x);
                    negmap.put(x,lastval + 1); 
                 }
                else{
                    negmap.put(x,1);
                    nlist.add(x);
                }
            }
            else{

                if(posmap.containsKey(x)){
                    int lastval = posmap.get(x);
                    posmap.put(x,lastval + 1); 
                 }
                else{
                    posmap.put(x,1);
                    plist.add(x);
                }
            }
        }
        

        for (int i = 0; i < nlist.size(); i++){
            int current = nlist.get(i);
            if (negmap.get(current) > 1){
                if (posmap.containsKey(current * -2)){
                    ArrayList<Integer> toAdd = new ArrayList<Integer>();
                    toAdd.add(current);
                    toAdd.add(current);
                    toAdd.add(current * -2);
                    result.add(toAdd);
                }
            }

           /* if (numZeros >= 1 && posmap.containsKey(current * -1)){
                    ArrayList<Integer> toAdd = new ArrayList<Integer>();
                    toAdd.add(current);
                    toAdd.add(0);
                    toAdd.add(current * -1);
                    result.add(toAdd);
            }
            */
            for (int j = i + 1; j < nlist.size(); j++){
                int left = nlist.get(i);
                int right = nlist.get(j);
                int sum = left + right;
                if (left != 0 && right != 0){
                if (posmap.containsKey(0 - sum)){
                    ArrayList<Integer> toAdd = new ArrayList<Integer>();
                    toAdd.add(nlist.get(i));
                    toAdd.add(nlist.get(j));
                    toAdd.add(0 - sum);
                    result.add(toAdd);
                }
                }
            }

        }

           for (int i = 0; i < plist.size(); i++){
            int current = plist.get(i);
            if (posmap.get(current) > 1){
                if (negmap.containsKey(current * -2)){
                    ArrayList<Integer> toAdd = new ArrayList<Integer>();
                    toAdd.add(current);
                    toAdd.add(current);
                    toAdd.add(current * -2);
                    result.add(toAdd);
                }
            }

            if (numZeros >= 1 && negmap.containsKey(current * -1)){
                    ArrayList<Integer> toAdd = new ArrayList<Integer>();
                    toAdd.add(current);
                    toAdd.add(0);
                    toAdd.add(current * -1);
                    result.add(toAdd);
            }
            for (int j = i + 1; j < plist.size(); j++){
                int left = plist.get(i);
                int right = plist.get(j);
                int sum = left + right;
                if (left != 0 && right != 0){
                if (negmap.containsKey(0 - sum)){
                    ArrayList<Integer> toAdd = new ArrayList<Integer>();
                    toAdd.add(plist.get(i));
                    toAdd.add(plist.get(j));
                    toAdd.add(0 - sum);
                    result.add(toAdd);
                }
            }

        }
           }

           if (numZeros >= 3){
               ArrayList<Integer> toAdd = new ArrayList<Integer>();
               toAdd.add(0);
               toAdd.add(0);
               toAdd.add(0);
               result.add(toAdd);
           }

        return result;
        
}
}