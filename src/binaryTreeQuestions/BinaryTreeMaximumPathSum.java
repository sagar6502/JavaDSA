package binaryTreeQuestions;

import binaryTree.BinarySearchTree1.Node;

public class BinaryTreeMaximumPathSum {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
	int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        
        helper(root);

        return maxSum;
    }

    private int helper(Node node){
        if(node == null){
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        left = Math.max(0,left);
        right = Math.max(0,right);


        int maximum = left+right+node.getData();

        maxSum = Math.max(maxSum,maximum);

        return Math.max(left,right)+node.getData();
    }
}
