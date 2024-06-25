package recursionLevel1;

public class FactorialOfNumber {
	public static void main(String[] args) {
		int num = 10;
		System.out.println(findFactorial(num));
	}
	
	static long findFactorial(long n) {
		if(n<=1) return 1;
		return findFactorial(n-1)*n;
	}
}
