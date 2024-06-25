package linearsearch;

public class FindMinNum {
	public static void main(String[] args) {
		int[] arr = {18,12,-7, 3,14,28};
		System.out.println(findMin(arr));
		System.out.println(findMax(arr));
	}
	
	private static int findMin(int[] arr) {
		int min=0;
		for(int i:arr) {
			if(i<min) min = i;
		}
		
		return min;
	}
	
	private static int findMax(int[] arr) {
		int max=0;
		for(int i:arr) {
			if(i>max) max = i;
		}
		
		return max;
	}
}
