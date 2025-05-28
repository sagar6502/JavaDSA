package dynamicProgramming3;

import java.util.Arrays;

public class PrintLongestCommonSubSequence {

	static int[][] dp;

	public static void main(String[] args) {
		String x = "abcdaf";
		String y = "acbcf";
		char[] X = x.toCharArray();
		char[] Y = y.toCharArray();

		int n = x.length();
		int m = y.length();

		dp = new int[n + 1][m + 1];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		int length1 = shortestCommonSuperSequence(X, Y, n, m);
		System.out.println(
				"the length of shortest supersequence of string X and Y :: (top-down) - "
						+ length1);

	}

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

//		for (int[] a : dp) {
//			System.out.println(Arrays.toString(a));
//		}

		int i = n;
		int j = m;
		StringBuilder sb = new StringBuilder();
		while (i > 0 && j > 0) {
			if (x[i - 1] == y[j - 1]) {
				sb.append(x[i - 1]);
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					sb.append(x[i - 1]);
					i--;
				} else {
					sb.append(y[j - 1]);
					j--;
				}
			}
		}

		while (i > 0) {
			sb.append(x[i - 1]);
			i--;
		}
		while (j > 0) {
			sb.append(y[j - 1]);
			j--;
		}

		System.out.println("longest subsequence is :: " + sb.reverse().toString());

		return m+n-dp[n][m];
	}

}
