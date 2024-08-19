package sortingAlgorithm;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {29,83,471,36,91,8};
		
		System.out.println("Original array for : "+Arrays.toString(arr));
		
		radixSort(arr);
		
		System.out.println("Sorted array for : "+Arrays.toString(arr));
	}
	
	public static void radixSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		
		// do count sort for every digit place
		for(int exp = 1; max/exp > 0; exp *= 10) {
			countSort(arr, exp);
		}
	}
		
	public static void countSort(int[] arr, int exp) {
		
		int n = arr.length;
		
		int[] output = new int[n];
		
		int[] count = new int[10];
		
		for (int s = 0; s < n; s++) {
			count[(arr[s]/exp)%10]++;
		}
		
		System.out.println("Count array for "+exp+" : "+Arrays.toString(count));
		
		for (int i =1; i < 10; i++) {
			count[i] = count[i]+count[i-1];
		}
		
		System.out.println("Updated Count array for : "+Arrays.toString(count));
		
		for(int i = n-1; i >= 0; i--) {
			output[count[(arr[i]/exp)%10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		
		System.out.println("Updated Output array for : "+Arrays.toString(count));
		
		System.arraycopy(output, 0, arr, 0, n);
	}

}
