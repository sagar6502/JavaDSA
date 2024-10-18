package dynamicProgramming1;

import java.util.Arrays;

public class Fibonaaci {
	
	static int[] dp;
	public static void main(String[] args) {
		int n = 10;
		dp = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(findFibonacciSeries(n-1));
	}

	private static int findFibonacciSeries(int n) {
		// TODO Auto-generated method stub
		if(n == 1 || n == 0) {
			return 1;
		}
		if(dp[n] != -1) {
			return dp[n];
			
		}
		dp[n] = findFibonacciSeries(n-2)+findFibonacciSeries(n-1);
		
		return dp[n];
	}
	
}
