package queue;

import stack.StackException;

public class CustomedQueue {
	protected int[] data;
	private static final int DEFAULT_SIZE = 10;
	
	int end = 0;
	
	public CustomedQueue() {
		this(DEFAULT_SIZE);
	}
	
	public CustomedQueue(int size) {
		this.data = new int[size];
	}
	
	public boolean isFull() {
		// TODO Auto-generated method stub
		return end == data.length;
	}
	
	private boolean isEmpty() {
		return end == 0;
	}
	
	public boolean insert(int item) {
		if(isFull()) {
			System.err.println("Queue is Full");
			return false;
		}
		data[end++] = item;
		return true;
	}
	
	public int remove() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		
		int removed = data[0];
		
		// shift elements to left;
		for (int i = 1; i < end; i++) {
			data[i-1]=data[i];
		}
		end--;
		return removed;
	}
	
	public int front() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		
		return data[0];
	}
	
	public int end() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		
		return data[end];
	}
	
	void display() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		
		for (int i = 0; i < end; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}
