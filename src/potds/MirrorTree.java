package potds;

import binaryTree.BinarySearchTree1.Node;

public class MirrorTree {

	// https://www.geeksforgeeks.org/problems/mirror-tree/1

	/*
	 * Given a Binary Tree, convert it into its mirror.
	 * 
	 */

	void mirror(Node node) {
		// Your code here
		if (node == null) {
			return;
		}

		swap(node);

		mirror(node.left);
		mirror(node.right);
	}

	void swap(Node node) {
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
}
