package gfgContest;

import java.util.Arrays;
import java.util.HashSet;

public class Dictionary {
	public static void main(String[] args) {

	}

	public static String firstWord(int n, String[] dictionary) {
		// code here
		HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));

		// Check for duplicates
		if (set.size() != dictionary.length) {
			return "Invalid";
		}

		// Sort the array to get the first word in lexicographical order
		Arrays.sort(dictionary);
		return dictionary[0];
	}
}
