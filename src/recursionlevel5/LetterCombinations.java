package recursionlevel5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {
	
	private static final String[] KEYPAD = {
	        "",    // 0
	        "",    // 1
	        "abc", // 2
	        "def", // 3
	        "ghi", // 4
	        "jkl", // 5
	        "mno", // 6
	        "pqrs",// 7
	        "tuv", // 8
	        "wxyz" // 9
	};
	
	static List<String> padRet1(String p, String up) {
		List<String> ans1 = new ArrayList<String>();
		if(up.isEmpty()) {
			ans1.add(p);
			return ans1;
		}
		
		int digit = up.charAt(0)-'0'; // this will convert '2'(character) into 2(integer)
		int val = KEYPAD[digit].length();
		String v = KEYPAD[digit];
		for(int i = ((digit-1)*val);i<(digit*val);i++) {
			char ch = (char)('a'+i-val);
			List<String> ans2 = padRet1(p+ch,up.substring(1));
			ans1.addAll(ans2);
		}
		return ans1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "23";
		
		System.out.println();
//		System.out.println(padRet("",digits));
		System.out.println(padRet1("",digits));
	}
	
	public static List<String> letterCombinations(String digits) {
       return null; 
    }
	
	public static void letterCombinations1(String p,String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char c = up.charAt(0);
		letterCombinations1(p+c, up.substring(1));
		letterCombinations1(p, up.substring(1));
    }
	
	static void pad(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		int digit = up.charAt(0)-'0'; // this will convert '2'(character) into 2(integer)
		
		for(int i = ((digit-1)*3);i<(digit*3);i++) {
			char ch = (char)('a'+i);
			pad(p+ch,up.substring(1));
		}
	}
	
	static List<String> padRet(String p, String up) {
		List<String> ans1 = new ArrayList<String>();
		if(up.isEmpty()) {
			ans1.add(p);
			return ans1;
		}
		
		int digit = up.charAt(0)-'0'; // this will convert '2'(character) into 2(integer)
		
		for(int i = ((digit-1)*3);i<(digit*3);i++) {
			char ch = (char)('a'+i);
			List<String> ans2 = padRet(p+ch,up.substring(1));
			ans1.addAll(ans2);
		}
		return ans1;
	}
	
	
}
