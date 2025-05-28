package backtracking;

public class SudokuSolver {
	public static void main(String[] args) {
		int[][] board = {{5,3,0, 0, 7,0, 0, 0, 0} ,
		                 {6,0, 0, 1,9,5,0, 0, 0} ,
		                 {0, 9,8,0, 0, 0, 0, 6,0} ,
		                 {8,0, 0, 0, 6,0, 0, 0, 3},
		                 {4,0, 0, 8,0, 3,0, 0, 1},
		                 {7,0, 0, 0, 2,0, 0, 0, 6},
		                 {0, 6,0, 0, 0, 0, 2,8,0} ,
		                 {0, 0, 0, 4,1,9,0, 0, 5},
		                 {0, 0, 0, 0, 8,0, 0, 7,9}};
		if(solve(board)) {
			display(board);
		}else {
			System.out.println(solve(board));
		}
		
	}
	
	static boolean solve(int[][] board) {
		int n = board.length;
		int row = -1;
		int col = -1;
		boolean emptyleft=true;
		
		//replacing the r,c from the arguments
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j]==0) {
					row=i;
					col=j;
					emptyleft=false;
					break;
				}
			}
			// if found some empty element in row, then break
			if(emptyleft == false) {
				break;
			}
		}
		
		if(emptyleft) {
			return true;
		}
		
		//back track
		for(int number=1;number<=9;number++) {
			if(isSafe(board, row, col, number)) {
				board[row][col] = number;
				if(solve(board)) {
					//found the answer
					return true;
				}else {
					//backtrack
					board[row][col] =0;
				}
			}
		}
		return false;
	}

	static void display(int[][] board) {
		for(int[] nums:board) {
			for(int num: nums) {
				System.out.print(num+ " ");
			}
			System.out.println();
		}
	}
	
	static boolean isSafe(int[][] board, int row, int col, int num) {
		// check the row
		for (int i = 0; i < board.length; i++) {
			// check if the number is in the row
			if (board[row][i] == num) {
				return false;
			}
		}

		// check the col
		for(int[] nums: board) {
			// check if the number is in the col
			if(nums[col]==num) {
				return false;
			}
		}
		
		int sqrt = (int)Math.sqrt(board.length);
		int rowstart = row-row%sqrt;
		int colStart = col-col%sqrt;
		for(int r=rowstart;r<rowstart+sqrt;r++) {
			for(int c=colStart; col< colStart+sqrt;col++) {
				if(board[r][c] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
