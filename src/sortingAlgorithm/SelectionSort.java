package sortingAlgorithm;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {4,5,1,2,3};
//		int[] arr = {4,3,1,2,5};
		performSelectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void performSelectionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			// find the max item in the remaining array and swap with correct index
			int last = arr.length-i-1;
			int maxIndex = getMaxIndex(arr,0,last);
			swapArray(arr, maxIndex, last);
		}
	}

	private static int getMaxIndex(int[] arr, int start, int last) {
		// TODO Auto-generated method stub
		int maxIndex=start;
		for(int i=start;i<=last;i++) {
			if(arr[i]>arr[maxIndex]) maxIndex=i;
		}
		return maxIndex;
	}
	
	private static void swapArray(int[] arr, int i, int j) {
        if(i != j) {
        	arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
