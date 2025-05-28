package dynamicProgramming5;

import java.util.HashMap;
import java.util.Map;

public class BooleanParenthesization {

	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		int n = 7;
		String s = "T|T&F^T";
		map.clear();

		System.out.println(countWays(n, s));
	}

	static int countWays(int n, String s) {
		System.out.println(solve1(s, 0, n - 1, true));
		return solve(s, 0, n - 1, true);
	}

	private static int solve(String s, int i, int j, boolean isTrue) {
		// TODO Auto-generated method stub

		if (i > j) {
			return 0;
		}

		if (i == j) {
			if (isTrue) {
				return s.charAt(i) == 'T' ? 1 : 0;
			} else {
				return s.charAt(i) == 'F' ? 1 : 0;
			}

		}

		int ans = 0;
		for (int k = i + 1; k <= j - 1; k += 2) {
			int lT = solve(s, i, k - 1, true);
			int lF = solve(s, i, k - 1, false);
			int rT = solve(s, k + 1, j, true);
			int rF = solve(s, k + 1, j, false);

			if (s.charAt(k) == '&') {
				if (isTrue) {
					ans = ans + lT * rT;
				} else {
					ans = ans + lF * rT + rF * lT + rF * lF;
				}
			} else if (s.charAt(k) == '^') {
				if (isTrue) {
					ans = ans + lT * rF + lF * rT;
				} else {
					ans = ans + lT * rT + rF * lF;
				}
			} else if (s.charAt(k) == '|') {
				if (isTrue) {
					ans = ans + lT * rF + lF * rT + rT * lT;
				} else {
					ans = ans + lF * rF;
				}
			}

		}

		return ans;
	}

	private static int solve1(String s, int i, int j, boolean isTrue) {
		// TODO Auto-generated method stub

		if (i > j) {
			return 0;
		}

		if (map.get(i + "_" + j + "_" + isTrue) != null) {
			return map.get(i + "_" + j + "_" + isTrue);
		}

		if (i == j) {
			if (isTrue) {
				return s.charAt(i) == 'T' ? 1 : 0;
			} else {
				return s.charAt(i) == 'F' ? 1 : 0;
			}

		}

		int ans = 0;
		int lT = 0;
		int lF = 0;
		int rT = 0;
		int rF = 0;
		for (int k = i + 1; k <= j - 1; k += 2) {

			if (map.get(i + "_" + (k - 1) + "_" + true) != null) {
				lT = map.get(i + "_" + (k - 1) + "_" + true);
			} else {
				lT = solve1(s, i, k - 1, true);
				map.put(i + "_" + (k - 1) + "_" + true, lT);
			}

			if (map.get(i + "_" + (k - 1) + "_" + false) != null) {
				lF = map.get(i + "_" + (k - 1) + "_" + false);
			} else {
				lF = solve1(s, i, k - 1, false);
				map.put(i + "_" + (k - 1) + "_" + false, lF);
			}

			if (map.get((k + 1) + "_" + j + "_" + true) != null) {
				rT = map.get((k + 1) + "_" + j + "_" + true);
			} else {
				rT = solve1(s, k + 1, j, true);
				map.put((k + 1) + "_" + j + "_" + true, rT);
			}

			if (map.get((k + 1) + "_" + j + "_" + false) != null) {
				rF = map.get((k + 1) + "_" + j + "_" + false);
			} else {
				rF = solve1(s, k + 1, j, false);
				map.put((k + 1) + "_" + j + "_" + false, rF);
			}

			if (s.charAt(k) == '&') {
				if (isTrue) {
					ans = ans + lT * rT;
				} else {
					ans = ans + lF * rT + rF * lT + rF * lF;
				}
			} else if (s.charAt(k) == '^') {
				if (isTrue) {
					ans = ans + lT * rF + lF * rT;
				} else {
					ans = ans + lT * rT + rF * lF;
				}
			} else if (s.charAt(k) == '|') {
				if (isTrue) {
					ans = ans + lT * rF + lF * rT + rT * lT;
				} else {
					ans = ans + lF * rF;
				}
			}

		}
		
		map.put(i + "_" + j + "_" + isTrue, ans);
		
		return ans;
	}
}
