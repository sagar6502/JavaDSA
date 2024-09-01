package assignmentsBT;

import java.util.ArrayList;
import java.util.List;

import binaryTree.BinarySearchTree1.Node;
import linkedlists.RemoveDuplicates.ListNode;

public class LinkedListInBT {
	public static void main(String[] args) {

	}

	// https://leetcode.com/problems/linked-list-in-binary-tree/
	List<String> list = new ArrayList<>();

	public boolean isSubPath(ListNode head, Node root) {
		StringBuilder sb1 = new StringBuilder();
		ListNode node = head;
		while (node != null) {
			sb1.append(node.val);
			node = node.next;
		}

		// List<Integer> ans1 = ;
		return dfs(root, new StringBuilder(), sb1.toString());
	}

	boolean check = false;

	private boolean dfs(Node node, StringBuilder str, String key) {
		if (node == null) {
			return false;
		}

		int len = str.length();

		str.append(node.getData());

		if (node.left == null && node.right == null) {
			// System.out.println(str.toString());
			check = str.toString().contains(key);
		} else {
			check = dfs(node.left, str, key) || dfs(node.right, str, key);
		}

		str.setLength(len);

		return check;
	}

	// optimized method
	public boolean isSubPath1(ListNode head, Node root) {
		if (head == null || root == null) {
			return false;
		}
		return dfs(root, head);
	}

	private boolean dfs(Node node, ListNode head) {
		if (node == null) {
			return false;
		}

		if (match(node, head)) {
			return true;
		}

		return dfs(node.left, head) || dfs(node.right, head);
	}

	private boolean match(Node node, ListNode head) {
		if (head == null) {
			return true;
		}

		if (node == null || node.getData() != head.val) {
			return false;
		}

		return match(node.left, head.next) || match(node.right, head.next);
	}
}
