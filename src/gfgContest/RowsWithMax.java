package gfgContest;

public class RowsWithMax {
	public int rowWithMax1s(int arr[][]) {
		// code here
		if (arr.length == 0) {
			return 0;
		}
		int[] narr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length == 0) {
				narr[i] = 0;
			} else {
				narr[i] = countOnes(arr[i]);
			}
		}
		// System.out.println(Arrays.toString(narr));
		int max = -1;
		max = findMax(narr);
		// System.out.println("max index val :: "+arr[max][arr[max].length-1]);
		return arr[max][arr[max].length - 1] == 0 ? -1 : max;
	}

	private int countOnes(int[] arr) {
		if (arr[0] == 1) {
			return arr.length;
		}
		if (arr[arr.length - 1] == 0) {
			return 0;
		}
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == 0) {
				break;
			}
			count++;
		}
		return count;
	}

	private int findMax(int[] arr) {
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[max]) {
				max = i;
			}
		}
		return max;
	}

	public int rowWithMax1s_1(int arr[][]) {
		// code here
		if (arr.length == 0 || arr[0].length == 0) {
			return -1;
		}

		int R = arr.length;
		int C = arr[0].length;

		int maxRowIndex = -1;
		int j = C - 1;

		for (int i = 0; i < R; i++) {
			while (j >= 0 && arr[i][j] == 1) {
				j--;
				maxRowIndex = i;
			}
		}

		return maxRowIndex;
	}
}
