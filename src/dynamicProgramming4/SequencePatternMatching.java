package dynamicProgramming4;

public class SequencePatternMatching {
	public static void main(String[] args) {
		String a = "axy";
		String b = "adxcpy";

		boolean isPatternMatches = LCS(b.toCharArray(), a.toCharArray(), b.length(), a.length());

		System.out.println(isPatternMatches);
	}

	private static boolean LCS(char[] x, char[] y, int n, int m) {
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

		return dp[n][m] == m;

	}

	// most optimal solution - 7-AI
	static boolean  isSubSequence(String a, String b) {
		int m = a.length();
		int n = b.length();

		int i = 0; // Pointer for `a`
		int j = 0; // Pointer for `b`

		// Traverse `b` with `j`, and try to match each character with `a[i]`
		while (i < m && j < n) {
			if (a.charAt(i) == b.charAt(j)) {
				i++; // Move pointer `i` in `a` if characters match
			}
			j++; // Always move pointer `j` in `b`
		}

		// If we have traversed all characters of `a`, it’s a subsequence
		return i == m;
	}
}
