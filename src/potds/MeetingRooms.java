package potds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.geeksforgeeks.org/problems/attend-all-meetings/1
public class MeetingRooms {

	static class storeData implements Comparable<storeData> {
		int[] a;

		storeData(int[] a) {
			this.a = a;
		}

		public int compareTo(storeData o) {
			return this.a[0]-o.a[0];
		};
	}

		public static void main(String[] args) {
			int arr[][] = { { 2, 4}, {9,12}, { 6,10 } };
			System.out.println(canAttend(arr));
		}

		static boolean canAttend(int[][] arr) {
			// Your code here
			List<storeData> ans = new ArrayList<>();
			for (int[] a : arr) {
				ans.add(new storeData(a));
			}
			Collections.sort(ans);
// 			for(storeData b:ans) {
// 				System.out.println(Arrays.toString(b.a));
// 			}
			for (int i = 1; i < ans.size(); i++) {
				storeData d1 = ans.get(i);
				storeData d2 = ans.get(i-1);
				if(d1.a[0] < d2.a[1]) {
					return false;
				}
			}
			return true;
	}
}
