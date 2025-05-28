package dynamicProgramming1;

import java.util.Arrays;

public class CountOfSubSet {

	static int[][] dp;
	static int[][] dp1;

	public static void main(String[] args) {
		int[] arr = {2,3,5,6,8,10 };
		int sum = 10;
		int n = arr.length;
		dp = new int[n + 1][sum + 1];
		dp1 = new int[n + 1][sum + 1];
		for (int i = 0; i < sum + 1; i++) {
			dp1[0][i] = 0;
		}

		for (int i = 0; i < n + 1; i++) {

			dp1[i][0] = 1;

		}

		System.out.println(vsumBT(arr, n, sum) == 1);
		for(int[] a:dp1) {
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println(dp1[n][sum]);
//		int count = 0;
//		for(int i=0;i<n+1;i++) {
//			if(dp1[i][sum] == 1) {
//				count++;
//			}
//		}
		
//		System.out.println(count);
	}

	// bottom-up approach
	private static int vsumBT(int[] arr, int n, int tar) {

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < tar + 1; j++) {
				if (arr[i - 1] > j) {
					dp1[i][j] = dp1[i - 1][j];
				} else {
					dp1[i][j] = dp1[i - 1][j] + dp1[i - 1][j - arr[i - 1]];
				}
			}
		}

		return dp1[n][tar];
	}

	// top-bottom approach

	/**
	 * @param arr
	 * @param n
	 * @param tar
	 * @return
	 */
	private static int vsumTB(int[] arr, int n, int tar) {

		if (tar == 0) {
			return 1;
		}
		if (n == 0) {
			return -1;
		}

		if (dp[n][tar] != 0) {
			return dp[n][tar];
		}

		if (arr[n - 1] > tar) {
			dp[n][tar] = vsumTB(arr, n - 1, tar);
			return dp[n][tar];
		}

		if (vsumTB(arr, n - 1, tar) == 1 || vsumTB(arr, n - 1, tar - arr[n - 1]) == 1) {
			dp[n][tar] = 1;
		}

		return dp[n][tar];
	}

	// recursion
	private static boolean vsum(int[] arr, int n, int tar) {

		if (tar == 0) {
			return true;
		}

		if (n == 0) {
			return false;
		}

		if (arr[n - 1] > tar) {
			return vsum(arr, n - 1, tar);
		}

		return vsum(arr, n - 1, tar) || vsum(arr, n - 1, tar - arr[n - 1]);

	}

	// space extra optimized

	static Boolean isSubsetSum(int arr[], int sum) {
		// code here
		int n = arr.length;

		// Initialize a 1D dp array
		boolean[] dp = new boolean[sum + 1];

		// Base case: sum 0 is always achievable with an empty subset
		dp[0] = true;

		// Iterate through the elements of the array
		for (int i = 0; i < n; i++) {
			// Traverse the dp array from right to left (backward)
			// This ensures we don't overwrite values in dp that we still need for the
			// current element
			for (int j = sum; j >= arr[i]; j--) {
				// Update the dp array by checking if the current sum can be achieved
				// either by including or excluding the current element
				dp[j] = dp[j] || dp[j - arr[i]];
			}
		}
		return dp[sum];
	}

}
