package dynamicProgramming3;

public class LongestRepeatingSubsequence {
	public static void main(String[] args) {
		String s = "AABEBCDD";

		int length = longestRepeatingSubsequence(s);
		System.out.println(length);
	}

	public static int longestRepeatingSubsequence(String x) {
		// code here
		int n = x.length();
		int m = x.length();
		String y = new String(x);
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (x.charAt(i-1) == y.charAt(j-1) && i-1 != j-1) {
						dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		
		return dp[n][m];
	}
}
