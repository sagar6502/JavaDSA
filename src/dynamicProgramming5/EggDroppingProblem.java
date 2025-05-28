package dynamicProgramming5;

import java.util.HashMap;
import java.util.Map;

public class EggDroppingProblem {

	static Map<String, Integer> map;

	public static void main(String[] args) {
		int k = 1;
		int n = 8;
		map = new HashMap<>();
		System.out.println(superEggDrop(k, n));
		System.out.println(superEggDrop2(k, n));
	}

	public static int superEggDrop(int e, int n) {
		if (e == 0 || e == 1) {
			return n;
		}

		if (n == 0 || n == 1) {
			return n;
		}

		int min = Integer.MAX_VALUE;

		for (int k = 1; k <= n; k++) {
			int temp = Math.max(superEggDrop(e - 1, k - 1), superEggDrop(e, n - k)) + 1;

			if (temp < min) {
				min = temp;
			}
		}
		return min;

	}

	// using binary-search
	public static int superEggDrop1(int e, int n) {
		if (e == 0) {
			return n;
		}

		if (n == 0 || n == 1) {
			return n;
		}

		int min = Integer.MAX_VALUE;

		int l = 1;
		int h = n;

		while (l <= h) {
			int mid = l + (h - l) / 2;
			int broken = superEggDrop1(e - 1, mid - 1);
			int notBroken = superEggDrop1(e, n - mid);
			int temp = Math.max(broken, notBroken) + 1;

			if (temp < min) {
				min = temp;
			}

			if (broken > notBroken) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		return min;

	}

	// using binary-search
	public static int superEggDrop2(int e, int n) {
		if (e == 0 || e == 1) {
			return n;
		}

		if (n == 0 || n == 1) {
			return n;
		}
		String key = e + "," + n;
		if (map.containsKey(key)) {
			return map.get(key);
		}

		int min = Integer.MAX_VALUE;

		int l = 1;
		int h = n;

		while (l <= h) {
			int mid = l + (h - l) / 2;
			String brokeyKey = (e - 1) + "," + (mid - 1);
			String notBrokenKey = e + "," + (n - mid);
			if (!map.containsKey(brokeyKey)) {
				map.put(brokeyKey, superEggDrop2(e - 1, mid - 1));
			}

			if (!map.containsKey(notBrokenKey)) {
				map.put(notBrokenKey, superEggDrop2(e, n - mid));
			}

			int temp = Math.max(map.get(brokeyKey), map.get(notBrokenKey)) + 1;

			if (temp < min) {
				min = temp;
			}

			if (map.get(brokeyKey) > map.get(notBrokenKey)) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		map.put(key, min);

		return min;

	}
}
