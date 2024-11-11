package dynamicProgramming1;

import java.util.Arrays;

public class MinSubsetSumDiff {
	static boolean[] dp;
	static int minSubSet = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 7 };
		int n = arr.length;
		int maxR = sumOfArray(arr);
		int sum = maxR/2;
		dp = new boolean[sum + 1];

		dp[0] = true;
		isSubSetExists(arr, maxR / 2, n);
		System.out.println(Arrays.toString(dp));
		for(int i=0; i<=sum;i++) {
			if(dp[i]) {
				minSubSet = Math.min(minSubSet, maxR-2*i);
			}
		}
		System.out.println(minSubSet);
	}

	private static void isSubSetExists(int[] arr, int sum, int n) {
		// TODO Auto-generated method stub

		for (int num : arr) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
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
