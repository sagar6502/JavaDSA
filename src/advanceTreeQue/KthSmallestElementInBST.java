package advanceTreeQue;

import binaryTree.BinarySearchTree1.Node;

public class KthSmallestElementInBST {
	// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
	
	/*
	 * Given the root of a binary search tree, and an integer k, return the kth
	 * smallest value (1-indexed) of all the values of the nodes in the tree.
	 */

	int res = 0;

	public int kthSmallest(Node root, int k) {
		int[] t = { k };
		preOrder(root, t);
		return res;
		// return ans.get(k-1);
	}

	private void preOrder(Node node, int[] t) {
		if (node == null) {
			return;
		}

		preOrder(node.left, t);
		t[0]--;
		if (t[0] == 0) {
			// System.out.println(node.val);
			res = node.getData();
			return;
		}

		preOrder(node.right, t);
	}
	
}
