package recursiveProgramming;

public class FibonacciNumber {
	public static void main(String[] args) {
		System.out.println(formula(50));
	}
	
	private static int nthFibonacciNumber(int n) {
		if(n<2) {
			return n;
		}
		return nthFibonacciNumber(n-1)+nthFibonacciNumber(n-2);
	}
	
	/**
	 * @param n
	 * @return
	 */
	private static long formula(int n) {
		double phi = (1 + Math.sqrt(5)) / 2;
        double psi = (1 - Math.sqrt(5)) / 2;
        return (long)((Math.pow(phi, n) - Math.pow(psi, n)) / Math.sqrt(5));
	}
}
