package recursiveProgramming;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40}; // for array of size-infinite
		int key = 13;
		System.out.println(binarySearch(arr, key, 0, arr.length-1));
	}

	private static int binarySearch(int[] arr, int key, int s, int e) {
		// TODO Auto-generated method stub
		if(s > e) {
			return -1;
		}
		int mid = s+(e-s)/2;
		
		if(arr[mid]==key) {
			return mid;
		}
		if(arr[mid]<key) {
			return binarySearch(arr, key, mid+1, e);
		}else {
			return binarySearch(arr, key, s, mid-1);
		}
	}
}
