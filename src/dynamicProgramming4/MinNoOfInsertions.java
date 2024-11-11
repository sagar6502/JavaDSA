package dynamicProgramming4;

public class MinNoOfInsertions {

	public static void main(String[] args) {
		String m = "aba";
		int minInsertion = minInsertions(m, m.length());
		System.out.println(minInsertion);
	}

	static int minInsertions(String s, int n) {
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
