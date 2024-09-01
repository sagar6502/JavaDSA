package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;

import binaryTree.BinarySearchTree1.Node;

public class Main1 {
	public static void main(String[] args) {
		BinarySearchTree1 bst = new BinarySearchTree1();
		bst.insert(5);
		bst.insert(3);
		bst.insert(12);
		bst.insert(1);
		bst.display();
		System.out.println(bst.countNodes());
		
		Node node = bst.find(3);
		System.out.println(bst.countNodes(node.left)-1);
		
		int[] n = {12, 1, 2, 3, 0, 11, 4};
		System.out.println(Arrays.toString(constructLowerArray(n)));
//		System.out.println(node.getData());
	}
	
	static int[] constructLowerArray(int[] arr) {
        // code here
		if(arr.length == 0 || arr.length == 1) {
			return arr;
		}
		int n = arr.length;
		int[] narr = new int[n];
        BinarySearchTree1 bst = new BinarySearchTree1();
        bst.populate(arr);
        for(int i=0;i<arr.length;i++) {
//        	Node node = bst.find(arr[i]);
        	narr[i]=bst.countNodes(bst.find(arr[i]).left)-1;
        }
        return narr;
    }
	
	int[] constructLowerArray1(int[] arr) {
        // code here
       int n = arr.length;
       int[] ans = new int[n];
       ArrayList<Integer> list = new ArrayList<>();
       int ls = 0;
       
       for(int i=n-1;i>=0;i--){
           int id = add(list, ls, arr[i]);
           ans[i] = id;
           ls++;
       }
       
       return ans;
    }
    
    int add(ArrayList<Integer> list, int n, int x){
        int l=0, r= n-1;
        
        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(list.get(mid)==x){
                r= mid-1;
            }else if(list.get(mid)>x){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        if(l==n){
            list.add(x);
            return l;
        }
        
        list.add(l,x);
        return l;
    }
}
