package sortingAlgorithm;

import java.util.Arrays;

public class CountSort2 {
	public static void main(String[] args) {
		int[] arr = {3,4,1,3,2,5,2,8};
		
		int maxE = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			maxE = Math.max(maxE, arr[i]);
		}
		
		int[] narr = new int[maxE+1];
		
		for(int i=0;i<narr.length-1; i++) {
				narr[arr[i]]++;
		}
		int k=0;
		for (int i = 0; i < narr.length; i++) {
			for(int j=0; j<narr[i];j++) {
				arr[k]=i;
				k++;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(narr));
		
	}
}
