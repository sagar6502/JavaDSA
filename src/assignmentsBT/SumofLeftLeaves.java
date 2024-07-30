package assignmentsBT;

import binaryTree.BinarySearchTree1.Node;

public class SumofLeftLeaves {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/sum-of-left-leaves/description/
	
	int sum = 0;
    public int sumOfLeftLeaves(Node root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 0;
        }
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                sum += root.left.getData();
            }
            
        }
        
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);

        return sum;
    }
}
