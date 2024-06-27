package recursionLevel3;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSeqProblems {
	
	static ArrayList<String> ans1 = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
//		subseq("",str);
//		subseq2("",str);
//		subseqAscii("",str);
//		subseq3("",str,new ArrayList<String>());
//		System.out.println(ans1);
		System.out.println(subseqAsciiRet("",str));
	}

	static void subseq(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char ch = up.charAt(0);
		subseq(p+ch,up.substring(1));
		subseq(p,up.substring(1));
	}
	
	
	static void subseq2(String p, String up) {
		if(up.isEmpty()) {
			ans1.add(p);
			return;
		}
		
		char ch = up.charAt(0);
		subseq2(p+ch,up.substring(1));
		subseq2(p,up.substring(1));
	}
	
	static void subseq3(String p, String up, ArrayList<String> ans1) {
		if(up.isEmpty()) {
			ans1.add(p);
			return;
		}
		
		char ch = up.charAt(0);
		subseq3(p+ch,up.substring(1),ans1);
		subseq3(p,up.substring(1),ans1);
	}
	
	static ArrayList<String> subseq4(String p, String up) {
		if(up.isEmpty()) {
			return new ArrayList<>(Arrays.asList(p));
		}
		
		char ch = up.charAt(0);
		ArrayList<String> ans1 = subseq4(p+ch,up.substring(1));
		ArrayList<String> ans2 = subseq4(p,up.substring(1));
		ans1.addAll(ans2);
		
		return ans1;
	}
	
	static void subseqAscii(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char ch = up.charAt(0);
		subseqAscii(p+ch,up.substring(1));
		subseqAscii(p,up.substring(1));
//		subseqAscii(p+(ch+0),up.substring(1));
	}
	
	static ArrayList<String> subseqAsciiRet(String p, String up) {
		if(up.isEmpty()) {
			return new ArrayList<>(Arrays.asList(p));
		}
		
		char ch = up.charAt(0);
		ArrayList<String> ans1 = subseqAsciiRet(p+ch,up.substring(1));
		ArrayList<String> ans2 = subseqAsciiRet(p,up.substring(1));
		ArrayList<String> ans3 = subseqAsciiRet(p+(ch+0),up.substring(1));
		ans1.addAll(ans2);
		ans1.addAll(ans3);
		
		return ans1;
	}
}
