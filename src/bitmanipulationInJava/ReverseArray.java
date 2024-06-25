package bitmanipulationInJava;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = {1,132,6,23,5,1,5,6,123,678,21,5};
		System.out.println(Arrays.toString(reverseArray(arr)));
	}
	
	private static int[] reverseArray(int[] arr) {
		int start=0;
		int end=arr.length-1;
		while(start<end) {
			swap(arr,start,end);
			start++;
			end--;
		}
		return arr;
	}
	
	private static void swap(int[] arr,int i, int j) {
		if(i != j) {
			arr[i]=arr[i]^arr[j];
			arr[j]=arr[i]^arr[j];
			arr[i]=arr[i]^arr[j];
		}
	}
}
