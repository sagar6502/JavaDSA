package merge_quick_sort_;

import java.util.Arrays;

public class QuickSort2 {
		public static void main(String[] args) {
			int[] arr  = {2,5,3,6,7,2,1,0};
			quickSort(arr,0,arr.length-1);
			System.out.println(Arrays.toString(arr));
		}
		static int i=1;
		private static void quickSort(int[] arr, int low, int hi) {
			if(low >=  hi) {
				return;
			}
			int s = low;
			int e = hi;
			int m = s+(e-s)/2;
			int pivot = arr[m];
			
			while(s<=e) {
				while(arr[s]<pivot) {
					s++;
				}
				while(arr[e]>pivot) {
					e--;
				}
				if(s<=e) {
					int temp = arr[s];
					arr[s]=arr[e];
					arr[e]=temp;
					s++;
					e--;
				}
			}
			
//			System.out.println("low : "+i+" : "+low);
//			System.out.println("e : "+i+" : "+e);
//			System.out.println("s : "+i+" : "+s);
//			System.out.println("hi : "+i+" : "+hi);
			i++;
//			System.out.println(Arrays.toString(arr));
			quickSort(arr,low,e);
//			System.out.println("low 2 : "+i+" : "+low);
//			System.out.println("e 2 : "+i+" : "+e);
//			System.out.println("s 2 : "+i+" : "+s);
//			System.out.println("hi 2 : "+i+" : "+hi);
			quickSort(arr,s,hi);
		}
}
