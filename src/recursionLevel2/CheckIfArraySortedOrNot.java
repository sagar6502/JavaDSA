/**
 * 
 */
package recursionLevel2;

/**
 * @author Sagar Sunar
 *
 */
public class CheckIfArraySortedOrNot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,4,7,8,14,14,17,24,33,34};
		System.out.println(checkSorting(arr,1));
	}
	
	private static boolean checkSorting(int[] arr,int i) {		
		if(i==arr.length || arr.length == 1) {
			return true;
		}
		return arr[i]>=arr[i-1] && checkSorting(arr,i+1);
	}
}
