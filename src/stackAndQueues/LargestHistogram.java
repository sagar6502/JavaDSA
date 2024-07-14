package stackAndQueues;

import java.util.Stack;

public class LargestHistogram {
	public static void main(String[] args) {
		
	}
	
	// brute-force approach
	// probability of TLE
	
	public int largestRectangleArea(int[] arr) {
        int largRect = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largRect = Math.max(largRect,arr[i]*countHowMany(arr,i));
        }
        return largRect;
        
    }

    private static int countHowMany(int[] arr, int i){
        int count = 1;
        int left = i-1 ;
        int right = i+1;
        // System.out.println("left: "+left);
        //  System.out.println("right: "+right);
        while(left>=0){
            
            if(arr[i] >arr[left]){
                break;
            } 
            // System.out.println("left");
            count++;
            left--;
        }
        while(right<arr.length){
             
            if(arr[i]>arr[right]){
                break;
            } 
            // System.out.println("right");
            count++;
            right++;
        }
        return count;
    }
    
    
    //optimized - to be discussed
    
    public static long getMaxArea(long arr[], long n) 
    {
        // your code here
        long max = 0;
        Stack<Integer> stack = new Stack<Integer>();


        for(int i=0;i<arr.length;i++){
            
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                max = getMax(arr, stack, max, i);
            }

            stack.push(i);

        }

        int i = arr.length;
        while(!stack.isEmpty()){
            max = getMax(arr, stack, max, i); 
        }

        return max;
        
    }
    
    private static long getMax(long[] arr, Stack<Integer> stack, long max, int i){
        long area;
        int popped = stack.pop();

        if(stack.isEmpty()){
            area = (long)(arr[popped]*i);
        }else{
            area = (long)(arr[popped]*(i-1-stack.peek()));
        }
        area = Math.max(max, area);
        return area;
    }
}
