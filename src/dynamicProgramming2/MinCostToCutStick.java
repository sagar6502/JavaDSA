package dynamicProgramming2;

import java.util.Arrays;

//un-solved -- https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
public class MinCostToCutStick {
	
	static int[][] dp;
	public static void main(String[] args) {
		int[] cuts = {1,3,4,5};
		int n = 7;
		
		minCost(n, cuts);
	}

	public static int minCost(int n, int[] cuts) {
		int l = cuts.length;
		dp = new int[l+1][n+1];
		
		for(int i=0; i<l+1; i++) {
			dp[i][0] = 0;
		}
		
		for(int j=0; j<n+1; j++) {
			dp[0][j] = j*(j+1)/2;
		}
		
		for(int[] a:dp) {
			System.out.println(Arrays.toString(a));
		}
		
		int cost = solveProblem(cuts,n,l);
		System.out.println(cost);
		return cost;
	}

	private static int solveProblem(int[] cuts, int n, int l) {
		// TODO Auto-generated method stub
		
		for(int i=1; i<l+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(cuts[i-1]>j) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(cuts[i-1]+dp[i-1][j-cuts[i-1]], dp[i-1][j]);
				}
			}
		}
		return dp[l][n];
	}
}
