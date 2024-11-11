package dynamicProgramming3;

public class MinNoOfDeletions {

	/*
	 * Given a string 'str' of size ‘n’. The task is to remove or delete the minimum
	 * number of characters from the string so that the resultant string is a
	 * palindrome. Find the minimum number of characters we need to remove.
	 */

	// https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

	public static void main(String[] args) {
		String m = "smadamsqaaaa1ada";
		int minDeletion = minDeletions(m,m.length());
		System.out.println(minDeletion);
	}

	static int minDeletions(String s, int n) {
		// code here
		String ns = new StringBuilder(s).reverse().toString();

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s.charAt(i - 1) == ns.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return n - dp[n][n];
	}
}
