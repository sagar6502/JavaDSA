package merge_quick_sort_;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,4,3,2,1};
		arr = mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static int[] mergeSort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}
		
		int mid = arr.length/2;
		
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		
		return merge(left,right);
	}

	private static int[] merge(int[] first, int[] second) {
		// TODO Auto-generated method stub
		int[] mix = new int[first.length+second.length];
		
		int i=0; //pointer for first
		int j=0; //pointer for second
		int k=0; //pointer for new array
		
		while(i < first.length && j < second.length) {
			if(first[i]<second[j]) {
				mix[k] = first[i];
				i++;
			}
			else {
				mix[k]=second[j];
				j++;
			}
			k++;
		}
		
		//copying the remaining elements
		
			while(i<first.length) {
				mix[k]=first[i];
				i++;
				k++;
			}
			while(j < second.length) {
				mix[k]=second[j];
				j++;
				k++;
			}
		
		return mix;
	}
}
