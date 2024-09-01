package assignmentsBT;

import binaryTree.BinarySearchTree1.Node;

public class isBalanced {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/balanced-binary-tree/description/
	public boolean isBalanced(Node root) {
        if(root == null){
            return true;
        }
        
        if(Math.abs(height(root.left)-height(root.right))>1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(Node node){
        if(node == null){
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left,right)+1;
    }
}
