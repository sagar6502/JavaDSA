package karpRabinStringMatchingAlgorithm;

public class KarpRabin {
	
	private final int PRIME = 101;
	
	private long calculateHash(String str) {
		long hash = 0;
		
		for(int i=0; i< str.length(); i++) {
			hash = 	hash+ (long)(str.charAt(i) * Math.pow(PRIME, i));
		}
		return hash;
	}
	
	
	private long updateHash(long prevHash, char oldChar, char newChar, int patternLength) {
		long newHash = (prevHash-oldChar) / PRIME;
		
		newHash += newChar * Math.pow(PRIME, (patternLength-1));
		
		return newHash;
	}
	
	public void search(String text, String pattern) {
		int patternLength = pattern.length();
		long patternHash = calculateHash(pattern);
		
		long textHash = calculateHash(text.substring(0,patternLength));
		
		for(int i=0; i<= text.length()-pattern.length(); i++) {
			 if(textHash == patternHash) {
				 if(text.substring(i, i+patternLength).equals(pattern)) {
					 System.out.println("Pattern Found at index  :: "+i);
				 }
			 }
			 
			 if(i < text.length() - patternLength) {
				 textHash = updateHash(textHash, text.charAt(i), text.charAt(i+patternLength), patternLength);
			 }
		}
	}
}
