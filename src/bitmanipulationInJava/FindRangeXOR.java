package bitmanipulationInJava;

public class FindRangeXOR {
	public static void main(String[] args) {
		int n=9;
		int a=3;
		int b=9;
		System.out.println(findFromAtoB(a, b));
		System.out.println(findXORUptoN(n));
	}
	private static int findXORUptoN(int n) {
		if(n%4==0) return n;
		if(n%4==1) return 1;
		if(n%4==2) return n+1;
		if(n%4==3) return 0;
		
		
		return 0;
	}
	
	private static int findFromAtoB(int a, int b) {
		int iSum = findXORUptoN(b);
		int jSum = findXORUptoN(a-1);
		
		return iSum-jSum;
	}
}
