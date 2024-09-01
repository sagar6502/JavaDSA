package recursionLevel1;

public class SumOfN {
	public static void main(String[] args) {
		int ans = sum(4);
		System.out.println(ans);
	}
	
	private static int sum(int n) {
		if(n<=1) {
			return 1;
		}
		return sum(n-1)+n;
	}
}
