package stringprograms;

public class SBuffer {
	public static void main(String[] args) {
		StringBuffer sbuff = new StringBuffer();
		sbuff.append("WeMakeDevs");
		
		String str = sbuff.toString();
		System.out.println(str);
		sbuff.insert(1,"Sunar");
		String st = "Sagar df afaef ag   fafdd";
		System.out.println(st.replaceAll("\\s", ""));
		sbuff.replace(1, 3, st);
		System.out.println(sbuff);
//		threadSafe(st);
//		threadNotSafe(str);
	}
	
	public static void threadSafe(String str) {
		StringBuffer sbuff = new StringBuffer(str);
		for(int i=0;i<200;i++) {
			sbuff.append(sbuff);
		}
		System.out.println(sbuff.toString().length());
	}
	
	public static void threadNotSafe(String str) {
		StringBuilder sbuff = new StringBuilder(str);
		for(int i=0;i<200;i++) {
			sbuff.append(sbuff);
		}
		System.out.println(sbuff.toString().length());
	}
}
