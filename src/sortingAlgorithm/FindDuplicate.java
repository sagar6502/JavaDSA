package sortingAlgorithm;

import java.util.Arrays;

public class FindDuplicate {
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		System.out.println();
		System.out.println(findDuplicate(nums));
	}
	public static int findDuplicate(int[] nums) {
        boolean[] dup = new boolean[nums.length];
        System.out.println(Arrays.toString(dup));
        for(int d : nums){
            if(dup[d] == true) return d;
            dup[d] = true;
            System.out.println(Arrays.toString(dup));
        }
        return 0;
    }
}
