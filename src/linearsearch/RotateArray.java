package linearsearch;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7}; int k = 2;
		int[] nums1 = {1,2,3,4,5,6,7};
		rotateRight(nums, k);
		rotateLeft(nums1,k);
	}
	
	public static void rotateRight(int[] nums, int k) {
        int n = nums.length;
        int rotate = k%n;
        if(rotate == 0){
        	System.out.println(Arrays.toString(nums));
            return;
        }

        int[] newNum = new int[n];
        for(int i=0;i<n;i++){
            // rotate += 1;
            newNum[i]=nums[Math.abs(n-rotate+i)%n];
            //  rotate += 1;
        }
        for(int i=0;i<n;i++){
            nums[i] = newNum[i];
        }
        // nums = Arrays.copyOf(newNum,n);
        System.out.println(Arrays.toString(newNum));
        return;
       
    }
	
	public static void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        int rotate = k%n;
        if(rotate == 0){
        	System.out.println(Arrays.toString(nums));
            return;
        }
//        System.out.println(rotate);
        int[] newNum = new int[n];
        for(int i=0;i<n;i++){
            // rotate += 1;
//        	System.out.println((rotate+i)%n);
            newNum[i]=nums[(rotate+i)%n];
            //  rotate += 1;
        }
        for(int i=0;i<n;i++){
            nums[i] = newNum[i];
        }
        // nums = Arrays.copyOf(newNum,n);
        System.out.println(Arrays.toString(newNum));
        return;
       
    }
}
