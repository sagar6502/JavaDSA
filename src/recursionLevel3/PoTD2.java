package recursionLevel3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoTD2 {
	public static void main(String[] args) {
			ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0,0,0));
			
			long ans1 = findMaxProduct(ans);
			System.out.println(ans1);
	}
	
	 public static long findMaxProduct(List<Integer> arr) {
	        // code here
	        if(arr.size() == 1){
	            return arr.get(0);
	        }
	        long prod = Integer.MIN_VALUE;
			
			List<List<Integer>> ls = new ArrayList<List<Integer>>();
			ls = findSubArray(arr);
			for(List<Integer> ans : ls) {
//	 		    if(ans.contains(0)) {
//	 				return 0;
//	 			}
				System.out.println(ans);
				prod = Math.max(prod, findProd(ans));
			}
			
			return prod;
	    }
	    
	    private static long findProd(List<Integer> ans) {
			// TODO Auto-generated method stub
	    	if(ans.size() <= 0) {
	    		return 0;
	    	}
	    	long prod = ans.get(0);
	    	for(int i=1;i<ans.size();i++) {
	    		if(ans.get(i)==0) return 0;
	    		prod *= ans.get(i);
	    	}
			return prod;
		}

		private static List<List<Integer>> findSubArray(List<Integer> arr){
	        int[] narr = new int[arr.size()];
	        
	        for (int i = 0; i < arr.size(); i++) {
				narr[i] = arr.get(i);
			}
	        
	        return returnSubSet(narr);
	    }
	    
	    private static List<List<Integer>> returnSubSet(int[] arr) {
	    	List<List<Integer>> outer = new ArrayList<>();
			outer.add(new ArrayList<>());
			
			for(int num: arr) {
				int n = outer.size();
				System.out.println(n);
				for(int i=0;i<n;i++) {
//					System.out.println("outer.get("+i+") : "+outer.get(i));
					List<Integer> inner = new ArrayList<>(outer.get(i));
					inner.add(num);
					outer.add(inner);
				}
			}
			
			return outer;
	    }
}
