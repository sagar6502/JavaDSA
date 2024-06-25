package stringprograms;

public class SingleTonClass {
	private static SingleTonClass single;
	
	private SingleTonClass() {
		System.out.println("Name :: ");
	}
	String name;
	public static SingleTonClass getInstance() {
		if(single == null) {
			single = new SingleTonClass();
		}
		return single;
	}
}
