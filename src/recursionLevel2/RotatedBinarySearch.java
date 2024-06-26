package recursionLevel2;

public class RotatedBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,7,8,10,1,2,3};
		int target = 7;
		int n=arr.length-1;
		System.out.println(findPivot(arr));
		System.out.println(search(arr, target, 0, n));
	}
	
	private static int findPivot(int[] arr) {
		int s = 0;
		int e = arr.length-1;
		while(s<e) {
			int m = s+(e-s)/2;
			if(arr[m]<arr[m-1] && m > 0) {
				return arr[m];
			}
			else if(arr[m]>arr[s] && arr[m]>arr[e]) {
				s = m+1;
			}
			else {
				e = m;
			}
		}
		return arr[s];
	}
	
	private static int search(int[] arr, int target, int s, int e) {
		if(s>e) {
			return -1;
		}
		
		int m = s + (e-s)/2;
		if(arr[m]==target) {
			return m;
		}
		if(arr[s] <= arr[m]) {
			if(target >= arr[s] && target <= arr[m]) {
				return search(arr,target,s,m-1);
			}
			else {
				return search(arr,target, m+1,e);
			}
		}
		
		if(target >= arr[m] && target <= arr[e]) {
			return search(arr,target, m+1,e);
		}
		
		return search(arr,target,s,m-1);
	}

}
