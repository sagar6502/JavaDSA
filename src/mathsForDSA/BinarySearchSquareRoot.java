package mathsForDSA;

public class BinarySearchSquareRoot {
	public static void main(String[] args) {
		int n=36;
		int p=3;
		System.out.println(Math.sqrt(n));
		System.out.printf("%.3f",sqrt(n, p));
	}
	
	private static double sqrt(int n, int p) {
		int s=0;
		int e=n;
		double root = 0.0;
		while(s <= e) {
			int m=e+(e-s)/2;
			
			if(m*m == n) {
				root=m;
				return root;
			}
			else if(m*m>n) {
				e = m-1;
			}
			else {
				s = m+1;
			}
		}
		double inc = 0.1;
		for(int i=0; i< p;i++) {
			while(root * root<n) {
				root += inc;
			}
			root -= inc;
			inc /= 10;
		}
		return root;
	}
}
