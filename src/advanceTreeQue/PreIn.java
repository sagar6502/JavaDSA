package advanceTreeQue;

import java.util.HashMap;

import binaryTree.BinarySearchTree1.Node;

public class PreIn {
	
	int index = 0;
	
	public Node buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		
		return helper(preorder, inorder, 0, preorder.length-1, map);
	}

	private Node helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		if(left > right) {
			return null;
		}
		
		int current = 	preorder[index];
		index++;
		
		Node node = new Node(current);
		
		if(left == right) {
			return node;
		}
		
		
		int inorderIndex = map.get(current); 
		
		node.left = helper(preorder, inorder, left, inorderIndex-1,map);
		node.right = helper(preorder, inorder, inorderIndex+1, right,map);
		
		return node;
	}
}
