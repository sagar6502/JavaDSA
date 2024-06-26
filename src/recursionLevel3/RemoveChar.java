package recursionLevel3;

public class RemoveChar {
	public static void main(String[] args) {
		String s = "abaccada";
		char c = 'a';
		System.out.println(removeChar(s,0,c));
		skip("",s);
		String sA = "sagarapplsunar";
		String sF = "apple";
		String sS="app";
		System.out.println("skipping apple : "+skipAppApple(sA,sS,sF));
//		System.out.println(s.substring(3));;
		System.out.println(skip(s));
	}
	
	private static String removeChar(String s,int i,char c) {
		if(i>=s.length()) return "";
		
		char currentChar = s.charAt(i);
		if(currentChar==c) {
			return removeChar(s,i+1,c);
		}
		return currentChar+removeChar(s,i+1,c);
	}
	
	static void skip(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char ch = up.charAt(0);
		
		if(ch=='a') {
			skip(p, up.substring(1));
		} else {
			skip(p+ch, up.substring(1));
		}
	}
	
	private static String skip(String up) {
		if(up.isEmpty()) {
			return "";
		}
		
		char ch = up.charAt(0);
		
		if(ch == 'a') {
			return skip(up.substring(1));
		}
		else {
			return ch + skip(up.substring(1));
		}
	}
	
	private static String skipApple(String up,String removeString) {
		if(up.isEmpty()) {
			return "";
		}

		if(up.startsWith(removeString)) {
			return skipApple(up.substring(removeString.length()),removeString);
		}
		else {
			return up.charAt(0)+skipApple(up.substring(1),removeString);
		}
	}
	
	// should start with App not Apple
	private static String skipAppApple(String up,String keepString,String removeString) {
		if(up.isEmpty()) {
			return "";
		}
		if(up.startsWith(keepString) && !up.startsWith(removeString)) {
			return skipAppApple(up.substring(keepString.length()),keepString,removeString);
		}
		else {
			return up.charAt(0)+skipAppApple(up.substring(1),keepString,removeString);
		}
	}
}
