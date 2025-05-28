package dynamicProgramming5;

import java.util.Arrays;

public class PalindromePartitioning2 {
	static int[][] dp = new int[1001][1001];

	public static void main(String[] args) {
		String s = "ababbbabbababa";
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(minCost1(s, 0, s.length() - 1));
	}

	private static boolean isPalindrome(String s, int i, int j) {
		// TODO Auto-generated method stub

		while (i <= j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	// memoization approach
	private static int minCost1(String arr, int i, int j) {
		if (i >= j) {
			return 0;
		}

		if (isPalindrome(arr, i, j)) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			int left = 0;
			int right = 0;
			if (dp[i][k] != -1) {
				left = dp[i][k];
			} else {
				left = minCost1(arr, i, k);
				dp[i][k] = left;
			}

			if (dp[k + 1][j] != -1) {
				right = dp[k + 1][j];
			} else {
				right = minCost1(arr, k + 1, j);
				dp[k + 1][j] = right;
			}
			int tempAns = left + right + 1;
			if (tempAns < min) {
				min = tempAns;
			}
		}

		dp[i][j] = min;
		return dp[i][j];
	}

}
