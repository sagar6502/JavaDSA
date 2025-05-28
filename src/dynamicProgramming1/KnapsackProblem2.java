package dynamicProgramming1;

import java.util.Arrays;

public class KnapsackProblem2 {
	
	static int[][] dp;
	public static void main(String[] args) {
		
		int[] wt = new int[] {1,3,4,5};
		int[] val = new int[] {1,4,5,7};
		int w = 7;
		int n = wt.length;
		dp = new int[n+1][w+1];
		
		// Initialize the first column (dp[i][0] for all i) and the first row (dp[0][j] for all j)
		for (int i = 0; i <= n; i++) {
		    dp[i][0] = 0;  // Initialize first column
		}

		for (int j = 0; j <= w; j++) {
		    dp[0][j] = 0;  // Initialize first row
		}
		int maxProfit = solveKnapSack(wt, val, w, n);
		
		System.out.println(maxProfit);
		
		for(int[] i:dp) {
			System.out.println(Arrays.toString(i));
		}
		
	}

	
	// bottom-top knapsack problem
	private static int solveKnapSack(int[] wt, int[] val, int w, int n) {
		// TODO Auto-generated method stub
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<w+1; j++) {
				
				if(wt[i-1]<=j){
					dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		
		
		return dp[n][w];
	}
}
