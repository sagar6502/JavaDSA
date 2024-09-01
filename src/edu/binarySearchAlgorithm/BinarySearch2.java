package edu.binarySearchAlgorithm;

public class BinarySearch2 {
	public static void main(String[] args) {
		int[] arr = {1,4,7,10,29,348,12191,123239};
		System.out.println(binarySearch(arr, 1));
		//if same elements are present in the array, binary search might limit to provide the first occurence of that element.
	}
	
	static int binarySearch(int[] arr, int key) {
		int start=0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = start+(end-start)/2;
			if(arr[mid]==key) {
				return mid+1;
			}
			else if(arr[mid]>key) {
				end=mid-1;
			}
			else if(arr[mid]<key) {
				start=mid+1;
			}
		}
		return -1;
	}
}
