package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(3,3));
		System.out.println(path("",3,3));
		System.out.println(pathDiagonal("",3,3));
		System.out.println(count2(3,3));
		int[] obstacle = {2,3};
		boolean[][] maze = new boolean[4][4];
		pathRestrictions("",maze,0,0);
		
	}
	
	static int count(int r, int c) {
		if(r==1 || c==1) {
			return 1;
		}
		int right = count(r-1,c);
		int left = count(r,c-1);
		
		return right+left;
	}
	
	static int count2(int r, int c) {
		if(r==1 || c==1) {
			return 1;
		}
		int right = count2(r-1,c);
		int di = count2(r-1,c-1);
		int left = count2(r,c-1);
		
		return right+left+di;
	}
	
	static ArrayList<String> path(String p, int r, int c) {
		if( r==1 && c==1) {
			
//			System.out.println(p);
			return new ArrayList<String>(Arrays.asList(p));
		}
		ArrayList<String> ans1 = new ArrayList<String>();
		if(r>1) {
			ans1.addAll(path(p+'D',r-1,c));
		}
		if(c>1) {
			ans1.addAll(path(p+'R',r,c-1));
		}
//		path(p+'D',r-1,c);
//		path(p+'R',r,c-1);
		return ans1;
	}
	
	static ArrayList<String> pathDiagonal(String p, int r, int c) {
		if( r==1 && c==1) {
			return new ArrayList<String>(Arrays.asList(p));
		}
		ArrayList<String> ans1 = new ArrayList<String>();
		if(r>1) {
			ans1.addAll(pathDiagonal(p+'D',r-1,c));
		}
		if(r>1 && c>1) {
			ans1.addAll(pathDiagonal(p+'I',r-1,c-1));
		}
		if(c>1) {
			ans1.addAll(pathDiagonal(p+'R',r,c-1));
		}
//		path(p+'D',r-1,c);
//		path(p+'R',r,c-1);
		return ans1;
	}
	
	
	static ArrayList<String> pathObstacle(String p, int r, int c,int[] obstacle) {
		ArrayList<String> ans1 = new ArrayList<String>();
		
		if( r==1 && c==1) {
			return new ArrayList<String>(Arrays.asList(p));
		}
		
		if(r>1) {
			
			if(!((r-1) == obstacle[0] && c==obstacle[1])) {
				ans1.addAll(pathObstacle(p+'D',r-1,c,obstacle));
			}	
		}
		if(c>1) {
			if(!((c-1) == obstacle[1] && r==obstacle[0])) {
				ans1.addAll(pathObstacle(p+'R',r,c-1,obstacle));
			}
		}
//		path(p+'D',r-1,c);
//		path(p+'R',r,c-1);
		return ans1;
	}

	static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
		if( r== maze.length-1 && c==maze[0].length-1) {
			System.out.println(p);
			return ;
		}
		if(!maze[r][c]) {
			return;
		}
		if(r<maze.length-1) {
			pathRestrictions(p+'D',maze,r+1,c);
		}
		if(c<maze.length-1) {
			pathRestrictions(p+'R',maze,r,c+1);
		}
//		path(p+'D',r-1,c);
//		path(p+'R',r,c-1);
	}
}
