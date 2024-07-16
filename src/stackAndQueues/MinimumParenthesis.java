package stackAndQueues;

import java.util.Stack;

public class MinimumParenthesis {

	// minimum-add-to-make-parentheses-valid
	
	public static void main(String[] args) {
		String s = "(((";
		System.out.println(minParenthesis2(s));
	}
	
	private static int minParenthesis(String s) {
		if(s.isEmpty()) {
			return 0;
		}
		
		Stack<Character> stack = new Stack<>();
		
//		char[] c = s.toCharArray();
		
		for(int i=0;i<s.length();i++) {
//			System.out.println(stack);
			if(isClosing(s.charAt(i)) && !stack.isEmpty() && s.charAt(i) == closing(stack.peek())) {
				stack.pop();
			}else {
				stack.push(s.charAt(i));
			}
		}
//		System.out.println(stack);
		
		return stack.size();
		
	}
	
	private static int minParenthesis1(String s) {
		if(s.isEmpty()) {
			return 0;
		}
		
		int openbr = 0;
		int closebr = 0;
		
		
		for(int i=0;i<s.length();i++) {
			if(isClosing(s.charAt(i))) {
				closebr++;
			}else {
				openbr++;
			}
		}
		
		return Math.min(Math.abs(closebr-openbr), Math.abs(openbr-closebr));
		
	}
		
	private static boolean isClosing(char ch){
        return ch == ')' || ch == '}' || ch == ']';
    }
	
	private static char closing(char ch){
        if(ch == '(') return ')';

        if(ch == ')') return '(';

        if(ch == '[') return ']';

        return 'o';
    }
	
	private static int minParenthesis2(String s) {
		int rightNeeded = 0;
		int leftNeeded = 0;
		
		for(char c: s.toCharArray()) {
			if(c=='(') {
				rightNeeded++;
			}else {
				if(rightNeeded>0) {
					rightNeeded--;
				}else {
					leftNeeded++;
				}
			}
		}
		
		return rightNeeded+leftNeeded;
		
	}
	
	
	// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
	public int minInsertions(String s) {
        int count=0;

        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            
        }
        return 0;
    }
}
