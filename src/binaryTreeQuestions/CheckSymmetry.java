package binaryTreeQuestions;

import binaryTree.BinarySearchTree1.Node;

public class CheckSymmetry {
//	https://leetcode.com/problems/symmetric-tree/
	public static void main(String[] args) {
		
	}
	
	//method1
	public boolean isSymmetric(Node root) {
        if(root == null){
	        return true;
	    }

        return  helper(root.left, root.right);  
    }
   
    private boolean helper(Node node1, Node node2){
         if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
       
        if(node1.getData() != node2.getData()){
            // System.out.println("Passed ");
            return false;
        }

        return helper(node1.left,node2.right) && helper(node1.right,node2.left);
    } 
}
