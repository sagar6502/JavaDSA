package assignmentsBT;

import java.util.ArrayList;
import java.util.List;

import binaryTree.BinarySearchTree1.Node;

public class ClosestNodeQueriesInBST {
	public static void main(String[] args) {

	}

	// https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/description/
	List<Integer> ans = new ArrayList<>();

	public List<List<Integer>> closestNodes(Node root, List<Integer> queries) {
		List<List<Integer>> nd = new ArrayList<>();
		iot(root);
		for (int i : queries) {
			List<Integer> ans1 = new ArrayList<>();
			int[] d = new int[2];
			d = binarySearch(ans, i);
			ans1.add(d[0]);
			ans1.add(d[1]);
			nd.add(ans1);
		}

		return nd;
	}

	private void iot(Node root) {
		if (root == null) {
			return;
		}
		iot(root.left);
		ans.add(root.getData());
		iot(root.right);
	}

	private int[] binarySearch(List<Integer> arr, int key) {
		int start = 0;
		int end = arr.size() - 1;
		int result1 = -1; // Initialize result with the smallest possible value
		int result2 = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr.get(mid) == key) {
				return new int[] { arr.get(mid), arr.get(mid) }; // Element found
			} else if (arr.get(mid) > key) {
				result2 = arr.get(mid);
				end = mid - 1; // Search the left half
			} else {
				result1 = arr.get(mid); // Update result to the current mid value
				start = mid + 1; // Search the right half
			}
		}

		return new int[] { result1, result2 }; // Return the largest element smaller than key
	}
}
