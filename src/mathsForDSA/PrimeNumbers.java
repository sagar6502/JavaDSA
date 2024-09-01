package mathsForDSA;

public class PrimeNumbers {
	public static void main(String[] args) {
		int num = 40;
		for(int i=1;i<num;i++) {
			if(isPrime(i))
			System.out.print(i+" ");
		}
		
	}
	
	private static boolean isPrime(int n) {
		if(n <=1) {
			return false;
		}
		int c=2;
		while(c*c <= n) {
			if(n%c==0) return false;
			c++;
		}
		return true;
	}
}
