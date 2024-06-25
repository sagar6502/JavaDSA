package recursiveProgramming;

public class Main1 {
	public static void main(String[] args) {
		message(1);
	}
	
	static void message(int n) {
		if(n>5) {
			return;
		}
		System.out.println(n);
		
		message(n+1);
	}
}
