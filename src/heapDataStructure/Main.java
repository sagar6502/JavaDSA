package heapDataStructure;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {

		Heap<Integer> heap = new Heap<Integer>();
		

		heap.insert(10);
		heap.insert(9);
		heap.insert(98);
		heap.insert(20);
		heap.insert(13);

		System.out.println(heap);
		System.out.println(heap.heapSort());
	}

}
