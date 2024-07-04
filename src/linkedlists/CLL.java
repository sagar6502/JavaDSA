package linkedlists;

public class CLL {
	
	private Node head;
	private Node tail;
	private int size;
	
	public CLL() {
		this.size = size;
	}

	public CLL(Node head, Node tail) {
		this.head = null;
		this.tail = null;
	}

	private class Node{

		int val;
		Node next;
		public Node(int val) {
//			super();
			this.val = val;
		}

		
	}
	
	public void insert(int val) {
		Node node = new Node(val);
		if(head == null) {
			head=node;
			tail = node;
			node.next = node;
			size++;
			return;
		}
		tail.next=node;
		node.next=head;
		tail = node;
		size++;
	}
	
	public void insertFirst(int val) {
		Node node = new Node(val);
		if(head == null) {
			head=node;
			tail = node;
			node.next = node;
			size++;
			return;
		}
		node.next = head;
		head = node;
		tail.next = head;
		size++;
	}

	
	public void display() {
		if(head == null) {
			System.err.println("Linked List is empty");
			return;
		}
		
		Node node = head;
		do {
			System.out.print(node.val+" -> ");
			node = node.next;
		}while(node != head);
		System.out.println("END");
	}
}
