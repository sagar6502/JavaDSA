package recursionLevel1;

public class ProductOfDigits {
	public static void main(String[] args) {
		int ans = prod(12345);
		System.out.println(ans);
	}
	
	private static int prod(int n) {
		if(n%10==n) return n;
		
		return prod(n/10)*(n%10);
	}
}
