package binaryTreeQuestions;

import java.util.ArrayList;

import binaryTree.BinarySearchTree1.Node;

public class PathSum {
	public static void main(String[] args) {

	}

	// https://leetcode.com/problems/path-sum/description/
	// method-1 : my way
	ArrayList<Integer> possibleSum = new ArrayList<>();

	public boolean hasPathSum(Node root, int targetSum) {
		if (root == null) {
			return false;
		}

		findSumsFromRootToLeaf(root, 0);
		// System.out.println(possibleSum);
		return possibleSum.contains(targetSum);
	}

	private void findSumsFromRootToLeaf(Node node, int sum) {
		if (node == null) {
			return;
		}
		sum += node.getData();
		if (node.left == null && node.right == null) {
			possibleSum.add(sum);
			return;
		}

		findSumsFromRootToLeaf(node.left, sum);
		findSumsFromRootToLeaf(node.right, sum);
	}

	// method - 2 : optimize by chatGPT
	public boolean hasPathSum1(Node root, int targetSum) {
		if (root == null) {
			return false;
		}

		return findSumsFromRootToLeaf(root, 0, targetSum);
	}

	private boolean findSumsFromRootToLeaf(Node node, int sum, int targetSum) {
		if (node == null) {
			return false;
		}
		sum += node.getData();
		if (node.left == null && node.right == null) {

			return sum == targetSum;
		}

		return findSumsFromRootToLeaf(node.left, sum, targetSum) || findSumsFromRootToLeaf(node.right, sum, targetSum);

	}
}
