package stringprograms;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = {1,6,3,8,4,7,2};
		reverseArray(arr);
		System.out.println(Arrays.toString(arr));
		printValue(1,2,3,5,2,7,83,2,6,8,3);
	}
	
	private static void reverseArray(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		while(start<end) {
			//swap
			swap(arr,start, end);
			start++;
			end--;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private static void swap(int[] arr, int x, int y) {
		if (x != y) { // Only swap if indices are different
	        arr[x] = arr[x] ^ arr[y];
	        arr[y] = arr[x] ^ arr[y];
	        arr[x] = arr[x] ^ arr[y];
	    }
		
	}
	
	private static void printValue(int ...val) {
		System.out.println(Arrays.toString(val));
	}
}
