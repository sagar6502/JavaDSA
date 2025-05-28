package dynamicProgramming3;

public class PaintersPartitionProblem {
	
	public static void main(String[] args) {
		int m = 2;
		int[] arr = {10, 20, 30, 40};
		int n = arr.length;
		
		int minT = solveProblem(m,arr,n);
		System.out.println(minT);
	}

	private static int solveProblem(int m, int[] arr, int n) {
		// TODO Auto-generated method stub
		int max = sum(arr);
		int min = max(arr,n);
		int ans = Integer.MAX_VALUE;
		while(min <= max) {
			int mid = min+(max-min)/2;
//			System.out.println(mid);
			if(isPossible(mid,m,arr)) {
				System.out.println(mid);
				ans = Math.min(ans, mid);
				max = mid-1;
			}else {
				min = mid+1;
			}
		}
		
		return ans;
	}

	private static boolean isPossible(int limit, int m, int[] arr) {
		// TODO Auto-generated method stub
		int painters = 1;
		int currentLoad = 0;

		for (int board : arr) {
			if (currentLoad + board	 > limit) {
				// Assign the next painter
				painters++;
				currentLoad = board;

				if (painters > m) {
					return false;
				}
			} else {
				currentLoad += board;
			}
		}
		
		return true;
	}

	private static int max(int[] arr, int n) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = Math.max(max, i);
		}
		return max;
	}

	private static int sum(int[] arr) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i:arr) {
			sum += i;
		}
		return sum;
	}
}
