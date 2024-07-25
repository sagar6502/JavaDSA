package binaryTreeQuestions;

import binaryTree.BinarySearchTree1.Node;

public class DiameterOfTree {
	public static void main(String[] args) {

	}
	
	
	//.https://leetcode.com/problems/diameter-of-binary-tree/
	int diameter = 0;
    public int diameterOfBinaryTree(Node root) {
        if(root == null){
            return 0;
        }
        height(root);
        return diameter-1;
    }

    private int height(Node node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return 0;
		}
		int left = height(node.left);
		int right = height(node.right);
        // int n = diameter(node);

        int dia = left+right+1;
        diameter = Math.max(diameter,dia);
		
		return Math.max(left,right)+1;
	}
}
