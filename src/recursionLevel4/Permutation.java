package recursionLevel4;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		String a = "abc";
		String b = "abcd";
		permutation("",a);
		System.out.println(permutationAsList("",a));
		System.out.println(permutationCount("",b));
	}
	
	private static void permutation(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char ch = up.charAt(0);
		
		for(int i=0; i <= p.length();i++) {
			String f = p.substring(0,i);
			String s = p.substring(i,p.length()); 
			permutation(f+ch+s, up.substring(1));
		}
	}
	
	private static ArrayList<String> permutationAsList(String p, String up) {
		ArrayList<String> ans1 = new ArrayList<String>();
		if(up.isEmpty()) {
			return new ArrayList<>(Arrays.asList(p));
		}
		
		char ch = up.charAt(0);
		
		for(int i=0; i <= p.length();i++) {
			String f = p.substring(0,i);
			String s = p.substring(i,p.length()); 
			ans1.addAll(permutationAsList(f+ch+s, up.substring(1)));
		}
		return ans1;
	}
	private static int permutationCount(String p, String up) {
		int c=0;
		if(up.isEmpty()) {
			return 1;
		}
		
		char ch = up.charAt(0);
		
		for(int i=0; i <= p.length();i++) {
			String f = p.substring(0,i);
			String s = p.substring(i,p.length()); 
			c = c+permutationCount(f+ch+s, up.substring(1));
		}
		return c;
	}
}
