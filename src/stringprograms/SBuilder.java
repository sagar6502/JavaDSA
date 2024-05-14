package stringprograms;

public class SBuilder {
	public static void main(String[] args) {
		StringBuilder series = new StringBuilder();
		for(int i=0;i<26;i++) {
			char ch = (char)('a'+i);
			series = series.append(ch);
		}
		StringBuilder series1 = new StringBuilder("bcde");
		StringBuilder series2 = new StringBuilder("ggfkhgf");
		System.out.println(series);
		System.out.println(series.reverse());
		System.out.println(series1.compareTo(series2));



	}
}
