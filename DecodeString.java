public class Solution {
     public String decodeString(String s) {
           if (s.equals("")){
            return "";
        }
        String result = s;

        while (result.indexOf(']') > 0){
            int endindex = result.indexOf(']');

            int startindex = endindex - 1;
            for (int i = endindex - 1; i >= 0; i--){
                char temp = result.charAt(i);
                if (temp == '['){
                    startindex = i;
                    break;
                }
                else{
                   
                }
            }
            int numIndex = startindex - 1;

            for (int i = startindex - 1; i >= 0; i--){
                char temp = result.charAt(i);
                if (Character.isDigit(temp)){
                    numIndex = i;
                }
                else{
                    break;
                }
            }

            int num = Integer.parseInt(result.substring(numIndex,startindex));
            System.out.println(result);
            System.out.println(startindex + 1);
            System.out.println(endindex);
            String repeat = result.substring(startindex + 1, endindex);
            String start = "";
            String end = "";
            if (numIndex != 0){
                start = result.substring(0,numIndex);
            }
            if (endindex != result.length() - 1){
                end = result.substring(endindex + 1);
            }
            String modified = result.substring(0,numIndex) + mult(num,repeat) + result.substring(endindex + 1);
            result = modified;
        }

        return result;
        
     }

    public String mult(int num, String s){
       // System.out.println("HI");
        String result = "";
        for (int i = 0; i < num; i++){
            result+=s;
        }
    //  System.out.println(result);
        return result;
    }
}