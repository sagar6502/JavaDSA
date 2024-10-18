package dynamicProgramming1;

import java.util.Arrays;

public class KnapsackProblem {
	
	static int[][] dp;
	public static void main(String[] args) {
		
		int[] wt = new int[] {1,3,4,5};
		int[] val = new int[] {1,4,5,7};
		int w = 7;
		int n = wt.length;
		dp = new int[w+1][n+1];
		for(int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		int maxProfit = solveKnapSack(wt, val, w, n);
		
		System.out.println(maxProfit);
		
	}

	private static int solveKnapSack(int[] wt, int[] val, int w, int n) {
		// TODO Auto-generated method stub
		if(w == 0 || n == 0) {
			return 0;
		}
		
		if(dp[w][n] != -1) {
			return dp[w][n];
		}
		
		if(wt[n-1]>w) {
			dp[w][n] = solveKnapSack(wt, val, w, n-1);
			return dp[w][n];
		}
		
		int includeWt = val[n-1]+solveKnapSack(wt, val, w-wt[n-1], n-1);
		int excludeWt = solveKnapSack(wt, val, w, n-1);
		
		dp[w][n] =  Math.max(includeWt, excludeWt);
		return dp[w][n];
	}
}
