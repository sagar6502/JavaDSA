package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PoTD {
	public static void main(String[] args) {

	}

	// https://geeksforgeeks.org/problems/rat-in-a-maze-problem/1

	ArrayList<String> path = new ArrayList<>();

	public ArrayList<String> findPath(int[][] mat) {
		// Your code here
		int col = mat[0].length - 1;
		if (mat[col][col] == 0) {
			return new ArrayList<>(Arrays.asList("-1"));
		}
		findPath(mat, "", 0, 0);

		return path;
	}

	private void findPath(int[][] mat, String onePath, int r, int c) {
		if (r == mat.length - 1 && c == mat[r].length - 1) {
			path.add(onePath);
			return;
		}

		if (mat[r][c] == 0)
			return;

		mat[r][c] = 0;

		if (r < mat.length - 1) {
			findPath(mat, onePath + "D", r + 1, c);
		}
		if (c < mat[r].length - 1) {
			findPath(mat, onePath + "R", r, c + 1);
		}

		if (r > 0) {
			findPath(mat, onePath + "U", r - 1, c);
		}

		if (c > 0) {
			findPath(mat, onePath + "L", r, c - 1);
		}

		mat[r][c] = 1;
	}
}
