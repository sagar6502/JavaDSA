package linkedlists;

public class RemoveDuplicates {
	public class ListNode {
		    public int val;
		      public ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static void main(String[] args) {
		
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
                if(temp.val == temp.next.val){
                        temp.next = temp.next.next;
                } else 
                {
                        temp = temp.next;
                }
        }
        return head;
    }
}
