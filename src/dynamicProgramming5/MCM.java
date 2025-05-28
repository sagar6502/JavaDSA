package dynamicProgramming5;

import java.util.Arrays;

// Matrix Chain Multiplication

public class MCM {

	static int[][] dp = new int[1001][1001];

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 4 };
		int cost = minCost(arr, 1, arr.length - 1);

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int cost1 = minCost1(arr, 1, arr.length - 1);
		System.out.println("cost is :: (Recursive) " + cost);
		System.out.println("cost is :: (Memoization) " + cost1);

	}

	// recursive approach
	private static int minCost(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
//			System.out.println("Performing :: "+arr[i-1]+"*"+arr[k]+"*"+arr[j]);
			int tempAns = minCost(arr, i, k) + minCost(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
//			System.out.println("tempAns :: "+tempAns);
			if (tempAns < min) {
				min = tempAns;
			}
		}
		return min;
	}

	// memoization approach
	private static int minCost1(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			
			
			int tempAns = minCost(arr, i, k) + minCost(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			if (tempAns < min) {
				min = tempAns;
			}
		}
		
		dp[i][j] = min;
		return dp[i][j];
	}

}
