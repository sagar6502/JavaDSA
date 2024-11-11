package dynamicProgramming2;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
public class CoinChange {

	public static void main(String[] args) {
		int[] coins = { 186, 419, 83, 408 };
		int amount = 6249;

		int minCount1 = coinChange1(coins, amount);
		System.out.println("Greedy approach :: " + minCount1);

		int minCount2 = coinChange2(coins, amount);
		System.out.println("DP - chatGPT:: " + minCount2);

		int minCount3 = coinChange3(coins, amount);
		System.out.println("DP  - AV :: " + minCount3);
	}

	private static int coinChange2(int[] coins, int amount) {
		// TODO Auto-generated method stub
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max); // Initialize dp array with a large value representing infinity
		dp[0] = 0; // Base case: zero coins are needed for amount zero

		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}

		// If dp[amount] is still max, it means the amount cannot be formed with given
		// coins
		return dp[amount] > amount ? -1 : dp[amount];
	}

	// greedyApproach :: does not works for large values
	public static int coinChange1(int[] coins, int amount) {
		int n = coins.length;
		if (n == 0) {
			return n;
		}
		Arrays.sort(coins);
		int[] minReq = new int[n];
		for (int i = 0; i < n; i++) {
			minReq[i] = amount / coins[i];
		}
		int j = n - 1;
		int minCount = 0;
		while (amount != 0 && j >= 0) {
//			System.out.println(coins[j]);
			int countN = amount / coins[j];
//			System.out.println("count:: "+countN);
			int takeAmount = countN * coins[j];
//			System.out.println("takeamount :: "+(n-j)+" : "+takeAmount);
			if (takeAmount <= amount && countN != 0) {
				minCount += countN;
				amount -= takeAmount;
			}
//			System.out.println(amount);
			j--;
		}

//		System.out.println(minCount);
		return amount != 0 ? -1 : minCount;
	}

	private static int coinChange3(int[] coins, int amount) {
		// TODO Auto-generated method stub
		int n = coins.length;
		int[][] dp = new int[n + 1][amount + 1];

		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 0;
		}

		for (int i = 0; i < amount + 1; i++) {
			dp[0][i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 1; i < amount + 1; i++) {
			if (i % coins[0] == 0) {
				dp[1][i] = i / coins[0];
			}else {
				dp[1][i] = Integer.MAX_VALUE-1;
			}
		}
		
		for(int i=2; i<n+1; i++) {
			for(int j=1; j<amount+1; j++) {
				if(coins[i-1]>j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
				}
			}
		}
		return dp[n][amount];

	}

}
