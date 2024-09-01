package edu.binarySearchAlgorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArrays {
	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		System.out.println(Arrays.toString(intersection(nums1, nums2)));
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
        return nums1.length<=nums2.length?findIntersection(nums1,nums2):findIntersection(nums2,nums1);
    }
	
	public static int[] findIntersection(int[] nums1, int[] nums2){
        
        HashSet<Integer> hs = new HashSet<Integer>();
        Arrays.sort(nums2);
        for(int i:nums1){
            int foundIndex = searchBinary(nums2,i);
            if(foundIndex != -1){
                hs.add(nums2[foundIndex]);
            }
        }
        if(hs.size()==0){
            return new int[]{-1};
        }
        int[] narr = new int[hs.size()];
        int j=0;
        Iterator<Integer> it = hs.iterator();
        while (it.hasNext()) { 
            narr[j++] = it.next(); 
        } 
        return narr;
    }

    public static int searchBinary(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int index=-1;
        // System.out.println(end);
        while(start<=end){
            int mid = start+(end-start)/2;
//             System.out.println(mid);
            if(nums[mid]==target){
                index=mid;
                break;
            }
            else if(nums[mid]<target){
                start = mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return index;
    }
}
