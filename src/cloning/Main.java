package cloning;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		Human sagar = new Human(34, "Sagar");
//		Human twin = new Human(sagar);
		
		Human twin = (Human)sagar.clone();
		System.out.println(twin.age + " "+twin.name);
		System.out.println(Arrays.toString(twin.arr));
		
		twin.arr[0] = 100;
		
		System.out.println(Arrays.toString(twin.arr));
		System.out.println(Arrays.toString(sagar.arr));

	} 
}
