package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTree.BinarySearchTree.Node;

public class ZigZagOrder {
	public static void main(String[] args) {
		
	}
//	Deque<E>
	
	// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
	public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        helper(root,0,ans);
        return ans;
    }

    private void helper(Node node, int level, List<List<Integer>> ans){
        if(node == null) return;

        if(level == ans.size()) ans.add(new ArrayList<Integer>());

        if((level&1) != 1){
            ans.get(level).add(node.getValue());
        }else{
            ans.get(level).add(0,node.getValue());
        }

        if(node.left != null) helper(node.left,level+1,ans);

        if(node.right != null) helper(node.right,level+1,ans);
    }
    
    public List<List<Integer>> zigzagLevelOrder1(Node root) {
        List<List<Integer>> arr = new ArrayList<>();
	        if(root == null){
	            return arr;
	        }
	        Boolean reverse = false;
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
                // System.out.println(LevelSize);
                if(reverse){
                    Collections.reverse(ans1);
                    
                }
                reverse = !reverse;
	            arr.add(ans1);
	        }
	        return arr;
    }
    
    /*
    public List<List<Integer>> zigzagLevelOrder2(Node root) {
        List<List<Integer>> arr = new ArrayList<>();
	        if(root == null){
	            return arr;
	        }
	        Boolean reverse = false;
	        Deque<Node> deque = new ArrayDeque<>();
	        deque.addFirst(root);
	        while(!deque.isEmpty()){
	            int LevelSize = deque.size();
	            List<Integer> ans1 = new ArrayList<Integer>(LevelSize);
	            for(int i=0;i<LevelSize;i++){
	                Node currNode = deque.remove(); 
	                ans1.add(currNode.getValue());
	                if(currNode.left !=  null){
	                deque.offer(currNode.left);
	                 }
	           
	                if(currNode.right != null){
	                     deque.offer(currNode.right);
	                // queue.add()
	                 }
	            }
                // System.out.println(LevelSize);
                if(reverse){
                    Collections.reverse(ans1);
                    
                }
                reverse = !reverse;
	            arr.add(ans1);
	        }
	        return arr;
    }
    */
}
