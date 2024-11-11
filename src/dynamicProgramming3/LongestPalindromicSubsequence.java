package dynamicProgramming3;

public class LongestPalindromicSubsequence {

	// https://leetcode.com/problems/longest-palindromic-subsequence/
	public static void main(String[] args) {
		String s = "bbbab";
		int n = s.length();
		int length = longestPalindromeSubseq(s,n);
		System.out.println(length);
	}

	public static int longestPalindromeSubseq(String s, int n) {
		String ns = new StringBuilder(s).reverse().toString();
		
		int[][] dp = new int[n+1][n+1];
		

		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(s.charAt(i-1) == ns.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		return dp[n][n];
	}
}
