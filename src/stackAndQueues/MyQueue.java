package stackAndQueues;

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> first;
	private Stack<Integer> second;
	
	public MyQueue() {
		first = new Stack<>();
		second = new Stack<>();
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		System.out.println(stack.pop());
	}
	
	public void push(int x) {
		first.push(x);
	}
	
	public int pop() {
		while(!first.isEmpty()) {
			second.push(first.pop());
		}
		
		int removed = second.pop();
		
		while(!second.isEmpty()) {
			first.push(second.pop());
		}
		
		return removed;
	}
	
	public boolean empty() {
		return first.isEmpty();
	}
	
	public int peek() {
		while(!first.isEmpty()) {
			second.push(first.pop());
		}
		int removed = second.peek();
		
		while(!second.isEmpty()) {
			first.push(second.pop());
		}
		
		return removed;
	}

	/*
	public MyQueue() {

	}

	*/
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */