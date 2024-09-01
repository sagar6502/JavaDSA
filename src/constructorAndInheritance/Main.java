package constructorAndInheritance;

public class Main {
	public static void main(String[] args) {
		Box box1 = new Box(4.6,7.2,8.5);
		Box box2 = new Box(box1);
		
		System.out.println(box1.w+" "+box1.h);	
		
		BoxWeight box3 = new BoxWeight();
		BoxWeight box4 = new BoxWeight(1, 4, 9, 7);
		System.out.println(box3.h+" "+box3.weight);
		
//		Box box5 =  new BoxWeight(2, 3, 4, 8);
//		System.out.println(box5);
//		
//		BoxWeight box6 = new BoxWeight(2,4,5,9);
//		System.out.println(box5);
		
		BoxPrice box = new BoxPrice(5,8,200);
		
	}
}
