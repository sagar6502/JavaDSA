package cloning;

public class Human implements Cloneable {
	
	int age;
	String name;
	int[] arr;
	
	public Human(int age, String name) {
		this.age = age;
		this.name = name;
		this.arr = new int[]{2,5,2,5,1,8};
	}
	
//	public Human(Human other) {
//		this.age = other.age;
//		this.name = other.name;
//	}
	
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		// this is shallow copying
//		return super.clone();
//	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// this is deep copying
		Human twin = (Human)super.clone(); //shallow copy
		
		twin.arr = new int[twin.arr.length];
		for(int i=0; i< twin.arr.length; i++) {
			twin.arr[i] = this.arr[i];
		}
		return twin;
	}
}
