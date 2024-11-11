package dynamicProgramming3;

import java.util.Arrays;

// LCS - Longest Common SubSequence
// do not know why memoization and recursion does not work in this case.
public class LongestCommonSubString {

	static int[][] dp;

	public static void main(String[] args) {
		String x = "ABCDGH";
		String y = "ACDGHR";
		char[] X = x.toCharArray();
		char[] Y = y.toCharArray();

		int n = x.length();
		int m = y.length();

		dp = new int[n + 1][m + 1];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		int length2 = maxSubsequenceSubstring2(X, Y, n, m);
		System.out.println(
				"the length of the longest subsequence of string X which is a substring in sequence Y :: (tabulation) - "
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
		int maxLength = 0;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(x[i-1] == y[j-1]) {
					dp[i][j] = 1+dp[i-1][j-1];
					maxLength = Math.max(maxLength, dp[i][j]); 
				}else {
					dp[i][j] = 0;
				}
			}
		}
		return maxLength;
	}


}
