package binarySearch2Darray;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		// Matrix is sorted in a row wise & column wise manner
		
		int[][] arr = {
						{10,20,30,40},
						{15,25,35,45},
						{28,29,37,49},
						{33,34,38,50}
					   };
		
		int[][] arr1 = {
							{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12},
							{13,14,15,16}
						};
		
		int[][] arr2 = {{1},{3}};
		
		int[][] arr3 = {
				{1,1},
				{2,2}
		};
		
		//one approach is convert it into linear array and apply binary search.
		
		int target = 3;
		System.out.println(Arrays.toString(searchBinary(arr3,target)));;
	}
	
	
	static int[] simpleBinarySearch(int[][] arr, int row,int cStart, int cEnd, int target) {
		while(cStart <= cEnd) {
			int mid = cStart+(cEnd-cStart)/2;
			if(arr[row][mid]==target) {
				return new int[] {row,mid};
			}
			if(arr[row][mid]<target) {
				cStart=mid+1;
			}else {
				cEnd= mid-1;
			}
		}
		return new int[] {-1,-1};
	}
	
	private static int[] searchBinary(int[][] arr, int target) {
		if(arr.length ==0 ) return new int[] {};
		int r = arr.length;
		int c = arr[0].length;
		
		if(r == 1) {
			return simpleBinarySearch(arr, 0, 0, c-1, target);
		}
		
		if (c == 1) {
            // Single column case
            int rStart = 0;
            int rEnd = r - 1;
            while (rStart <= rEnd) {
                int mid = rStart + (rEnd - rStart) / 2;
                if (arr[mid][0] == target) {
                    return new int[]{mid, 0};
                }
                if (arr[mid][0] < target) {
                    rStart = mid + 1;
                } else {
                    rEnd = mid - 1;
                }
            }
            return new int[]{-1, -1};
        }
		
		int rS = 0;
		int rE = r-1;
		int cMid = c/2;
		// run the loop till 2 rows are remaining
		while(rS<(rE-1)) {
			int mid = rS+(rE-rS)/2;
			if(arr[mid][cMid]==target) {
				return new int[] {mid,cMid};
			}
			if(arr[mid][cMid]<target) {
				rS = mid;
			}else {
				rE = mid;
			}
		}
		
		//now, we have two rows
		//check whether the target is in the  col of 2 rows
		if(arr[rS][cMid] == target) {
			return new int[] {rS,cMid}; 
		}
		
		if(arr[rS+1][cMid] == target) {
			return new int[] {rS+1,cMid};
		}
		
		//search in 1st half
		if(target <= arr[rS][cMid-1]) {
			return simpleBinarySearch(arr, rS, 0, cMid-1, target);
		}
		// search in 2nd half
		if(target >= arr[rS][cMid+1] && target <= arr[rS][c-1]) {
			return simpleBinarySearch(arr, rS, cMid+1, c-1, target);
		}
		
		// search in 3rd half
		if(target <= arr[rS+1][cMid-1]) {
			return simpleBinarySearch(arr, rS+1, 0, cMid-1, target);
		}
		
		// search in 4th half
		else {
			return simpleBinarySearch(arr, rS+1, cMid+1, c-1, target);
		}
		
	}
}
