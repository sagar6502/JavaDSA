package bitmanipulationInJava;

public class FindithBit {
	public static void main(String[] args) {
		System.out.println(findBit(27, 4));
	}
	
	// find the ith bit of a number
	private static int findBit(int value, int n) {
		return value & (value<<(n-1));
	}
}
