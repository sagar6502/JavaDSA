package bigIntegerAndBigDecimal;

import java.math.BigInteger;

public class BigIntegerClass {
	
	// https://www.javatpoint.com/java-biginteger
	public static void main(String[] args) {
		int a = 30;
		int b = 67;
		
		BigInteger A = BigInteger.valueOf(231843987);
		BigInteger B = BigInteger.valueOf(1341095334);
		
		BigInteger C = BigInteger.ONE;
		
		int c = C.intValue();
		
		BigInteger D = new BigInteger("9183742939432987");
		
		int d = D.intValue();
		
		System.out.println(D.multiply(A));
		
		System.out.println(d);
		System.out.println(c);
		
		System.out.println(A);
		System.out.println(B);
		System.out.println(A.add(B));
		System.out.println(C);
		System.out.println(D.add(A));
		
		if(C.compareTo(A) < 0) { // C is smaller than A
			System.out.println("yes");
		}
		
	}
}
