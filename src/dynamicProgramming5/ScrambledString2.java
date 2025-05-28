package dynamicProgramming5;

import java.util.HashMap;
import java.util.Map;

// memoized

public class ScrambledString2 {

	static Map<String, Boolean> map;

	public static void main(String[] args) {
		String s1 = "coder";
		String s2 = "ocder";
		System.out.println(isScramble(s1, s2));
	}

	public static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		if (s1.isBlank() && s2.isBlank()) {
			return true;
		}

		map = new HashMap<>();
		return solve(s1, s2);
	}

	private static boolean solve(String s1, String s2) {
		// TODO Auto-generated method stub

		if (s1.compareTo(s2) == 0) {
			return true;
		}

		if (s1.length() <= 1) {
			return false;
		}

		String key = s1 + "," + s2;

		if (map.containsKey(key)) {
			return map.get(key);
		}

		// Pruning: If the sorted characters don’t match, return false early
		if (!hasSameCharacterCounts(s1, s2)) {
			map.put(key, false);
			return false;
		}

		int n = s1.length();

		boolean flag = false;

		for (int i = 1; i <= n - 1; i++) {

			// Check without swapping
            boolean cond1 = solve(s1.substring(0, i), s2.substring(0, i)) &&
                            solve(s1.substring(i), s2.substring(i));
            
            // Check with swapping
            boolean cond2 = solve(s1.substring(0, i), s2.substring(n - i)) &&
                            solve(s1.substring(i), s2.substring(0, n - i));
            
            if (cond1 || cond2) {
                flag = true;
                break;
            }
		}
		map.put(key, flag);
		return flag;
	}

	private static boolean hasSameCharacterCounts(String s1, String s2) {
		int[] count = new int[26];
		for (char c : s1.toCharArray()) {
			count[c - 'a']++;
		}
		for (char c : s2.toCharArray()) {
			count[c - 'a']--;
		}
		for (int c : count) {
			if (c != 0) {
				return false;
			}
		}
		return true;
	}

}
