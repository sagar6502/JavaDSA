package edu.binarySearchAlgorithm;

public class FindMissingNumber {
	public static void main(String[] args) {
		int[] arr1 = {9,6,4,2,3,5,7,0,1};
		System.out.println(missingNumber(arr1));
	}
	public static int  missingNumber(int[] nums) {
	      int n = nums.length ;
	      int sum1 = (n*(n+1))/2;  
	      int sum2 = 0;
	      for(int i = 0; i < n ;i++){
	        sum2+=nums[i];
	      }
	      int missing =-(sum2-sum1);
	      return missing;
	 }
}
