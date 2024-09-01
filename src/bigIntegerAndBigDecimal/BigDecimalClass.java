package bigIntegerAndBigDecimal;

import java.math.BigDecimal;

public class BigDecimalClass {
	public static void main(String[] args) {
		BD();
	}
	/*
	 * *consists of an arbitrary precision integer  unscaledValue() unscaled value
	 *  and a 32-bitinteger  scale() scale. If zero or positive,the scale is the number of digits
	 *   to the right of the decimalpoint. If negative, the unscaled value of the number is multiplied by ten to the power of the negation of the scale.
	 *  The value of thenumber represented by the BigDecimal is therefore (unscaledValue × 10-scale). 
	 */
	// range of bigDecimal : 
		
	//float and double  are floating point number
	// are the binary representation of a fraction and a exponent
	
	// i.e., why they give some error(10^-19)
	
	// But big decimal gives exact answer
	
	// https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html
	static void BD() {
		double x = 0.03;
		double y = 0.04;
		double ans = y-x;
		System.out.println(ans);
		
		BigDecimal X = new BigDecimal("0.03");
		BigDecimal Y = new BigDecimal("0.04");
		
		BigDecimal A = new BigDecimal("827365237.9134813");
		BigDecimal B = new BigDecimal("23784.923482");
		
		BigDecimal ans1 = Y.subtract(X);
		
		BigDecimal ans2 = A.add(B);
		
		System.out.println(A.multiply(B));
		
		System.out.println(ans2);
		
		System.out.println(ans1);
	}
}
