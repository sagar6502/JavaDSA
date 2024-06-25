package bitmanipulationInJava;

public class BaseConversion {
	public static void main(String[] args) {
		int val = 17;
		int n=2;
		int finVal = decimalToBinaryOctal(val, n);
		System.out.println(finVal);
		System.out.println(binaryToDecimal(finVal,10));
	}

	private static int decimalToBinaryOctal(int val, int n) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		while(val>0) {
			int k = val % n;
			sb.append(k);
			
			val /= n;
		}
		return Integer.parseInt(sb.reverse().toString());
	}
	
	private static int binaryToDecimal(int val, int k) {
		int p=0;
		int sum = 0;
		while(val>0) {
			sum = sum+(val%10)*(int)Math.pow(2, p);
			p++;
			val /= 10;
		}
		return sum;
	}
}
