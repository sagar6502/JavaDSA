package dynamicProgramming1;

public class TargetSum {

//	https://leetcode.com/problems/target-sum/description/
	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 1, 1 };
		int target = 3;
		int ways = findTargetSumWays(arr, target);
		System.out.println(ways);
	}

	static int[][] dp;

	public static int findTargetSumWays(int[] nums, int target) {
		int n = nums.length;

		int sum = sumOfAr(nums);
		if ((sum + target) % 2 != 0 || target > sum || target < -sum) {
			return 0;
		}

		int newTar = (sum + target) / 2;
		dp = new int[n + 1][newTar + 1];
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 1;
		}

		// Count the number of zeroes in the array
		int numZeros = 0;
		for (int num : nums) {
			if (num == 0) {
				numZeros++;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < newTar + 1; j++) {
				if (nums[i - 1] > j || nums[i - 1] == 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
				}
			}
		}

		return dp[n][newTar] * (1 << numZeros);
	}

	private static int sumOfAr(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}
}
