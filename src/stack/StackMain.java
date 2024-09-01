package stack;

public class StackMain {
	public static void main(String[] args) throws Exception {
		CustomedStack st = new DynamicStack(5);
		
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(99);
		st.push(22);
		st.push(11);
		st.push(12);
//		st.pop();
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.peek());
	}
}
