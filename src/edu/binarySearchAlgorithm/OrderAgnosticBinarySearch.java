package edu.binarySearchAlgorithm;

public class OrderAgnosticBinarySearch {
	public static void main(String[] args) {
		int[] arr = {123239,12181,348,29,10,7,4,1}; //descending order
		int[] arr2 = {1,4,7,10,29,348,12191,123239}; //ascending order
		System.out.println(binarySearchAg(arr2, 12191));
	}
	
	static int binarySearchAg(int[] arr, int key) {
		int start=0;
		int end = arr.length-1;
		boolean isAsc=false;
		if(arr[start]<arr[end]) {
			isAsc=true;
		}else if(arr[end]<arr[start]) {
			isAsc=false;
		}else if(arr[end]==arr[start]) {
			if(arr[start]==key) {
				return start;
			}
		}
		
		while(start <= end) {
			int mid = start+(end-start)/2;
			if(arr[mid]==key ) {
				return mid+1;
			}
			else if(arr[mid]>key) {
				if(!isAsc) {
					start=mid+1;
				}else {
					end=mid-1;
				}
				
			}
			else if(arr[mid]<key) {
				if(!isAsc) {
					end=mid-1;
				}
				else if(isAsc) {
					start=mid+1;
				}
			}
		}
		return -1;
	}
}	
