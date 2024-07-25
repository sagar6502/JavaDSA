package binaryTreeQuestions;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.BinarySearchTree1.Node;

public class FlattenBT {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
	Queue<Node> queue = new LinkedList<>();
    public void flatten(Node root) {
        // root1 = root;
        dispIoT(root);
        // root = root1;
        reArrange(root,queue);
    }

    private void reArrange(Node node, Queue<Node> queue){
        Node curr = queue.poll();
        while(!queue.isEmpty()){
            
            curr.right = queue.poll();
            curr.left = null;
            curr = curr.right;
        }
        node = curr;
    }

    private void dispIoT(Node node){
        if(node == null){
            return;
        }
        queue.add(node);
        dispIoT(node.left);
        dispIoT(node.right);
    }
}
