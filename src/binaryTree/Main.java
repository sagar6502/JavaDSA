package binaryTree;

import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] nums = {15,10,7,12,20};
		int[] nums1 = {15,10,7,12,20,17,22,4,9,11,13,16,18,21,24};
		int[] sortedAray = {1,2,3,4,5,6,7,8,9};
		int[] num2 = {2};
//		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 2)));
//		bst.populateSortedArray(sortedAray,0,sortedAray.length);
		bst.populateMultiple(nums1);
//		bst.insert(15);
//		bst.insert(10);
//		bst.insert(7);
//		bst.insert(12);
//		bst.insert(20);
//		bst.insert(21);
//		bst.display();
//		bst.displayIOT();
//		bst.displaypOT();
//		bst.displayPOT();
//		bst.displayLOT();
		bst.levelOrderTraversalArr();
		System.out.println(bst.findHeightOfTree());
//		System.out.println(bst.countNodes());
//		System.out.println(bst.height());
//		System.out.println(bst.balanced());
//		System.out.println(bst.height(9));
	}
}
