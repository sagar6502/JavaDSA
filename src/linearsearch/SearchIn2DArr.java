package linearsearch;

import java.util.Arrays;

public class SearchIn2DArr {
	public static void main(String[] args) {
		int[][] arr = {
						{21,14,12,312},
						{24,23,15,22},
						{13,64,74,32},
						{23,22}
						};
		
		int target = 23;
		System.out.println(Arrays.toString(search(arr,target)));
		System.out.println(findMax(arr));
	}
	
	static int[] search(int[][] arr, int key) {
		for(int i=0; i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==key) return new int[] {i+1,j+1};
			}
		}
		return new int[]{-1,-1};
	}
	
	static int findMax(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for(int[] rowValues:arr) {
			for(int colVal:rowValues) {
				if(colVal>max) max=colVal;
			}
		}
		return max;
	}
}
