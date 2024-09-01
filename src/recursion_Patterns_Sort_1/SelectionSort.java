package recursion_Patterns_Sort_1;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-9,32,0,12,1,4,2,6,3,9,-8,27,5,7,0,-1,15};
		selectionSortUsingRecursion(arr,0,1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void selectionSortUsingRecursion(int[] arr, int i,int j) {
		if(i==arr.length) return ;
				
		if(j<arr.length) {
			if(arr[i] > arr[j]) {
				swap(arr,i,j);
			}
			selectionSortUsingRecursion(arr,i,j+1);
		}else {
			selectionSortUsingRecursion(arr,i+1,i+1);
		}
	}
	
	private static void selectionSort(int[] arr) {
			for(int i=0;i<arr.length;i++) {
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i] > arr[j]) {
						swap(arr,i,j);
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
