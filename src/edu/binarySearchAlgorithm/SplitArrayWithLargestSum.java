package edu.binarySearchAlgorithm;

public class SplitArrayWithLargestSum {
	public static void main(String[] args) {
		int[] arr = {7,2,5,10,8};
		int k = 2;
		System.out.println(splitArray(arr, k));
	}
	public static int splitArray(int[] arr, int k) {
		int start = max(arr);
		int end = sumArr(arr);
		while(start < end) {
			int mid = start+(end-start)/2;
			
			// calculate the max-pieces
			int sum=0;
			int pieces=1;
			for(int num: arr) {
				if(sum+num > mid) {
					//cannot add in new array
					sum = num; //for new sum array for new sub array
					pieces++;
				}else {
					sum += num;
				}
			}
			if(pieces<=k) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
        return start;
    }
	
	 private static int max(int[] arr){
	        int max = Integer.MIN_VALUE;
	        for(int i:arr){
	            if(i>max) max=i;
	        }
	        return max;
	}
	 
	 private static int sumArr(int[] arr){
	        int sum=0;
	        for(int i:arr){
	            sum += i;
	        }
	        return sum;
	  }
}
