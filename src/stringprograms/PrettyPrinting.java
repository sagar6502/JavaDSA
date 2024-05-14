package stringprograms;

import java.util.ArrayList;

public class PrettyPrinting {
	
	public static void main(String[] args) {
		float f = 2.14143f;
		//printf rounds off as well.
		System.out.printf("Formmatted text is %.2f",f);
		
		System.out.println();
		System.out.printf("Pie : %.3f",Math.PI);
		
		// % is a placeholder where it will be get value according to indexes
		System.out.printf("hello my name is %s and I am %s","Sagar","Engineer");
		//hello my name is Sagar and I am Engineer
		String s = "Sagar";
		System.out.println("a"+1);
		System.out.println("Sagar"+new ArrayList<>());
		
		System.out.println('a'-'b');
		
	}
}
