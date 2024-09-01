package sortingAlgorithm;

import java.util.Arrays;
import java.util.HashMap;

public class CountSort {
	public static void main(String[] args) {
		int[] arr = {3,4,1,3,2,5,2,8};
		
		int maxE = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			maxE = Math.max(maxE, arr[i]);
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(map.get(arr[i]) != null) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		
//		System.out.println(map);
		int k = 0;
		for(int i=0; i<maxE;i++) {
			if(map.get(i) != null ) {
				for(int j=0;j<map.get(i);j++) {
					arr[k]=i;
					k++;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
