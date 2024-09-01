package recursionLevel2;

import java.util.ArrayList;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,4,7,8,14,14,17,24,33,34};
		int key = 14;
		System.out.println(searchLinearFirst(arr,0,key));
		System.out.println("Index (1 - based index) at : "+searchLinearLastIndex(arr,0,key,-1));
		System.out.println(searchLinearAll(arr,0,key,new ArrayList<Integer>()));
		System.out.println(searchLinearAll2(arr,0,key));
	}
	
	private static int searchLinearFirst(int[] arr, int i, int key) {
		if(i==arr.length) {
			return -1;
		}
		if(arr[i]==key) {
			return i;
		}
		return searchLinearFirst(arr, i+1, key);
	}
	
	private static int searchLinearLastIndex(int[] arr, int i, int key,int index) {
		if(i==arr.length) {
			return index;
		}
		if(arr[i]==key) {
			index =  i;
		}
		return searchLinearLastIndex(arr, i+1, key,index);
	}
	
	private static ArrayList<Integer> searchLinearAll(int[] arr, int i, int key,ArrayList<Integer> index) {
		if(i==arr.length) {
			return index;
		}
		if(arr[i]==key) {
			index.add(i);
		}
		return searchLinearAll(arr, i+1, key,index);
	}
	
	private static ArrayList<Integer> searchLinearAll2(int[] arr, int i, int key) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		if(i==arr.length) {
			return index;
		}
		if(arr[i]==key) {
			index.add(i);
		}
		ArrayList<Integer> ansFromBelowCalls =  searchLinearAll2(arr, i+1, key );
//		System.out.println(ansFromBelowCalls);
		index.addAll(ansFromBelowCalls);
		
		return index;
		
	}
}
