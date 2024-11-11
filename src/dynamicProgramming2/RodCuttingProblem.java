package dynamicProgramming2;

public class RodCuttingProblem {

	static int[][] dp;

	public static void main(String[] args) {
		int[] length = { 1, 2, 3, 4 };
		int[] price = { 5, 6, 8, 8 };
		int n = 4;
		int w = length.length;
		dp = new int[w + 1][n + 1];

		// Initialize the first column (dp[i][0] for all i) and the first row (dp[0][j]
		// for all j)
		for (int i = 0; i <= w; i++) {
			dp[i][0] = 0; // Initialize first column
		}

		for (int j = 0; j <= n; j++) {
			dp[0][j] = 0; // Initialize first row
		}
		int cost = solveUnboundedKnapsack(length, price, n, w);
		
		System.out.println(cost);
	}

	private static int solveUnboundedKnapsack(int[] length, int[] price, int n, int w) {
		// TODO Auto-generated method stub
		
		for(int i=1; i<w+1; i++) {
			for(int j=1;j<n+1; j++) {
				if(length[i-1]>j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], price[i-1]+dp[i][j-length[i-1]]);
				}
			}
		}
		
		return dp[w][n];
		
	}

}
