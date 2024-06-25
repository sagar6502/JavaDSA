package bitmanipulationInJava;

public class NoOfDigits {
	public static void main(String[] args) {
		int number = 10;
		int b=2;
		System.out.println(returnDigit(number, b));
	}
	
	private static int returnDigit(int n, int b) {
		if(n==0) {
			return 1;
		}
		
		return (int)(Math.log(n) / Math.log(b))+1;
	}
}
