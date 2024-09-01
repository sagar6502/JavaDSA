package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import binaryTree.BinarySearchTree1.Node;

public class SerializeDeserializeBT {
	public static void main(String[] args) {

	}

	// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
	// Encodes a tree to a single string.
	public String serialize(Node root) {
		List<String> list = new ArrayList<>();
		helper(root, list);
		String encode = convertInString(list);
		return encode;
	}

	private String convertInString(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size() - 1; i++) {
			sb.append(list.get(i));
			sb.append(',');
		}
		sb.append(list.get(list.size() - 1));
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		List<String> list = new ArrayList<>();
		list = convertToList(data);
		Collections.reverse(list);
		Node node = helper2(list);
		return node;
	}

	private List<String> convertToList(String data) {
		String[] str = data.split(",");
		List<String> ans = new ArrayList<>();
		for (String s : str) {
			ans.add(s);
		}
		return ans;
	}

	void helper(Node node, List<String> list) {
		if (node == null) {
			list.add("null");
			return;
		}
		list.add(String.valueOf(node.getData()));

		helper(node.left, list);
		helper(node.right, list);
	}

	Node helper2(List<String> list) {
		String val = list.remove(list.size() - 1);

		if (val.charAt(0) == 'n') {
			return null;
		}
		Node node = new Node(Integer.parseInt(val));

		node.left = helper2(list);
		node.right = helper2(list);

		return node;
	}
}
