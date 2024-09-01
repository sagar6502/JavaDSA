package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import binaryTree.BinarySearchTree1.Node;

public class PopulatingNextRightPointersInEachNode {
	public static void main(String[] args) {
		
	}
	
//	https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
	
	public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Node> arr = new ArrayList<>();
            for(int i=0;i<size; i++){
                Node currNode = queue.poll();
                arr.add(currNode);
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
            for(int i=0;i<arr.size()-1;i++){
                arr.get(i).next = arr.get(i+1);
            }
            arr.get(arr.size()-1).next = null;
        }

        return root;
    }
	
	public Node connect1(Node root) {
        if(root == null){
            return root;
        }

        Node leftMost = root;
        
        while(leftMost.left != null) {
        	Node current = leftMost;
        	while(current != null) {
        		current.left.next = current.right;
        		if(current.next != null) {
        			current.right.next  = current.next.left;
        		}
        		current = current.next;
        	}
        	leftMost = leftMost.left;
        }
        
        return root;
        
    }
}
