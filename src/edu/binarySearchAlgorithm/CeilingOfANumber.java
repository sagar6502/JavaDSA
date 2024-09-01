package edu.binarySearchAlgorithm;

public class CeilingOfANumber {
	public static void main(String[] args) {
		int[] arr = {2,3,5,9,14,16,18};
		int[] arr2= {18,16,14,9,5,3,2};
		System.out.println(findCeil(arr2,19));
	}
	static int findCeil(int[] arr, int key) {
		
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
		
		if(isAsc && (key<arr[start] || key>arr[end])) {
			return -1;
		}
		else if(!isAsc && (key<arr[end] || key>arr[start])) {
			return -1;
		}
		
		while(start <= end) {
			int mid = start+(end-start)/2;
			if(arr[mid]==key) {
				return arr[mid];
			}
			if(isAsc) {
				if(arr[mid]>key) {
					end=mid-1;
				} else {
					start=mid+1;
				}
			}else{
				if(arr[mid]>key) {
					start=mid+1;
				} else {
					end=mid-1;
				}
			}
		}
		if(start>end) {
			start = start^end;
			end = start^end;
			start=start^end;
		}
		
		return isAsc?arr[end]:arr[start];
	}
}
