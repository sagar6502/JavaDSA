package linkedlists;

public class Main {
	public static void main(String[] args) {
		
		
		LL list = new LL();
		list.insertFirst(3);
		list.insertFirst(1);
		list.insertFirst(7);
		list.insertLast(9);
		list.display();
		list.insertRec(20, 4);
		list.display();
		list.delLast1();
		list.insertLast1(99);
		list.delFirst();
		list.insert(100, 2);
		list.display();
		list.deleteAtIndex(1);
		list.display();
		list.BubbleSort();
		list.display();
//		System.out.println(list.getIndex(100));

		/*
		LL list = new LL();
		list.insertFirst(53);
		list.insertFirst(53);
		list.insertFirst(49);
		list.insertFirst(35);
		list.insertFirst(28);
		list.insertFirst(28);
//		list.display();
		list.insertFirst(23);
		list.insertFirst(23);
//		list.insertLast(79);
//		list.display();
//		list.insertAtIndex(6,100);
		list.display();
		list.removeAllDuplicates();
		list.display();
//		list.delAtIndex(6);
//		list.display();
 * 
 */
	/*
		CLL list = new CLL();
		list.insert(10);
		list.insert(20);
		list.insert(40);
		list.insert(39);
		list.insertFirst(33);
		list.display();
		list.deleteVal(39);
		list.display();
		*/
		
		/*
		LL mm = new LL();
		mm.insertLast(10);
		mm.insertLast(20);
		mm.insertLast(30);
		mm.insertLast(39);
		
		LL mm1 = new LL();
		mm1.insertLast(1);
		mm1.insertLast(23);
		mm1.insertLast(49);
		mm1.insertLast(50);
		
		LL mm2 = LL.merge(mm, mm1);
		mm2.display();
		mm2.size;
		*/
	}
}
