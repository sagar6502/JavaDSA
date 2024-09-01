package edu.binarySearchAlgorithm;

import java.util.Arrays;

public class FirstAndLastElementInSortedArray {
	public static void main(String[] args) {
		int[] arr = {5,7,7,7,7,8,8,10};
		System.out.println(firstIndex(arr, 8));
		System.out.println(lastIndex(arr, 8));
	}
	
	static int firstIndex(int[] arr, int key) {
		
        int start=0;
		int end = arr.length-1;
		int keyIndex=Integer.MIN_VALUE;
		int first=keyIndex;
		int last = keyIndex;
		while(start <= end) {
			int mid = start+(end-start)/2;
			if(arr[mid]==key) {
				first = mid;
				end=mid-1;
			}
			else if(arr[mid]>key) {
				end=mid-1;
			}
			else if(arr[mid]<key) {
				start=mid+1;
			}
		}
		
		
             return first;
	}
	static int lastIndex(int[] arr, int key) {
		
        int start=0;
		int end = arr.length-1;
		int keyIndex=Integer.MIN_VALUE;
		int last = keyIndex;
		while(start <= end) {
			int mid = start+(end-start)/2;
			if(arr[mid]==key) {
				last = mid;
				start=mid+1;
			}
			else if(arr[mid]>key) {
				end=mid-1;
			}
			else if(arr[mid]<key) {
				start=mid+1;
			}
		}
		
		
        return last;
	}
}
