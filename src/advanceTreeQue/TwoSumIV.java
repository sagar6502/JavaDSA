package advanceTreeQue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import binaryTree.BinarySearchTree1.Node;

public class TwoSumIV {
	public static void main(String[] args) {

	}

	/*
	 * // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/ Given
	 * the root of a binary search tree and an integer k, return true if there exist
	 * two elements in the BST such that their sum is equal to k, or false
	 * otherwise.
	 */
	ArrayList<Integer> ans = new ArrayList();

	public boolean findTarget(Node root, int k) {

		preOrder(root);

		Set<Integer> seen = new HashSet<>();

		for (int i : ans) {

			int comp = k - i;

			if (seen.contains(comp)) {
				return true;
			}

			seen.add(i);
		}

		return false;
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}

		preOrder(node.left);
		ans.add(node.getData());
		preOrder(node.right);
	}
}
