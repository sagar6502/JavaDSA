package karpRabinStringMatchingAlgorithm;

public class Main {
	public static void main(String[] args) {
		String text = "Sagar Sunar Kam";
		String search = "unar";
		
		System.out.println(text.contentEquals(search));
		System.out.println(text.indexOf(search));
		KarpRabin kp = new KarpRabin();
		kp.search(text, search);
	}
}
