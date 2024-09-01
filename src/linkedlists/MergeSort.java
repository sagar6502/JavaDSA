package linkedlists;

public class MergeSort {
	public static void main(String[] args) {
		
	}
	
	public static LL sortList(LL head) {
		if( head == null || head.next == null) {
			return head;
		}
		LL mid = findMiddleNode(head);
		LL left = sortList(head);
		LL right = sortList(mid);
		
		return merge(left, right);
	}
	
	private static LL findMiddleNode(LL head) {
 		if(head == null) return head;

 		LL slow = head;
 		LL fast = head;
 		LL prev = null;
        
        while(fast != null && fast.next != null) {
        	prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null) {
        	prev.next = null;
        }
        return slow;
 	}
	
	public static LL merge(LL list1, LL list2) {
		LL dummyHead = new LL();
		LL tail = dummyHead;
		 
		 while(list1 != null && list2 != null) {
			 if(list1.val < list2.val) {
				 tail.next = list1;
				 list1 = list1.next;
				 tail = tail.next;
			 } else {
				 tail.next = list2;
				 list2 = list2.next;
				 tail = tail.next;
			 }
		 }
		 tail.next = (list1 != null) ? list1:list2;
		 return dummyHead.next;
	 }
	
	
	 
}
