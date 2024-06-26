package sortingAlgorithm;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = {-1,0,-2,-5,-1};
		performInsertionSort(arr);
//		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void performInsertionSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					swap(arr, j, j-1);
				}else {
					break;
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
