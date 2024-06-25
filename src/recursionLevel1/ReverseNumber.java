package recursionLevel1;

public class ReverseNumber {
	
	static int sum = 0;
	
	public static void main(String[] args) {
		int a = 543021;
		int b = 123456;
		int c = 716273;
		int d = 1234321;
		reverse(a);
		System.out.println("reverse of "+a+" : "+sum);
		int ans = reverse2(b,helper(b));
		System.out.println("reverse of "+b+" : "+ans);
		System.out.println("reverse of "+c+" : "+reverse3(c));
		System.out.println(palin(d));
	}
	
	private static void reverse(int n) {
		if(n == 0) {
			return;
		}
		int rem=n%10;
		int remainingDigits = n/10;
		sum=sum*10+rem;
		reverse(remainingDigits);
	}
	
	private static int reverse2(int n, int base) {
		if(n <= 10) {
			return n;
		}
		int rem=n%10;
		return rem*(int)Math.pow(10,base)+reverse2(n/10,--base);
	}
	
	private static int reverse3(int n) {
		if(n <= 10) {
			return n;
		}
		int rem=n%10;
		return rem*(int)Math.pow(10,(int)Math.log10(n))+reverse3(n/10);
	}
	
	private static int helper(int n) {
		int digit = (int)Math.log10(n);
		return digit;
	}
	
	static boolean palin(int n) {
		return n==reverse3(n);
	}
}
