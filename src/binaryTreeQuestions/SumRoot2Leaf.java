package binaryTreeQuestions;

import binaryTree.BinarySearchTree1.Node;

public class SumRoot2Leaf {
	public static void main(String[] args) {

	}
	/*
	 * You are given the root of a binary tree containing digits from 0 to 9 only.
	 * 
	 * Each root-to-leaf path in the tree represents a number.
	 * 
	 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
	 * Return the total sum of all root-to-leaf numbers. Test cases are generated so
	 * that the answer will fit in a 32-bit integer.
	 * 
	 * A leaf node is a node with no children. Input: root = [1,2,3] Output: 25
	 * Explanation: The root-to-leaf path 1->2 represents the number 12. The
	 * root-to-leaf path 1->3 represents the number 13. Therefore, sum = 12 + 13 =
	 * 25.
	 */
	
	// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
	
	public int sumNumbers(Node root) {
        if(root == null){
            return 0;
        }
         
         return dfs(root,0,0);
    }

    private int dfs(Node node, int sum, int totalSum){
        if(node == null){
            return 0;
        }
        sum = sum*10+node.getData();
        if(node.left == null && node.right == null){
            // System.out.println(sum);
            totalSum += sum;
            // sum=0;
            return totalSum;
        }
        return dfs(node.left,sum,totalSum)+dfs(node.right,sum,totalSum);
        
    }
}
