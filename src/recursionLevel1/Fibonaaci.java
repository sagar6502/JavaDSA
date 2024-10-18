package recursionLevel1;

public class Fibonaaci {
	
	public static void main(String[] args) {
		int n = 10;
		
		
		System.out.println(findFibonacciSeries(n-1));
	}

	private static int findFibonacciSeries(int n) {
		// TODO Auto-generated method stub
		if(n == 1 || n == 0) {
			return 1;
		}
		
		return findFibonacciSeries(n-2)+findFibonacciSeries(n-1);
	}
	
}
