package edu.binarySearchAlgorithm;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40}; // for array of size-infinite
		int key = 10;
		int start = findStartAndEnd(arr,key)[0];
		int end = findStartAndEnd(arr,key)[1];
		System.out.println(binarySearch(arr, key,start,end));
		//if same elements are present in the array, binary search might limit to provide the first occurrence of that element.
	}
	
	private static int[] findStartAndEnd(int[] arr, int key) {
		int start=0;
		int end = 1;
		while(key>arr[end]) {
			int newStart = end+1;
			end = end+(end-start+1)*2;
			try {
				int k = arr[end];
			}catch(Exception e) {
				if(e instanceof ArrayIndexOutOfBoundsException) {
					
				}
			}
			start = newStart;
		}
		return new int[] {start,end};
	}
	
	static int binarySearch(int[] arr, int key, int start, int end) {
//		System.out.println(start);
//		System.out.println(end);
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
