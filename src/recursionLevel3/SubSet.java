package recursionLevel3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int[] arr1 = {1,2,2};
		Arrays.sort(arr1);

		subSet(new ArrayList<Integer>(),arr,0);
	}
	
	private static List<List<Integer>> subSet(int[] arr){
		List<List<Integer>> outer = new ArrayList<>();
		outer.add(new ArrayList<>());
		
		for(int num: arr) {
			int n = outer.size();
//			System.out.println(n);
			for(int i=0;i<n;i++) {
//				System.out.println("outer.get("+i+") : "+outer.get(i));
				List<Integer> inner = new ArrayList<>(outer.get(i));
				inner.add(num);
				outer.add(inner);
			}
		}
		
		return outer;
	}
	
	static void subSet(List<Integer> current, int[] arr, int i) {
		if(arr.length == i) {
			System.out.println(current);
			return;
		}
		current.add(arr[i]);
		subSet(current, arr,i+1);
		current.remove(current.size() - 1);
		subSet(current, arr, i + 1);
	}
	
	private static List<List<Integer>> subSetDuplicate(int[] arr){
		List<List<Integer>> outer = new ArrayList<>();
		outer.add(new ArrayList<>());
		
		for(int num: arr) {
			int n = outer.size();
//			System.out.println(n);
			for(int i=0;i<n;i++) {
//				System.out.println("outer.get("+i+") : "+outer.get(i));
				List<Integer> inner = new ArrayList<>(outer.get(i));
				inner.add(num);
				outer.add(inner);
			}
		}
		
		return outer;
	}
}
