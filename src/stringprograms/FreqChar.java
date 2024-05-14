package stringprograms;

public class FreqChar {
	public static void main(String[] args) {
		String s = "Sagar Samundra";
		StringBuilder sb = new StringBuilder(s);
		for(int i=0; i<sb.length();i++) {
			char c = sb.charAt(i);
			int count = 1;
			for(int j=i+1;j<sb.length();j++) {
				if(c == sb.charAt(j)) {
					count++;
					sb.deleteCharAt(j);
				}
			}
			System.out.println(c+" : "+count);
		}
	}
}
