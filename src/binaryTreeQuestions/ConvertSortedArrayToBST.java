package binaryTreeQuestions;

import binaryTree.BinarySearchTree1.Node;

public class ConvertSortedArrayToBST {

	public static void main(String[] args) {

	}

	
	// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	Node root;
	public Node sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		insertBST(nums, 0, nums.length - 1);
		return root;
	}

	private void insertBST(int[] nums, int start, int end) {

		if (start > end) {
			return;
		}
		int mid = start + (end - start) / 2;
		insert(nums[mid]);
		insertBST(nums, start, mid - 1);
		insertBST(nums, mid + 1, end);

	}

	private void insert(int num) {
		root = insert(root, num);
	}

	private Node insert(Node node, int num) {
		if (node == null) {
			node = new Node(num);
			return node;
		}

		if (num < node.getData()) {
			node.left = insert(node.left, num);
		} else {
			node.right = insert(node.right, num);
		}

		return node;
	}
}
