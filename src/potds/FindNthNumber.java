package potds;

public class FindNthNumber {
	public static void main(String[] args) {
		long n = 19;
		
		System.out.println(findNth(n));
	}
	
	static long findNth(long n) {
        // code here
        if(n<9){
            return n;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            sb.insert(0,Long.toString(n%9));
            n /= 9;
        }
        return Long.parseLong(sb.toString());
    }
}
