package mathsForDSA;

public class SieveOfEratosthenes {
	public static void main(String[] args) {
		int startingNum = 20;
		boolean[] isPrime = new boolean[startingNum+1];
//		Arrays.fill(isPrime, true);	
		isPrime[0] = false;
	    isPrime[1] = false;
		for(int i=2;i*i<=startingNum;i++) {
//			System.out.println(i*i);
			if(!isPrime[i]) {
					for(int c=i*2;c <= startingNum;c += i) {
						isPrime[c]=true;
					}
			}
		}
		for(int i=2;i<isPrime.length;i++) {
			if(!isPrime[i]) {
				System.out.print(i+" ");
			}
		}
	}
}
