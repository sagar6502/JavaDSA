package stackAndQueues;

import java.util.Stack;

public class MyQueue_RemoveEfficient {
	private Stack<Integer> first;
	private Stack<Integer> second;
	
	public MyQueue_RemoveEfficient() {
		first = new Stack<>();
		second = new Stack<>();
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		System.out.println(stack.pop());
	}
	
	public void push(int x) {
		while(!first.isEmpty()) {
			second.push(first.pop());
		}
		first.push(x);
		while(!second.isEmpty()) {
			first.push(second.pop());
		}
	}
	
	public int pop() {
		return first.isEmpty()?0:first.pop();
	}
	
	public boolean empty() {
		return first.isEmpty();
	}
	
	public int peek() {
		return first.peek();
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