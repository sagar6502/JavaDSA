package lambdaExpression;


public class Expression1 implements NewInterface {
	public static void main(String[] args) {
		 NewInterface myInterface = (name) -> System.out.println("My Name is : " + name);

	        // Calling the method using lambda expression
	    myInterface.myMethod("Sagar");
	}

	@Override
	public void myMethod(String name) {
		// TODO Auto-generated method stub
		
	}

}
