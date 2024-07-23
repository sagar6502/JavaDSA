package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTree.BinarySearchTree.Node;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		
	}
	
	// method 1
	 List<List<Integer>> al = new ArrayList<List<Integer>>();
	    public List<List<Integer>> levelOrder2(Node root) {
	        if(root == null){
	            return al;
	        }
	        helper(root,0);
	        return al;
	    }

	    private void helper(Node node, int level){
	        if(al.size() == level) al.add(new ArrayList<Integer>());
	        
	        al.get(level).add(node.getValue());

	        if(node.left != null) helper(node.left,level+1);
	        if(node.right != null) helper(node.right,level+1);


	    }
	    
	    // method 2
	    public List<List<Integer>> levelOrder1(Node root) {
	        List<List<Integer>> arr = new ArrayList<>();
	        if(root == null){
	            return arr;
	        }
	        
	        Queue<Node> queue = new LinkedList<>();
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int LevelSize = queue.size();
	            List<Integer> ans1 = new ArrayList<Integer>(LevelSize);
	            for(int i=0;i<LevelSize;i++){
	                Node currNode = queue.remove(); 
	                ans1.add(currNode.getValue());
	                if(currNode.left !=  null){
	                queue.offer(currNode.left);
	                 }
	           
	                if(currNode.right != null){
	                     queue.offer(currNode.right);
	                // queue.add()
	                 }
	            }
	            arr.add(ans1);
	            // ans = new ArrayList<Integer>();
	            
	            
	           
	            // arr.add(ans);
	        }
	        return arr;
	    }
	    
}
