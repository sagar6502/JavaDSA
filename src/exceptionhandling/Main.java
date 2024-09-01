package exceptionhandling;

public class Main {
	public static void main(String[] args) {
		int a = 5;
		int b = 2;
		try {
			divide(a,b);
			String name="Sagar";
			if(name.equals("Sagar")) {
				throw new MyException("name is Sagar");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("this will always execute");
		}
	}
	
	static int divide(int a, int b) throws ArithmeticException {
		if( b == 0) {
			throw new ArithmeticException("Please do not divide by zero");
		}
		
		return a/b;
	}
}
