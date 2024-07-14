package stackAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GameOfTwoStacks {
	public static void main(String[] args) {
		List<Integer> ans1 = new ArrayList<>(Arrays.asList(4,2,4,6,1));
		List<Integer> ans2 = new ArrayList<>(Arrays.asList(2,1,8,5));
		
		int[] a = new int[ans1.size()];
		int[] b = new int[ans2.size()];
		
		for(int i=0; i<ans1.size(); i++) {
			a[i]=ans1.get(i);
		}
		
		for(int i=0; i<ans2.size(); i++) {
			b[i]=ans2.get(i);
		}
		
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		for(Integer i:ans1) {
			s1.push(i);
		}
		
		for(Integer i:ans2) {
			s2.push(i);
		}
		int totalCount = twoStacks(10,a,b,0,0);
		int totalCount2 = twoStacks(10,s1,s2,0,0);
		System.out.println(totalCount);
		System.out.println(totalCount2);
	}
	
	public static int twoStacks(int maxSum, int[] a, int[] b, int mySum,int count) {
	    // Write your code here
	    if(mySum > maxSum) {
	    	return count;
	    }
	    
	    if( a.length == 0 || b.length == 0) {
	    	return count;
	    }
	    
	    int count1 = twoStacks(maxSum,Arrays.copyOfRange(a, 1, a.length),b,mySum+a[0],count+1);
	    int count2 = twoStacks(maxSum,a,Arrays.copyOfRange(b, 1, b.length),mySum+b[0],count+1);
	    
	    return Math.max(count1, count2);
	}
	
	public static int twoStacks(int maxSum, Stack<Integer> a, Stack<Integer> b, int mySum,int count) {
        // Write your code here
        if(mySum > maxSum) {
            return count;
        }
        
        if( a.isEmpty() || b.isEmpty()) {
        	return count;
        }
        int count1 = twoStacks(maxSum,a,b,mySum+a.pop(),count+1);
        int count2 = twoStacks(maxSum,a,b,mySum+b.pop(),count+1);
        
        return Math.max(count1, count2);
    }
}
