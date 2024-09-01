package linkedlists;

public class DLL {
	
	private int size;
	private Node head;
	
	private class Node {
		int val;
		Node next;
		Node prev;
		
		public Node(int val) {
			this.val = val;
		}

		public Node(int val, Node next, Node prev) {
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
		
	}
	
	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		node.prev = null;
		if(head != null) {
			head.prev = node;
		}
		head = node;
		size++;
	}
	
	public void insertLast(int val) {
		if(size==0) {
			insertFirst(val);
			return;
		}
		Node newnode = new Node(val);
		Node node = head;
		while(node.next != null) {
			node = node.next;
		}
		node.next = newnode;
		newnode.prev = node;
		size++;
	}
	
	
	public void delFirst() {
		if(size==0) {
			System.err.println("Empty Linked List");
			return;
		}
		head = head.next;
		head.prev = null;
		size--;
	}
	
	public void delLast() {
		if(size==0) {
			System.err.println("Empty Linked List");
			return;
		}
		Node node = head;
		while(node.next.next != null) {
			node = node.next;
		}
		node.next = null;
		size--;
	}
	
	public Node get(int index) {
		if(index<0 || size<0 || index>=size) {
			System.out.print("Invalid scenario");
			return null;
		}
		if(index==0) {
			return head;
		}
		Node node = head;
		for(int i=0;i<index;i++) {
			node = node.next;
		}
		return node;
	}
	
	public void insertAtIndex(int index, int val) {
		if(index==0) {
			System.out.println("First Index");
			insertFirst(val);
			return;
		}
		if(index==size) {
			System.out.println("Last Index");
			insertLast(val);
			return;
		}
		Node node = get(index);
		Node newNode = new Node(val);
//		System.out.println(node.val);
		newNode.prev = node.prev;
		newNode.next = node;
		
		node.prev.next = newNode;
		node.prev = newNode;
		
		size++;
	}
	
	public void delAtIndex(int index) {
		if(index<0 || index>= size) {
			System.err.println("Please enter the correct index");
			return;
		}
		if(index==0) {
			delFirst();
			return;
		}
		if(index==size-1) {
			delLast();
			return;
		}
		Node node = get(index-1);
		node.next = node.next.next;
		if(node.next.next != null) {
			node.next.next.prev = node;
		}
		size--;
		
		return;
	}
	
	public void display() {
		Node node = head;
		Node last = null;
		while(node != null) {
			System.out.print(node.val+" -> ");
			last = node;
			node = node.next;
		}
		System.out.println("END");
	}
}
