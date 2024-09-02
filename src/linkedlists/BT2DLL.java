package linkedlists;

import binaryTree.BinarySearchTree1.Node;

public class BT2DLL {
	DLL dl = new DLL();
	public static void main(String[] args) {
		
	}
	
	private void createSortedDLL(Node node) {
		if(node == null) {
			return;
		}
		
		createSortedDLL(node.left);
		dl.insertFirst(node.getData());
		createSortedDLL(node.right);
	}
}
