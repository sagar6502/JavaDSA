package linkedlists;

public class Main {
	public static void main(String[] args) {
//		LL list = new LL();
//		list.insertFirst(3);
//		list.insertFirst(1);
//		list.insertFirst(7);
//		list.insertLast(9);
//		list.display();
//		list.delLast1();
//		list.insertLast1(99);
//		list.delFirst();
//		list.insert(100, 2);
//		list.display();
//		list.deleteAtIndex(1);
//		list.display();
//		System.out.println(list.getIndex(100));
		
		DLL list = new DLL();
		list.insertFirst(3);
		list.insertFirst(6);
		list.insertFirst(9);
		list.insertFirst(13);
		list.insertFirst(17);
		list.insertFirst(91);
		list.display();
		list.insertLast(7);
//		list.insertLast(79);
		list.display();
		list.insertAtIndex(6,100);
		list.display();
//		list.delAtIndex(6);
//		list.display();
	}
}
