package assignmentsBT;

import binaryTree.BinarySearchTree1.Node;

public class MinDepthOfBT {
	public static void main(String[] args) {

	}

	// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
	public int minDepth(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.right == null && root.left == null) {
			return 1;
		}

		int min = Integer.MAX_VALUE;

		if (root.left != null) {
			min = Math.min(min, minDepth(root.left));
		}

		if (root.right != null) {
			min = Math.min(min, minDepth(root.right));
		}

		return min + 1;
	}
}
