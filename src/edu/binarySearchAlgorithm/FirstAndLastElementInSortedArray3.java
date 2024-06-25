package edu.binarySearchAlgorithm;

import java.util.Arrays;

public class FirstAndLastElementInSortedArray3 {
	public static void main(String[] args) {
		int[] arr = {5,7,7,7,7,8,8,10}; // for array of size-infinite
		System.out.println(Arrays.toString(searchRange(arr, 7)));
	}
	
	public static int[] searchRange(int[] arr, int key) {
		int first = returnIndex(arr,key,true);
		int last = -1;
		if(first != -1) {
			last = returnIndex(arr,key,false);
		}
		return new int[]{first,last};
    }

    static int returnIndex(int[] arr, int key,boolean findFirstIndex) {
        int start=0;
		int end = arr.length-1;
		int index=-1;
		while(start <= end) {
			int mid = start+(end-start)/2;
			if(arr[mid]==key) {
				index = mid;
				if(findFirstIndex) {
					end=mid-1;
				}else {
					start=mid+1;
				}
			}
			else if(arr[mid]>key) {
				end=mid-1;
			}
			else if(arr[mid]<key) {
				start=mid+1;
			}
		}
             return index;
	}
}
