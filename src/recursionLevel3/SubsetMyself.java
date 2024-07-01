package recursionLevel3;

import java.util.ArrayList;
import java.util.List;

public class SubsetMyself {
	public static void main(String[] args) {
		String str = "abc";
		int[] arr = {1,2,3};
		subseq("",str);
		removeChar("", "aasfcadgvbaag");
		subSetArray(new ArrayList<Integer>(),arr,0);
	}
	
	private static void subseq(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char c = up.charAt(0);
		subseq(p+c, up.substring(1));
		subseq(p, up.substring(1));
	}
	
	private static void removeChar(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char c = up.charAt(0);
		if(c=='a') {
			removeChar(p,up.substring(1));
		}else {
			removeChar(p+c,up.substring(1));
		}
	}
	
	private static void subSetArray(List<Integer> current, int[] arr, int i) {
		if(arr.length == i) {
			System.out.println(current);
			return;
		}
		current.add(arr[i]);
		subSetArray(current, arr, i+1);
		current.remove(current.size()-1);
		subSetArray(current, arr, i+1);
	}
}
