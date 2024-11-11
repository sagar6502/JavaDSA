package dynamicProgramming1;

public class EqualSumPartition {

	static int[][] dp1;

	public static void main(String[] args) {
		int[] arr = { 1, 5, 11, 6 };
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}

		int n = arr.length;
		dp1 = new int[n + 1][sum + 1];
		for (int i = 0; i < sum + 1; i++) {
			dp1[0][i] = -1;
		}

		for (int i = 0; i < n + 1; i++) {

			dp1[i][0] = 1;

		}

		if (sum % 2 != 0) {
			System.out.println("Not possible of equal sum partition");
		} else {
			System.out.println(vsumBT(arr, n, sum / 2) == 1);
		}

	}

	// bottom-up approach
	private static int vsumBT(int[] arr, int n, int tar) {

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < tar + 1; j++) {
				if (arr[i - 1] > j) {
					dp1[i][j] = dp1[i - 1][j];
				} else if (dp1[i - 1][j] == 1 || dp1[i - 1][j - arr[i - 1]] == 1) {
					dp1[i][j] = 1;
				}
			}
		}

		return dp1[n][tar];
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
