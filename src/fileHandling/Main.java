package fileHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		
		/*
		
		
		try(InputStreamReader isr = new InputStreamReader(System.in)) {
			
			System.out.println("Enter some letters");
			int letters = isr.read();
			while(isr.ready()) {
				System.out.println((char) letters);
				letters = isr.read();
			}
			
			isr.close();
			System.out.println();
			
		}catch(IOException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		
		try(FileReader fr = new FileReader("src/fileHandling/note.txt")) {
			
//			System.out.println("Enter some letters");
			int letters = fr.read();
			while(fr.ready()) {
				System.out.println((char) letters);
				letters = fr.read();
			}
			
			fr.close();
			System.out.println();
			
		}catch(FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		*/
		
		// byte to char stream and then reading char stream
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("You typed : "+br.readLine());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader("src/fileHandling/note.txt"))){
			while(br.ready()) {
				System.out.println("You typed : "+br.readLine());
			}
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		/*
		int[] n = {12, 1, 2, 3, 0, 11, 4};
		int[] n1 = {1, 2, 3, 4, 5};
		
		int[] n2 = {1, 6, 2, 4, 2};
		
		int[] n3 = {9, 9, 7};
		
		System.out.println(Arrays.toString(constructLowerArray(n)));
		
		*/
		
	}
	
	private static int[] constructLowerArray(int[] arr) {
        // code here
        int n = arr.length;
        int[] narr = new int[n];
        
        if(n==0 || n==1){
            return arr;
        }
        
        for(int i=0;i<arr.length;i++){
            narr[i] = findSmallerElementsCount(Arrays.copyOfRange(arr,i+1,arr.length),arr[i]);
        }
        return narr;
    }

	private static int findSmallerElementsCount(int[] arr, int num) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
//		System.out.println("after sorting : "+Arrays.toString(arr));
		if( arr.length == 0) {
//			System.out.println("returned early for :: (arr.length == 1 || arr.length == 0) - "+num);
//			System.out.println("after sorting : "+Arrays.toString(arr));
			return 0;
		}
		
		if(num <= arr[0]) {
//			System.out.println("returned early for num < arr[0]:: "+num);
//			System.out.println("after sorting : "+Arrays.toString(arr));
			return 0;
		}
		if(num > arr[arr.length-1]) {
//			System.out.println("returned early for num >= arr[arr.length-1]:: "+num);
//			System.out.println("after sorting : "+Arrays.toString(arr));
			return arr.length;
		}
		int count=0;
		int start = 0;
		int end = arr.length-1;
//		while(start<end) {
//			int temp = arr[start];
//			arr[start] = arr[end];
//			arr[end] = temp;
//			start++;
//			end--;
//		}
//		System.out.println("Array in reverse order: "+Arrays.toString(arr));
//		System.out.println(num+"+"+Arrays.toString(arr));
		while(start < end) {
			int mid = start+(end-start)/2;
			if(arr[mid]>num) {
				end = mid-1;
			}else if(arr[mid] < num) {
				count++;
				start = mid+1;
			}
		}
//		System.out.println(count);
		return count;
	}
	
	
	int[] constructLowerArray1(int[] arr) {
        // code here
        int n = arr.length;
        int[] narr = new int[n];
        
        if(n==0 ){
            return arr;
        }
        
        for(int i=0;i<arr.length;i++){
            int count = 0;
            // narr[i] = findSmallerElementsCount(Arrays.copyOfRange(arr,i+1,arr.length),arr[i]);
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
            narr[i]=count;
        }
        return narr;
    }
}
