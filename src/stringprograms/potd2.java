package stringprograms;

import java.util.Arrays;

public class potd2 {
	
	// https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
	public String longestCommonPrefix(String arr[]) {
		// code here
		if (arr.length == 0) {
			return "-1";
		}
		if (arr.length == 1) {
			return arr[0];
		}
		Arrays.sort(arr);
		int finalIndex = -1;
		boolean pleaseBreak = false;
		char[] check = arr[0].toCharArray();

		for (int i = 0; i < check.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j].charAt(i) != check[i]) {
					finalIndex = i - 1;
					pleaseBreak = true;
					break;
				}
			}
			if (pleaseBreak) {
				break;
			}
		}
		// System.out.println(finalIndex);
		if (finalIndex == -1) {
			return "-1";
		} else {
			return arr[0].substring(0, finalIndex + 1);
		}

	}
}
