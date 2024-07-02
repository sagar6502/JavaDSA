package backtracking;

import java.util.Arrays;

public class BackTracking1 {
	public static void main(String[] args) {
		boolean[][] maze = {
				{true, true, true},
				{true, true, true},
				{true, true, true}
		};
		int[][] path = new int[maze.length][maze[0].length];
//		path("",maze,0,0);
		allPathPrint("",maze,0,0,path,1);
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
		//removing the changes done by that function: reverting
		maze[row][col] = true;
	}
	
	private static void allPathPrint(String up,boolean[][] maze,  int row, int col,int[][] path, int step) {
		if(row == maze.length-1 && col == maze[row].length-1) {
			//last step : 
			path[row][col] = step;
			for(int[] arr: path) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println(up);
			System.out.println();
			
			return;
		}
		
		
		if(!(maze[row][col])) return;
		
		// considering this block in my path
		maze[row][col]=false;
		
		//adding step
		path[row][col] = step;
		
		if(row<maze.length-1) {
			allPathPrint(up+'D',maze,row+1,col,path,step+1);
		}
		if(col<maze[row].length-1) {
			allPathPrint(up+'R',maze,row,col+1,path,step+1);
		}
		
		if(row>0) {
			allPathPrint(up+'U',maze,row-1,col,path,step+1);
		}
		
		if(col>0) {
			allPathPrint(up+'L',maze,row,col-1,path,step+1);
		}
		
		//the function with be over here
		//removing the changes done by that function: reverting
		maze[row][col] = true;
		path[row][col] = 0;
	}
}
