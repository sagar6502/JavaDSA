package assignmentsBT;

import java.util.ArrayList;
import java.util.List;

import binaryTree.BinarySearchTree1.Node;

public class InOrderTraversal {
	public static void main(String[] args) {

	}

	// https://leetcode.com/problems/binary-tree-inorder-traversal/description/

	List<Integer> ans = new ArrayList<>();

	public List<Integer> inorderTraversal(Node root) {
		IoT(root);
		return ans;
	}

	private void IoT(Node node) {
		if (node == null) {
			return;
		}

		IoT(node.left);
		ans.add(node.getData());
		IoT(node.right);
	}
}
