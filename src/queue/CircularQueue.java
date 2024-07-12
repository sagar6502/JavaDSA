package queue;

public class CircularQueue {
	protected int[] data;
	private static final int DEFAULT_SIZE = 10;
	
	int end = 0;
	int front = 0;
	private int size=0;
	
	public CircularQueue() {
		this(DEFAULT_SIZE);
	}
	
	public CircularQueue(int size) {
		this.data = new int[size];
	}
	
	public boolean isFull() {
		// TODO Auto-generated method stub
		return size == data.length;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
	
	public boolean insert(int item) {
		if(isFull()) {
			System.err.println("Queue is Full");
			return false;
		}
		data[end++] = item;
		end = end % data.length; 
		size++;
		return true;
	}
	
	public int remove() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		
		int removed = data[front++];
		front = front % data.length;
		size--;
		return removed;
	}
	
	public int front() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		
		return data[front];
	}
	
	void display() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Queue is Empty");
		}
		int i=front;
		do {
			System.out.print(data[i]+" -> ");
			i++;
			i = i%data.length;
		} while(i != end);
		System.out.println("END");
	}
}
