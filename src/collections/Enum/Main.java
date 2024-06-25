package collections.Enum;

public class Main {
	enum Week implements A{
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
		// the above are enum constants
		// all above are public, static and final
		// since, it's final, we can not create child enums
		// type is week
		
		Week() {
			System.out.println("Constructor called for "+this);
		}
		//constructor is not public or protected, it is private or default
		// Don't want to create new objects
		// not an enum concept

		@Override
		public void helloWord() {
			// TODO Auto-generated method stub
			System.out.println("Hello");
		}
		
		// internally: public static final Week Monday = new Week();
	}
	public static void main(String[] args) {
		Week week;
		week = Week.Tuesday;
//		System.out.println(week);
		for(Week day: Week.values()) {
			System.out.println(day);
		}
		
		System.out.println(week.ordinal());
		week.helloWord();
	}
}
