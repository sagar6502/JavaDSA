package bigIntegerAndBigDecimal;

import java.math.BigInteger;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(fact(100));
	}
	static BigInteger fact(int num) {
		BigInteger ans = BigInteger.ONE;
		
		
		for(int i=2;i<=num;i++) {
			ans = ans.multiply(BigInteger.valueOf(i));
		}
		
		return ans;
	}
}
