package bitmanipulationInJava;

public class CountNoOfSetBits {
	public static void main(String[] args) {
		int n= 11;
		System.out.println(Integer.toBinaryString(n));
		int c = 0;
		while(n> 0) {
			c++;
			n = (n&(n-1));
		}
		System.out.println(c);
	}
}
