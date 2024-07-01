package backtracking;

public class MazeMyself {
	public static void main(String[] args) {
//		System.out.println(countMaze(3, 3));
//		pathMaze("",3,3);
		pathMazeObstacle("",3,3);
	}
	
	private static int countMaze(int row, int col) {
		if(row ==1 || col == 1) {
			return 1;
		}
		
		int left = countMaze(row-1,col);
		int right = countMaze(row,col-1);
		
		return left+right;
	}
	
	private static void pathMaze(String up, int row, int col) {
		if( row == 1 && col == 1) {
			System.out.println(up);
			return;
		}
		
		if(row>1) {
			pathMaze(up+"D",row-1,col);
		}
		if(col>1) {
			pathMaze(up+"R",row,col-1);
		}
	}
	
	private static void pathMazeDiagonal(String up, int row, int col) {
		if( row == 1 && col == 1) {
			System.out.println(up);
			return;
		}
		
		if(row>1) {
			pathMazeDiagonal(up+"D",row-1,col);
		}
		if(row >1 && col > 1) {
			pathMazeDiagonal(up+"I", row-1, col-1);
		}
		if(col>1) {
			pathMazeDiagonal(up+"R",row,col-1);
		}
	}
	
	private static void pathMazeObstacle(String up, int row, int col) {
		if( row == 1 && col == 1) {
			System.out.println(up);
			return;
		}
		
		if(row>1) {
			if(!(row-1 == 2 && col ==2))
			{
				pathMazeObstacle(up+"D",row-1,col);
			}
		}
		if(col>1) {
			if(!(row == 2 && col-1 ==2)) {
				pathMazeObstacle(up+"R",row,col-1);
			}
			
		}
	}
}
