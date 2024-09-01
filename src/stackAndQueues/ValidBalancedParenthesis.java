package stackAndQueues;

import java.util.Stack;

public class ValidBalancedParenthesis {

	public static void main(String[] args) {
		
	}
	
	 public boolean isValid(String s) {
	        char[] ch = s.toCharArray();

	        if(isClosing(ch[0]) || (ch.length & 1) == 1) return false;

	        Stack<Character> stack = new Stack<Character>();

	        for(int i=0; i<ch.length;i++){
	            if(isClosing(ch[i]) && !stack.isEmpty()){
	                if(ch[i] != closing(stack.peek())){
	                    return false;
	                }else{
	                    stack.pop();
	                }
	            }else{
	                stack.push(ch[i]);
	            }
	        }

	        // if(!stack.isEmpty()){
	        //     return false;
	        // }

	        return stack.isEmpty();

	    }

	    private static boolean isClosing(char ch){
	        return ch == ')' || ch == '}' || ch == ']';
	    }

	    private static char closing(char ch){
	        if(ch == '(') return ')';

	        if(ch == '{') return '}';

	        if(ch == '[') return ']';

	        return 'o';
	    }
}
