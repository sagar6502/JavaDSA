package binaryTree;

import binaryTree.BinarySearchTree.Node;

public class RemoveHalfNodes {
	public static void main(String[] args) {
//		BinaryTree bst = new BinaryTree();
//		bst.populateMultiple(null);
	}
	
	// Return the root of the modified tree after removing all the half nodes.
    public Node RemoveHalfNodes(Node root) {
        // Code Here
    	if(root == null) {
    		return root;
    	}
    	
    	root.left = RemoveHalfNodes(root.left);
    	root.right = RemoveHalfNodes(root.right);
    	
    	if(root.left != null && root.right == null) {
    		return root.left;
    	}
    	
    	if(root.right != null && root.left == null) {
    		return root.right;
    	}
    	
        return root;
    }
    
    
}
