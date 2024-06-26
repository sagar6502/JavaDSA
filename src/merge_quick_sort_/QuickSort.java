package merge_quick_sort_;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,4,3,2,1};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] nums, int low, int high) {
		if(low >= high ) {
			return;
		}
		
		int s = low;
		int e = high;
		int m = s+(e-s)/2;
		int pivot = nums[m];
		
		while(s<=e) {
			
			// if it is already sorted, not swap will happen
			while(nums[s]<pivot) {
				s++;
			}
			while(nums[e]>pivot) {
				e--;
			}
			if(s <= e) {
				int temp = nums[s];
				nums[s]=nums[e];
				nums[e]=temp;
				s++;
				e--;
			}
		}
		
		//pivot is at correct index, sort the two halves now
		quickSort(nums,low,e);
		quickSort(nums,s,high);
	}
}
