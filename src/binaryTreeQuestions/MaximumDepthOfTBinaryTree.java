package binaryTreeQuestions;

import binaryTree.BinarySearchTree1.Node;

public class MaximumDepthOfTBinaryTree {
	public static void main(String[] args) {
		
	}
	
	
	// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
	public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right)+1;
    }
}
