package edu.binarySearchAlgorithm;

public class SmallestLetterGreaterThanTarget {
	public static void main(String[] args) {
		char[] arr = {'c','f','j'};
		System.out.println(findSmallestLetter(arr,'g'));
	}
	static char findSmallestLetter(char[] arr, char key) {
		
		int start=0;
		int end = arr.length-1;
		
		
		boolean isAsc=false;
		if(arr[start]<arr[end]) {
			isAsc=true;
		}else if(arr[end]<arr[start]) {
			isAsc=false;
		}else if(arr[end]==arr[start]) {
			if(arr[start]==key) {
				System.out.println("Not found");
			}
		}
		
		if(key>arr[end]) {
			return arr[start];
		}
		
		while(start <= end) {
			int mid = start+(end-start)/2;
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
