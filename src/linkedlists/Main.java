package linkedlists;

public class Main {
	public static void main(String[] args) {
		LL list = new LL();
		list.insertFirst(3);
		list.insertFirst(1);
		list.insertFirst(7);
		list.insertLast(9);
		list.display();
		list.delLast1();
		list.insertLast1(99);
		list.delFirst();
		list.insert(100, 2);
		list.display();
		list.deleteAtIndex(1);
		list.display();
		System.out.println(list.getIndex(100));
	}
}
