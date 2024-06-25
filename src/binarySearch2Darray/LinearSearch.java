package binarySearch2Darray;

import java.util.Arrays;

public class LinearSearch {
	public static void main(String[] args) {
		int[][] arr = {
				{18,9,12},
				{36,-4,91},
				{44,33,16}
				};
		
		int target = 33;
		System.out.println(Arrays.toString(searchBinary(arr,target)));;
	}
	
	private static int[] searchBinary(int[][] arr, int target){
		for(int i=0; i<arr.length; i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==target) {
					return new int[] {i+1,j+1};
				}
			}
		}
		
		return new int[] {};
		
	}
}
