package bitmanipulationInJava;

public class FindUniqueValue {
	public static void main(String[] args) {
		int[] arr = {2,3,4,1,2,1,6,4,5,3,8,5,8};
		System.out.println(findUnique(arr));
	}

	
	// it only works for condition where other numbers than unique should appear only twice, not more than that and there should be only one number as unique
	private static int findUnique(int[] arr) {
		// TODO Auto-generated method
		int unique = 0;
		for(int i:arr) {
			unique ^= i ;
		}
		return unique;
	}
	
	
}
