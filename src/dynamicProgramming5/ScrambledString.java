package dynamicProgramming5;

public class ScrambledString {
	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "caebd";
		System.out.println(isScramble(s1, s2));
	}
	
	public static boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
        	return false;
        }
        
        if(s1.isBlank() && s2.isBlank()) {
        	return true;
        }
        
        return solve(s1,s2);
    }

	private static boolean solve(String s1, String s2) {
		// TODO Auto-generated method stub
		
		if(s1.compareTo(s2) == 0) {
			return true;
		}
		
		if(s1.length() <= 1) {
			return false;
		}
		
		int n = s1.length();
		
		boolean flag = false;
		
		for(int i=1; i<= n-1; i++) {
			boolean cond1 = solve(s1.substring(0, i),s2.substring(n-i,n)) && solve(s1.substring(i,n),s2.substring(0, n-i));
			boolean cond2 = solve(s1.substring(0,i),s2.substring(0, i)) && solve(s1.substring(i,n),s2.substring(i, n));
			
			if(cond1 || cond2) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
}
