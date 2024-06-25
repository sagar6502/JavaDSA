package linearsearch;

import java.util.Scanner;

public class FindElement {

	public static void main(String[] args) {
		int[] arr = new int[] {18,12,9,14,77,90};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the key element");
		int key = sc.nextInt();
		boolean foundEle = false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) {
				System.out.println("Element found at : "+(i+1)+"th index");
				foundEle = true;
				break;
			}
		}
		if(!foundEle) {
			System.out.println("Element is not found");
		}
		sc.close();
	}
}
