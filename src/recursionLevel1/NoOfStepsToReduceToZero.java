package recursionLevel1;

public class NoOfStepsToReduceToZero {
	public static void main(String[] args) {
		int num = 14;
		System.out.println(numberOfSteps(num));
	}
	
	 public static int numberOfSteps2(int num) {
	        int c = 0;
	        while(num != 0){
	            if((num&1)==0){
	                num /= 2;
	            }else{
	                num -= 1;
	            }
	            c++;
	        }
	        return c;
	   }
	 
	 public static int numberOfSteps(int num) {
		 return helper2(num, 0);
	 }
	 
	 private static int helper(int n, int c) {
		 if(n==0) return c;
		 
		 if((n & 1)==0) n /= 2;
		 else n -= 1;
		 c = c+1;
		 return helper(n,c);
	 }
	 
	 private static int helper2(int n, int c) {
		 if(n==0) return c;
		 
		 if((n & 1)==0) {
			 return helper(n/2,c+1);
		 }
		 else {
			 return helper(n-1,c+1);
		 }
		 
	 }
}
