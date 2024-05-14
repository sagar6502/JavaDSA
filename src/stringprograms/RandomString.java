package stringprograms;

/**
 * @author generate random alpha value
 *
 */
public class RandomString {
	public static void main(String[] args) {
		System.out.println(generate(7));
	}
	
	static String generate(int size) {
		StringBuilder s = new StringBuilder();
		char c = 'A';
		for(int i=0;i<size;i++) {
			int ck =65+(int)(Math.random()*25);
//			System.out.println(ck);
			c = (char)(((int)c)+ck);
			s.append((char)ck);			
		}
		return s.toString();
	}
}
