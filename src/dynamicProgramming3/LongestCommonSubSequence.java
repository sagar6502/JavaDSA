package dynamicProgramming3;

import java.util.Arrays;

// LCS - Longest Common SubSequence

public class LongestCommonSubSequence {

	static int[][] dp;

	public static void main(String[] args) {
		String x = "ABCDGF";
		String y = "WABCDGS";
		char[] X = x.toCharArray();
		char[] Y = y.toCharArray();

		int n = x.length();
		int m = y.length();

		dp = new int[n + 1][m + 1];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		int length = maxSubsequenceSubstring(X, Y, n, m);
		int length1 = maxSubsequenceSubstring1(X, Y, n, m);
		int length2 = maxSubsequenceSubstring2(X, Y, n, m);
		System.out.println(
				"the length of the longest subsequence of string X which is a substring in sequence Y :: (recursion) - "
						+ length);
		System.out.println(
				"the length of the longest subsequence of string X which is a substring in sequence Y :: (top-down) - "
						+ length1);
		System.out.println(
				"the length of the longest subsequence of string X which is a substring in sequence Y :: (top-down) - "
						+ length2);
	}

	// tabulation - bottom-up
	private static int maxSubsequenceSubstring2(char[] x, char[] y, int n, int m) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n+1][m+1];
		for(int i=0; i<n+1; i++) {
			dp[i][0] = 0;
		}
		for(int i=0; i<m+1; i++) {
			dp[0][i] = 0;
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(x[i-1] == y[j-1]) {
					dp[i][j] = 1+dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][m];
	}

	// Memoization
	private static int maxSubsequenceSubstring1(char[] x, char[] y, int n, int m) {
		// TODO Auto-generated method stub
		if (m == 0 || n == 0) {
			return 0;
		}

		if (dp[n][m] != -1) {
			return dp[n][m];
		}

		if (x[n - 1] == y[m - 1]) {
			dp[n][m] = 1 + maxSubsequenceSubstring(x, y, n - 1, m - 1);
			return dp[n][m];
		} else {
			dp[n][m] = Math.max(maxSubsequenceSubstring(x, y, n, m - 1), maxSubsequenceSubstring(x, y, n - 1, m));
			return dp[n][m];
		}

	}

	// Recursion
	static int maxSubsequenceSubstring(char[] x, char[] y, int n, int m) {

		if (m == 0 || n == 0) {
			return 0;
		}

		if (x[n - 1] == y[m - 1]) {
			return 1 + maxSubsequenceSubstring(x, y, n - 1, m - 1);
		} else {
			return Math.max(maxSubsequenceSubstring(x, y, n, m - 1), maxSubsequenceSubstring(x, y, n - 1, m));
		}

	}

}
