package mathsForDSA;

import java.util.ArrayList;
import java.util.Collections;

public class FactorsOfNum {
	public static void main(String[] args) {
		factors2(36);
	}
	
	// O(n)
	static void factors1(int n) {
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				System.out.print(i+" ");
			}
		}
	}
	
	// O(sqrt(n)
		static void factors2(int n) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for(int i=1;i<=Math.sqrt(n);i++) {
				if(n%i==0) {
					if(n/i == i) {
						System.out.print(i+" ");
					}else {
						System.out.print(i+" ");
						ar.add(n/i);
					}
				}
			}
			Collections.sort(ar);
			for(int i:ar) {
				System.out.print(i+" ");
			}
		}
}
