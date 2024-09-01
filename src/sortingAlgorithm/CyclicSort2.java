package sortingAlgorithm;

import java.util.Arrays;

public class CyclicSort2 {
	
	// When given number from range 1, N ==> Use Cyclic Sort
	
	public static void main(String[] args) {
		int[] arr = {9,7,8,15,4,12,14,10,13,11,3,5,0,2,1,6};
		int[] arr1 = {4,3,2,7,8,2,3,1};
		performCycleSort3(arr1);
		System.out.println(Arrays.toString(arr1));;
	}

	
	private static void performCycleSort3(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // Only swap if the current element is in the valid range and not in its correct position
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}


