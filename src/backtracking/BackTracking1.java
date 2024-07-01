package backtracking;

public class BackTracking1 {
	public static void main(String[] args) {
		boolean[][] maze = {
				{true, true, true},
				{true, true, true},
				{true, true, true}
		};
		path("",maze,0,0);
	}
	
	private static void path(String up,boolean[][] maze,  int row, int col) {
		if(row == maze.length-1 && col == maze[row].length-1) {
			System.out.println(up);
			return;
		}
		
		
		if(!(maze[row][col])) return;
		
		// considering this block in my path
		maze[row][col]=false;
		
		if(row<maze.length-1) {
			path(up+'D',maze,row+1,col);
		}
		if(col<maze[row].length-1) {
			path(up+'R',maze,row,col+1);
		}
		
		if(row>0) {
			path(up+'U',maze,row-1,col);
		}
		
		if(col>0) {
			path(up+'L',maze,row,col-1);
		}
		
		//the function with be over here
		//removing the changes done by that function
		maze[row][col] = true;
	}
}
