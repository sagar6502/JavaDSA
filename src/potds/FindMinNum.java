package potds;

import java.math.BigInteger;
import java.util.Arrays;

public class FindMinNum {
	public static void main(String[] args) {
		int[] arr = {5, 3, 0, 7, 4};
		System.out.println(minSum(arr));
	}

	static String minSum(int[] arr) {
		// code here
		int n = arr.length;

		if (n == 2) {
			return Integer.toString(arr[0] + arr[1]);
		}

		Arrays.sort(arr);
		// 2 3 4 5 6 8

		StringBuilder firstNum = new StringBuilder();
		StringBuilder secNum = new StringBuilder();

		int k = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				k++;
			}
		}
		// System.out.println(k);
		for (int i = k; i < n; i += 2) {
			firstNum.append(Integer.toString(arr[i]));
			if (i + 1 < n) {
				secNum.append(Integer.toString(arr[i + 1]));
			}

		}

//		System.out.println(firstNum.toString() + " :: " + secNum);

		return findSum(firstNum.toString(), secNum.toString());
	}

	static String findSum(String s1, String s2) {
		BigInteger a = new BigInteger(s1);
		BigInteger b = new BigInteger(s2);
		
		BigInteger c = a.add(b);
		return c.toString();
	}
}
