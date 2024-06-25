package linearsearch;

public class EvenDigits {
	public static void main(String[] args) {
		int[] arr = {12,353,13,23153,124,12312,4342,987098};
		System.out.println(countEvenDigits(arr));
		System.out.println(countEvenDigits2(arr));
	}
	
	private static int countEvenDigits(int[] arr) {
		int count=0;
		for(int i:arr) {
			if(countDigit(i)%2==0) {
				count++;
			}
		}
		return count;
	}
	
	
	private static int countEvenDigits2(int[] arr) {
		int count=0;
		for(int i:arr) {
			if(isEvenDigit2(i)) {
				count++;
			}
		}
		return count;
	}
	
	private static int countDigit(int num) {
		int count=0;
		while(num>0) {
			count++;
			num /= 10;
		}
		return count;
	}
	
	private static boolean isEvenDigit(int num) {
		return Integer.toString(num).length()%2==0?true:false;
	}
	
	private static boolean isEvenDigit2(int num) {
		return (int)(Math.log10(num)+1)%2==0?true:false;
	}
}
