package binaryTreeQuestions;

import binaryTree.BinarySearchTree1.Node;

public class InvertBinaryTree {
	public static void main(String[] args) {

	}
	
	// https://leetcode.com/problems/invert-binary-tree/
	public Node invertTree(Node root) {
		if (root == null) {
			return root;
		}
		swap(root);
		return root;
	}

	private void swap(Node node) {
		if (node == null)
			return;
		
		Node temp = node.right;
		node.right = node.left;
		node.left = temp;
		
		swap(node.left);
		swap(node.right);
	}
}
