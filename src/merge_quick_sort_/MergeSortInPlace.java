package merge_quick_sort_;

import java.util.Arrays;

public class MergeSortInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,4,3,2,1};
		mergeSortInPlace(arr,0,arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSortInPlace(int[] arr, int s, int e) {
		if(e-s == 1) {
			return ;
		}
		
		int mid = s+(e-s)/2;
		
		mergeSortInPlace(arr,s, mid);
		mergeSortInPlace(arr, mid,e);
		
		mergeInPlace(arr,s, mid,e);
	}

	private static void mergeInPlace(int[] arr, int s, int m, int e) {
		// TODO Auto-generated method stub
		int[] mix = new int[e-s];
		
		int i=s; //pointer for first
		int j=m; //pointer for second
		int k=0; //pointer for new array
		
		while(i < m && j < e) {
			if(arr[i]<arr[j]) {
				mix[k] = arr[i];
				i++;
			}
			else {
				mix[k]=arr[j];
				j++;
			}
			k++;
		}
		
		//copying the remaining elements
		
			while(i<m) {
				mix[k]=arr[i];
				i++;
				k++;
			}
			while(j < e) {
				mix[k]=arr[j];
				j++;
				k++;
			}
		
		for(int l=0; l<mix.length;l++) {
			arr[s+l]=mix[l];
		}
	}
}
