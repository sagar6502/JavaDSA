package dynamicProgramming6;

import binaryTree.BinarySearchTree1.Node;

public class TreeDiameter {
	public static void main(String[] args) {

	}

	private int findDia(Node node, int res) {
		if (node == null) {
			return 0;
		}
		int l = findDia(node.left, res);
		int r = findDia(node.right, res);

		int temp = Math.max(l, r) + 1;
		int ans = Math.max(l + r + 1, temp);
		res = Math.max(res, ans);

		return temp;
	}
}
