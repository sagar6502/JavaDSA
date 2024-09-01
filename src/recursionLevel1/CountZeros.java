package recursionLevel1;

public class CountZeros {
	public static void main(String[] args) {
		int num = 12320234;
		System.out.println(countZero2(num));
		System.out.println(count(num));
	}
	static int c=0;
	static int countZero(int n) {
		if(n<10 && n==0) {
			return c+1;
		}
//		System.out.println(n);
		if(n%10==0) {
			c = c+1;
		}
		countZero(n/10);
		return c;
	}
	
	static int countZero2(int n) {
		if(n==0) {
			return 0;
		}
//		System.out.println(n);
		if(n%10==0) {
			return 1+countZero2(n/10);
		}
		return countZero(n/10);
	}
	
	static int count(int n) {
		return helper(n,0);
	}
	
	static int helper(int n, int c) {
		if(n==0) return c;
		if(n%10==0) c++;
		return helper(n/10,c);
	}
}
