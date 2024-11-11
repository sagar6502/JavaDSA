package dynamicProgramming1;

public class CountTheNumberOfSubSetWithGivenDifference {
	static int[][] dp;

	public static void main(String[] args) {
		int[] arr = { 1,1,2,3 };
		int sum = sumOfArray(arr);
		int n = arr.length;
		int diff = 1;
		// Check for invalid difference case
        if ((sum + diff) % 2 != 0) {
            System.out.println("No subsets with the given difference.");
            return;
        }
		int reqSum = (sum+diff)/2;
		dp = new int[n + 1][reqSum+1];

		for (int i = 0; i < n + 1; i++) {

			dp[i][0] = 1;

		}
		vsumBT(arr, n, reqSum);

		System.out.println(dp[n][reqSum]);
	}

	// bottom-up approach
	private static int vsumBT(int[] arr, int n, int tar) {

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < tar + 1; j++) {
				if (arr[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
				}
			}
		}

		return dp[n][tar];
	}

	private static int sumOfArray(int[] arr) {
		// TODO Auto-generated method stub

		int sum = 0;
		for (int i : arr) {
			sum = sum + i;
		}
		return sum;
	}

}
