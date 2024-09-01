package linearsearch;

public class SearchInStrings {
	public static void main(String[] args) {
		String s = "Sunar";
		char k = 'f';
		System.out.println(search(s,k));
	}
	
	static boolean search2(String str, char c) {
		if(str.length() == 0) return false;
		
		for(char ch:str.toCharArray()) {
			if(c == ch) return true;
		}
		return false;
	}
	
	static boolean search(String str, char c) {
		if(str.length() == 0) return false;
		
		for(int i=0;i<str.length();i++) {
			if(c == str.charAt(i)) return true;
		}
		return false;
	}
}
