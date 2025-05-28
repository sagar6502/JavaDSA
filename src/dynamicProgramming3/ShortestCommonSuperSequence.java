package dynamicProgramming3;

import java.util.Arrays;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		// The shortest common supersequence of above string a and b is "Geeke" which
		// means both a and b are the substring of "Geeke".
		helper(a, b);
	}

	static int[][] dp;

	private static void helper(String x, String y) {
		char[] X = x.toCharArray();
		char[] Y = y.toCharArray();

		int n = x.length();
		int m = y.length();

		dp = new int[n + 1][m + 1];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int length1 = shortestCommonSupersequence(x, y, n, m);
		int length2 = shortestCommonSuperSequence(X, Y, n, m);
		System.out.println("the length of shortest supersequence :: (top-down) - " + (n + m - length2));
		System.out.println("the length of shortest supersequence :: (Alternative) - " + length1);
	}

	// tabulation - bottom-up
	private static int shortestCommonSuperSequence(char[] x, char[] y, int n, int m) {
		// TODO Auto-generated method stub

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < m + 1; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (x[i - 1] == y[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}

	public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
		// Your code here
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++)
			dp[i][0] = i;

		// Fill the first row (if s1 is empty,
		// all characters of s2 are needed)
		for (int j = 0; j <= n; j++)
			dp[0][j] = j;

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];

	}

}
