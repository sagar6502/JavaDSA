package edu.binarySearchAlgorithm;

public class FindPeakElementInMountainArray {
	public static void main(String[] args) {
		int[] arr = {1,4,7,10,29,348,12191,123239,6,5,4,3,2,1};
		int[] arr1 = {-5,-4,-3,-2,-1,0,-1,-2,-3,-4,-5,-6};
		int[] arr2 = {3,5,3,2,0};
		System.out.println(binarySearch(arr2));
		//if same elements are present in the array, binary search might limit to provide the first occurence of that element.
	}
	
	static int binarySearch(int[] arr) {
		int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            System.out.println("Mid :: " + mid);
            if (arr[mid] > arr[mid + 1]) {
                // You are in the decreasing part of the array.
                // This means the peak is to the left (including mid).
                end = mid;
            } else {
                // You are in the ascending part of the array.
                start = mid + 1;
            }
            System.out.println("start:: " + start);
            System.out.println("end :: " + end);
        }
        // At the end, start and end will point to the peak element.
        return arr[start];
	}
}
