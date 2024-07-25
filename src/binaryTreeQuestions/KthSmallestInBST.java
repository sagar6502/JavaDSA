package binaryTreeQuestions;

import java.util.ArrayList;

import binaryTree.BinarySearchTree1.Node;

public class KthSmallestInBST {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
	
	// 1- myself
	ArrayList<Node> ans = new ArrayList<>();    
    public int kthSmallest(Node root, int k) {
        IoT(root);
        // for(Node node:ans){
        //     System.out.print(node.val+" -> ");
        // }
        return ans.get(k-1).getData();
    }

    private void IoT(Node root){
        if(root == null){
            return;
        }
        
        
        IoT(root.left);
        ans.add(root);
        IoT(root.right);
    }
    
    //2 - kunal - more efficient
    int count = 0;  
    public int kthSmallest1(Node root, int k) {
        if(root == null){
            return -1;
        }

        int left = kthSmallest1(root.left,k);

        if(left != -1){
            return left;
        }
        count++;
        if(count == k){
            return root.getData();
        }

        return kthSmallest(root.right,k);
    }
}
