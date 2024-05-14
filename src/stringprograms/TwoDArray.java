package stringprograms;

public class TwoDArray {
	public static void main(String[] args) {
		int[][] narr = {
				{1,3,6},
				{2,4,7},
				{8,5,9}
		};
		for(int row=0; row<narr.length;row++) {
			for(int col=0;col<narr[row].length;col++) {
				System.out.print(narr[row][col]+" ");
			}
			System.out.println();
		}
	}
}
