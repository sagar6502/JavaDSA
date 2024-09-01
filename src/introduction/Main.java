package introduction;

import stringprograms.SingleTonClass;

public class Main {
	public static void main(String[] args) {
		int[] numbers = new int[5];
		
		String[] names = new String[5];
		
		int[] rno = new int[5];
		String[] name = new String[5];
		
		float[] marks = new float[5];
		
		Student students = new Student(1,"Sagar",3.4f);
//		Student students1 = new Student(10);
		Student students2 = new Student();
		
		System.out.println(students.rno);
		SingleTonClass obj1 = SingleTonClass.getInstance();
		SingleTonClass obj2 = SingleTonClass.getInstance();
	}
	
	
}
//creating a class
	class Student{
		int rno;
		String name;
		float marks;
		
		Student(int marks){
			this.marks = marks;
			System.out.println(marks);
		}
		
		Student(int rno, String name, float marks){
			this.rno = rno;
			this.name = name;
			this.marks = marks;
		}
		
		Student(){
			this(20);
		}
		
		@Override
		protected void finalize() throws Throwable{
			System.out.println("Objects are destroyed");
		}
	}