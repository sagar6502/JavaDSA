package queue;

public class QueueMain {
	public static void main(String[] args) throws QueueException {
		CircularQueue queue = new CircularQueue(5);
		queue.insert(2);
		queue.insert(5);
		queue.insert(1);
		queue.insert(7);
		queue.insert(9);
		
		queue.display();
		System.out.println(queue.front());
		queue.remove();
		System.out.println(queue.front());
		queue.insert(100);
		queue.display();
		
		queue.insert(99);
		queue.display();
	}
}
