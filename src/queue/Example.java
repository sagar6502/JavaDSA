package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Example {
	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();
		que.add(3);
		que.add(4);
		que.add(0);
		que.add(10);
		
		System.out.println(que.peek());
	}
}
