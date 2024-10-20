package dynamicProgramming1;

import java.util.Arrays;

public class Fibonaaci2 {

	static int[] dp;

	public static void main(String[] args) {
		int n = 10;
		dp = new int[n];

		System.out.println(findFibonacciSeries(n - 1));
	}

	// bottom up approach
	private static int findFibonacciSeries(int n) {
		// TODO Auto-generated method stub

		for (int i = 0; i < n + 1; i++) {
			if (i <= 1) {
				dp[i] = 1;
			} else {
				dp[i] = dp[i - 2] + dp[i - 1];
			}

		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}

	// most-efficent approach
	private static int findFibonacciSeries1(int n) {
		if (n <= 1)
			return 1;

		int prev2 = 1; // Fibonacci(0)
		int prev1 = 1; // Fibonacci(1)
		int current = 0;

		for (int i = 2; i <= n; i++) {
			current = prev1 + prev2;
			prev2 = prev1;
			prev1 = current;
		}
		return current;
	}
}
