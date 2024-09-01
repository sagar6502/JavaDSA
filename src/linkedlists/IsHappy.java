package linkedlists;

public class IsHappy {
	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}
	
	private static boolean isHappy(int n) {
		int slow = n;
		int fast = n;
		do{
			slow = sumDigit(slow);
			fast = sumDigit(sumDigit(fast));
		}while(fast != slow);
		
		if(slow == 1) {
			return true;
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
