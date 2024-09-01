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
			node.next = node; //maintain circularity
			size++;
			return;
		}
		node.next = head;
		head = node;
		tail.next = head;
		size++;
	}
	
	public void deleteVal(int val) {
		Node node = head;
		if(head == null) {
			System.err.println("linked list is empty");
			return;
		}
		
		if(head.val == val) {
			head = head.next;
			tail.next = head;
			size--;
			return;
		}
		
		do {
			if(node.next.val == val) {
				node.next = node.next.next;
				size--;
				return;
			}
			node = node.next;
		}while(node != head);
		System.out.println("Value not found");
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
		} while(node != head);
		System.out.println("END");
	}
}
