package linkedlists;

import java.util.HashSet;

public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
	
	private static boolean isHappy(int n) {
		HashSet<Integer> st = new HashSet<>();
        while(n >= 1){
            int sum = sumDigit(n);
            // System.out.println("Sum :: "+sum);
            // System.out.println("n :: "+n);
            if(sum == 1){
                return true;
            }
            if(st.contains(sum)){
                return false;
            }
            st.add(sum);

            n = sum;
        }
        return false;
    }
	
    private static int sumDigit(int n){
        int sum = 0;
        while(n > 0){
            sum += (int)Math.pow(n%10,2);
            n /= 10;
        }
        return sum;
    }
}
