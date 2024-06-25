package bitmanipulationInJava;

public class Power {
	public static void main(String[] args) {
		int base = 2;
		int power = 4;
		int ans = 1;
		while(power>0) {
			System.out.println("before power val :: "+(power & 1));
			if((power & 1) == 1) {
				ans *= base;
			}
			base *= base;
			System.out.println("base "+base);
			System.out.println("power :: "+power);
			power = power >> 1;
		}
		System.out.println(ans);
	}
}
