package advanceTreeQue;

import binaryTree.BinarySearchTree.Node;

public class TwoNodesSwapped {

	// https://leetcode.com/problems/recover-binary-search-tree/

	/*
	 * You are given the root of a binary search tree (BST), where the values of
	 * exactly two nodes of the tree were swapped by mistake. Recover the tree
	 * without changing its structure.
	 */

	public static void main(String[] args) {

	}

	Node first;
	Node second;
	Node prev;

	public void recoverTree(Node root) {
		iot(root);

		// swap
		int temp = first.getValue();
		first.setValue(second.getValue()); // Set the value of first to the value of second
		second.setValue(temp);

	}

	private void iot(Node node) {
		if (node == null) {
			return;
		}

		iot(node.left);

		if (prev != null && prev.getValue() > node.getValue()) {
			if (first == null) {
				first = prev;
			}

			second = node;
		}
		prev = node;

		iot(node.right);
	}

}
