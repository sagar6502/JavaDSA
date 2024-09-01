package binaryTreeQuestions;

import binaryTree.BinarySearchTree1.Node;

public class FindCommonAncestors {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
	
	 public Node lowestCommonAncestor(Node root, Node p, Node q) {
	       if(root == null){
	        return null;
	       }
	       if(root == p || root == q){
	        return root;
	       }
	       Node left = lowestCommonAncestor(root.left,p,q);
	       Node right = lowestCommonAncestor(root.right,p,q);
	       if(left != null && right != null){
	        return root;
	       }
	       return left == null ? right:left;
	    }
}
