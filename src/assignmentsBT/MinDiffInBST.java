package assignmentsBT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import binaryTree.BinarySearchTree1.Node;

public class MinDiffInBST {
	public static void main(String[] args) {

	}

	// https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
	List<Integer> ans = new ArrayList<>();
	int minDiff = Integer.MAX_VALUE;
	
	public int getMinimumDifference(Node root) {
		if (root == null) {
			return 0;
		}

		InOrder(root);

		if (ans.size() == 1) {
			return ans.get(0);
		}
		Collections.binarySearch(ans, 1);
		for (int i = 1; i < ans.size(); i++) {
			minDiff = Math.min(ans.get(i) - ans.get(i - 1), minDiff);
		}
		// System.out.println(ans);
		return minDiff;
	}

	private void InOrder(Node node) {
		if (node == null) {
			return;
		}

		InOrder(node.left);
		ans.add(node.getData());
		InOrder(node.right);
	}
}
