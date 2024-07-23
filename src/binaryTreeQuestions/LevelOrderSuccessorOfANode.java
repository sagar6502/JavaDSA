package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTree.BinarySearchTree.Node;

public class LevelOrderSuccessorOfANode {
	public static void main(String[] args) {
		
	}
  
	    // method 2
	    public int levelOrder1(Node root, int key) {
	        List<Integer> arr = new ArrayList<>();
	        if(root == null){
	            return -1;
	        }
	        
	        Queue<Node> queue = new LinkedList<>();
	        queue.offer(root);
	        int index = 0;
	        int keyIndex = -1;
	        while(!queue.isEmpty()){
	            Node node = queue.remove();
//	            if(node.getValue() == key) {
//	            	keyIndex = index;
//	            }
//	            index++;
	            arr.add(node.getValue());
	            if(node.left != null) {
	            	queue.add(node.left);
	            }
	            if(node.right != null) {
	            	queue.add(node.right);
	            } 
	            
	            
	            if(key == node.getValue()) {
	            	break;
	            }
	            
	        }
	        if(!arr.contains(key)) {
	        	System.err.println("Element node found");
	        	return -1;
	        }else {
	        	return queue.peek().getValue();
	        }
//	        return arr;
	    }
	    
}
