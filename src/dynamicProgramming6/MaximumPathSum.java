package dynamicProgramming6;

import binaryTree.BinarySearchTree1.Node;

public class MaximumPathSum {
	int res = 0;

	public static void main(String[] args) {

	}

	// any node to any node
	private int findMaxSum(Node node) {
		if (node == null) {
			return 0;
		}

		// Calculate the maximum sum of left and right subtrees
		int leftSum = Math.max(0, findMaxSum(node.left)); // Ignore negative contributions
		int rightSum = Math.max(0, findMaxSum(node.right)); // Ignore negative contributions

		// Update the global maximum path sum considering the current node
		res = Math.max(res, leftSum + rightSum + node.getData());

		// Return the maximum path sum ending at this node
		return Math.max(leftSum, rightSum) + node.getData();
	}

	private int findMaxLeafToLeafSum(Node node) {
		if (node == null) {
			return 0;
		}

		// If the current node is a leaf, return its value
		if (node.left == null && node.right == null) {
			return node.getData();
		}

		// Recursively calculate the maximum sum for the left and right subtrees
		int leftSum = findMaxLeafToLeafSum(node.left);
		int rightSum = findMaxLeafToLeafSum(node.right);

		// If both children are present, update the global result
		if (node.left != null && node.right != null) {
			res = Math.max(res, leftSum + rightSum + node.getData());
		}

		// Return the maximum path sum ending at this node (choose the greater side)
		return (node.left == null ? rightSum : node.right == null ? leftSum : Math.max(leftSum, rightSum))
				+ node.getData();
	}

}
