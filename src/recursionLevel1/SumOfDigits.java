package recursionLevel1;

public class SumOfDigits {
	public static void main(String[] args) {
		int ans = sum(123409);
		System.out.println(ans);
	}
	
	private static int sum(int n) {
		if(n%10==n) return n;
		
		return sum(n/10)+(n%10);
	}
}
