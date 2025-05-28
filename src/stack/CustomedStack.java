package stack;

public class CustomedStack {
	protected int[] data;
	private static final int DEFAULT_SIZE = 10;
	
	int ptr = -1;
	
	public CustomedStack() {
		this(DEFAULT_SIZE);
	}
	
	public CustomedStack(int size) {
		this.data = new int[size];
	}
	
	public boolean push(int item) {
		if(isFull()) {
			System.err.println("Stack is full");
			return false;
		}
		ptr++;
		data[ptr] = item;
		return true;
	}
	
	public int pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		
		return data[ptr--];
	}
	
	public int peek() throws StackException {
		if(isEmpty()) {
			throw new StackException("Stack is empty");
		}
		return data[ptr];
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return ptr == data.length-1;
	}
	
	private boolean isEmpty() {
		return ptr == -1;
	}
	
	void display() throws StackException {
		if(isEmpty()) {
			throw new StackException("Stack is empty");
		}
		
		for (int i = 0; i < ptr; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}

