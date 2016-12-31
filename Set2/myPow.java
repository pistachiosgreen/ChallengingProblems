public class Solution {
   
    public double myPow(double x, int n) {
        //System.out.println(x);
        //System.out.println(n);
    	if (n == 0) return 1;
    	if (n == 1) return x;
    	if (n == 2) return x * x;
    	if (x == 1.0) return x;
            	
    	if (n < 0){
    	    n = Math.abs(n);
    	    double newX = 1.0/x;
    	    return newX * myPow(newX,n - 1);
    	   // if (!(n % 2 == 0)){
    	     //   return newX * myPow(myPow(newX,n/2), 2);
    	   // }
    	    //return myPow(myPow(newX,n/2), 2);
    	}
    	
    	if (!(n % 2 == 0)){
    	//	n = n - 1;
    		n = n - 1;
    		return x * myPow(myPow(x,n/2), 2);
    	}
    
    	   
    	return myPow(myPow(x,n/2), 2);
    
    }
 
}