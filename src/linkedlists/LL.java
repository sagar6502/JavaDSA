package linkedlists;

public class LL {

	private Node head;
	private Node tail;

	private int size;

	public LL() {
		this.size = 0;
	}

	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;

		if (tail == null) {
			tail = head;
		}

		size += 1;
	}

	public void delFirst() {
		if (head == null) {
			System.err.print("No data present");
			return;
		}
		Node temp = head;
		head = temp.next;
		
		if(head==null) {
			tail = null;
		}
		
		size--;
	}
	
	public Node get(int index) {
		if(index<0 || index>size) {
			System.out.println("Invalid index");
			return null;
		}
		Node node = head;
		for(int i=0; i < index;i++) {
			node = node.next;
		}
		return node;
	}

	public void delLast() {
		if (head == null) {
			System.err.print("No data present");
			return;
		}
		if(size == 1) {
			delFirst();
			return;
		}
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;

		size -= 1;
	}
	
	public void delLast1() {
		if (head == null && tail == null) {
			System.err.print("No data present");
			return;
		}
		if(size == 1) {
			delFirst();
			size--;
			return;
		}

		Node secondLast = get(size-2);
		tail = secondLast;
		tail.next = null;
		size--;
	}

	public void insertLast(int val) {
		if (head == null) {
			head = new Node(val);
			size++;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(val);
		size++;
	}
	
	public void deleteAtIndex(int index) {
		if(index<0 && index>size) {
			System.err.println("Invalid Index");
			return;
		}
		if(index == 0) {
			delFirst();
			return;
		}
		if(index == size-1) {
			delLast();
			return;
		}
		
		Node prev = get(index-1);
		prev.next = prev.next.next;
		size--;
	}
	
	public int getIndex(int val) {
		Node temp = head;
		int index=0;
		int count=0;
		while(temp != null) {
			if(temp.value == val) {
				System.out.println("Find");
				index = count;
			}
			count++;
			temp = temp.next;
		}
		return index;
	}

	public void insertLast1(int val) {
		if (tail == null) {
			insertFirst(val);
			return;
		}

		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size++;
	}
	
	// 0 - based indexing
	public void insert(int val, int index) {
		if(index==0) {
			insertFirst(val);
			return;
		}
		if(index == size) {
			insertLast(val);
			return;
		}
		
		Node temp = head;
		for(int i = 1; i < index; i++) {
			temp = temp.next;
		}
		
		Node node = new Node(val, temp.next); 
		temp.next = node;
		
		size++;
	}
	
	public  void removeNode(Node node) {
		int in = getNodeIndex(node);
//		System.out.println(in);
		Node pNode = get(in-1);
		pNode.next = node.next;
	}
	
	public   int getNodeIndex1(Node node) {
		Node temp = head;
		int index=-1;
		int count=0;
		while(temp != null) {
			if(temp.value == node.value) {
				index = count;
			}
			count++;
			temp = temp.next;
		}
		return index;
	}
	
	public   int getNodeIndex(Node node) {
		Node temp = node; // Start from the given node
        int index = -1;
        int count = 0;
    
        while (temp != null) {
            if (temp.value == node.value) {
                index = count;
                // break; // Optional: Exit loop once found, if node data is unique
            }
            count++;
            temp = temp.next;
        }
    
        return index;
	}
	

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
		System.out.println("END");
	}

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	 public  Node removeAllDuplicates() {
	        // code here
	        Node node = head;
	        while(node != null) {
	        	if(node.value == node.next.value) {
	        		removeNode(node.next);
	        	}
	        	node = node.next;
	        }
	        return node;
	        
	 }
}
