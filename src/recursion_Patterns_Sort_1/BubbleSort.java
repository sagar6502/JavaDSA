package recursion_Patterns_Sort_1;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12,1,4,2,6,3,9,5,7,0};
//		bubbleSort(arr);
		bubbleSortUsingRecursion(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void bubbleSortUsingRecursion(int[] arr,int i, int j) {
		if(j==0) {
			return;
		}
		if(i<j) {
			if(arr[j]<arr[i]) {
				swap(arr,j,i);
			}
			bubbleSortUsingRecursion(arr,i+1,j);
		}
		 else {
			bubbleSortUsingRecursion(arr,0,j-1);
		}
		
	}
	
	private static void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		if(i != j) {
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
		}
	}
}
