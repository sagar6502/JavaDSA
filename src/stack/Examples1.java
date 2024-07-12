package stack;

import java.util.Stack;

public class Examples1 {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(99);
		
//		System.out.println(st.peek());
		
		System.out.println(st);
	}
}
