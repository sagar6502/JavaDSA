package potds;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySorted {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 2, 3, 6, 7, 8, 9, 10 };
		nearlySorted(arr, 2);
	}

	public static void nearlySorted(int[] arr, int k) {
		// code
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int i = 0; i <= k && i < arr.length; i++) {
			minHeap.add(arr[i]);
		}
//		System.out.println(minHeap);
		int id = 0;
		for (int i = k + 1; i < arr.length; i++) {
			arr[id++] = minHeap.poll();
			minHeap.add(arr[i]);
		}
//		System.out.println(Arrays.toString(arr));
		while (!minHeap.isEmpty()) {
			arr[id++] = minHeap.poll();
		}
		System.out.println(Arrays.toString(arr));
	}
}
