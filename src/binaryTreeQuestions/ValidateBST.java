package binaryTreeQuestions;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.BinarySearchTree1.Node;

public class ValidateBST {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/validate-binary-search-tree/
	//method : 1 myself :
	 Queue<Integer> queue = new LinkedList<>();
	    public boolean isValidBST(Node root) {
	        if(root == null){
	            return true;
	        }
	        inOrder(root);
	        // return helperValid(root,null,null); //another approach
	        return validate(queue);
	    }

	    

	    private void inOrder(Node node){
	        if(node == null){
	            return;
	        }
	        inOrder(node.left);
	        queue.add(node.getData());
	        // System.out.print(node.val+"->");
	        inOrder(node.right);

	    }

	    private boolean validate(Queue<Integer> queue){
	        int smallVal = queue.poll();
	        while(!queue.isEmpty()){
	            if(smallVal>=queue.peek()){
	                return false;
	            }
	            smallVal = queue.poll();
	        }
	        return true;
	    }

	    
	    // help of kunal/chatGPT
	    private boolean helperValid(Node node,Integer min, Integer max){
	        if(node == null){
	            return true;
	        }
	        int val = node.getData();
	        if(min != null && val <= min){
	            return false;
	        }
	        if(max != null && val >= max){
	            return false;
	        }
	        return helperValid(node.left,min,val) && helperValid(node.right,val,max);
	    }
	
}

