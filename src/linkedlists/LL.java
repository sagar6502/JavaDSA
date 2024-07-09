package linkedlists;

import java.util.HashMap;

public class LL {

	Node head;
	private Node tail;
	
	LL next;
	int val;

	int size;

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
		int value;
		Node next;

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
	 
	 //insert using recursion
	 
	 public void insertRec(int val, int index) {
		 head = insertRec(val, index, head);
	 }
	 
	 private Node insertRec(int val, int index, Node node) {
		 if(index==0) {
			 Node temp = new Node(val, node);
			 size++;
			 return temp;
		 }
		 node.next = insertRec(val, index-1,node.next);
//		 System.out.println(node.value);
		 return node;
	 }
	 
	 public static LL merge(LL first, LL second) {
		 Node f = first.head;
		 Node s = second.head;
		 
		 LL ans = new LL();
		 
		 while(f != null && s != null) {
			 if(f.value < s.value) {
				 ans.insertLast(f.value);
				 f = f.next;
			 }
			 else {
				 ans.insertLast(s.value);
				 s = s.next;
			 }
		 }
		 while(f != null) {
			 ans.insertLast(f.value);
			 f = f.next;
		 }
		 
		 while(s != null) {
			 ans.insertLast(s.value);
			 s = s.next;
		 }
		 
		 return ans;
	 }
	 
	 public LL mergeTwoLists(LL f, LL s) {
			LL dummyHead = new LL();
			LL current = dummyHead;
	        while(f != null && s != null){
	            if(f.val < s.val ){
	                current.next = f;
	                f = f.next;
	            }else{
	                current.next = s;
	                s = s.next;
	            }
	            current = current.next;
	        }

	        while(f != null){
	            current.next = f;
	            f = f.next;
	            current  = current.next;
	        }
	        while(s != null){
	            current.next = s;
	            s = s.next;
	            current  = current.next;
	        }

	        return dummyHead.next;
	    }
	 
	 // has cycle or not
	 	public boolean hasCycle(Node head) {
	        if(head == null) return false;
	        Node slow_p = head;
	        Node fast_p = head;

	        while(slow_p != null && fast_p != null && fast_p.next != null) {
	            slow_p = slow_p.next;
	            fast_p = fast_p.next.next;
	            if(slow_p == fast_p){
	                return true;
	            }
	        }
	        return false;
	    }
	 	
	 	public int lengthCycle(Node head) {
	        if(head == null) return 0;
	        Node slow_p = head;
	        Node fast_p = head;

	        while(slow_p != null && fast_p != null && fast_p.next != null) {
	            slow_p = slow_p.next;
	            fast_p = fast_p.next.next;
	            if(slow_p == fast_p){
	                //calculate the length
	            	Node temp = slow_p;
	            	int length=0;
	            	do {
	            		length++;
	            		temp=temp.next;
	            	}while(temp != slow_p);
	            	return length;
	            }
	        }
	        return 0;
	    }
	 	
	 	public LL detectCycle(LL head) {
	        LL slow=head;
	         LL fast=head;
	         while (fast!=null && fast.next!=null){
	             slow=slow.next;
	             fast=fast.next.next;
	             if (fast== slow){
	                 slow= head;
	                 while(slow != fast){
	                 slow=slow.next;
	                 fast=fast.next;
	                 }
	                 return slow;
	             }
	         }
	         return null;
	    
	     }
	 	
	 	public static LL hasCycle(LL head) {
	        HashMap <LL, Integer> map= new HashMap<>();

	        LL temp = head;
	        while(temp != null){
	            if(map.containsKey(temp)){
	                return temp;
	            }else{
	                map.put(temp,1);
	                temp = temp.next;
	            }
	        }
	        return null;
	    }
	 	
	 	public static int cycleLength(LL head) {
	 		int length=0;
	 		LL slow = head;
	 		LL  fast = head;
	 		while(fast != null & fast.next != null) {
	 			slow = slow.next;
	 			fast = fast.next.next;
	 			if(slow == fast) {
	 				do {
	 					length++;
	 					slow = slow.next;
	 				}while(slow != fast);
	 				break;
	 			}
	 		}
	 		return length;
	 	}
	 	
	 	public static LL detectCyclePoint(LL head) {
	 		LL first = head;
	 		LL second = head;
	 		int length = cycleLength(head);
	 		while(length>0) {
	 			second = second.next;
	 			length--;
	 		}
	 		
	 		// keep moving  both forward and they will meet at cycle start
	 		while(first != second) {
	 			first = first.next;
	 			second = second.next;
	 		}
	 		
	 		return second;
	 		
	 	}
	 	
	 	private static LL findMiddleNode(LL head) {
	 		if(head == null) return head;

	 		LL slow = head;
	 		LL fast = head;
	        
	        while(fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }

	        return slow;
	 	}
	 	
	 	private void bubbleSort(int row, int col) {
			if(row == 0) {
				return;
			}
			
			if(col < row) {
				Node first = get(col);
				Node second = get(col + 1);
				
				if(first.value > second.value) {
					//swap
					if(first == head) {
						head = second;
						first.next = second.next;
						second.next = first;
					} else if (second == tail) {
						Node prev = get(col-1);
						prev.next = second;
						tail = first;
						first.next = null;
						second.next = tail;
					} else {
						Node prev = get(col-1);
						prev.next = second;
						first.next = second.next;
						second.next = first;
					}
				}
				bubbleSort(row,col+1);
			}
			else {
				bubbleSort(row-1,0);
			}
		}
		
		public void BubbleSort() {
			bubbleSort(size-1, 0);
		}
	 	
}
