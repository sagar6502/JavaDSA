package mathsForDSA;

public class NewtonSQRT {
	public static void main(String[] args) {
		int n=20;
		System.out.println(sqrt(n));
	}
	
	static double sqrt(double n) {
		if(n<0) {
			throw new IllegalArgumentException("Enter positive number");
		}
		double x=n;
		double root;
		while(true) {
			root = 0.5 * (x+(n/x));
			if(Math.abs(root-x)<1) {
				break;
			}
			x=root;
		}
		return root;
	}
}
