package bitmanipulationInJava;

public class CheckPower {
	public static void main(String[] args) {
		int number = 1;
		System.out.println(checkIfPowerOfTwo(number));
	}
	
	private static boolean checkIfPowerOfTwo(int n) {
		if(n==1) {
			return true;
		}else if(n == 0){
			return false;
		}
		return (n & (n-1))==0;
	}
}
