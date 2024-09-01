package sortingAlgorithm;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {3,1,5,4,2};
		boolean swapped;
//		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length-1;i++) {
			swapped = false;
			for(int j=1;j<=arr.length-i-1;j++) {
				if(arr[j]<arr[j-1]) {
					swap(arr,j,j-1);
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
