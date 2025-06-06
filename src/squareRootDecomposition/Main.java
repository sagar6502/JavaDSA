package squareRootDecomposition;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1,3,5,2,7,6,3,1,4,8};
		int n = arr.length;
		// build  a blocks array
		int sqrt = (int)Math.sqrt(n);

		int blocks_id = -1;
		
		int[] blocks = new int[(n + sqrt - 1) / sqrt];
//		System.out.println(blocks.length);
		for (int i = 0; i < n; i++) {
			
			// new block is starting
			if(i  % sqrt == 0) {
				blocks_id++;
			}
			
//			System.out.println(blocks_id);
			blocks[blocks_id] += arr[i];
		}
		
		System.out.println(Arrays.toString(blocks));
		
		System.out.println(query(blocks,arr,2,7,sqrt));
		
		System.out.println(query(blocks,arr,4,8,sqrt));
		
	}
	
	public static int query(int[] blocks, int[] arr, int l, int r, int sqrt) {
		int ans = 0;
		
		// left part
		while(l%sqrt != 0 && l < r && l != 0) {
			ans += arr[l];
			l++;
		}
		
		
		// middle part
		while(l+sqrt <= r) {
			ans += blocks[l/sqrt];
			l += sqrt;
		}
		
		// right part
		while(l <= r) {
			ans += arr[l];
			l++;
		}
		
		return ans;
	}
	
	public void update(int[] blocks, int[] arr, int i, int val, int sqrt) {
		int block_id = i/sqrt;
		blocks[block_id] += (val-arr[i]);
		arr[i] = val;
	}
}

