package assignmentsBT;

import java.util.ArrayList;
import java.util.List;

import binaryTree.BinarySearchTree1.Node;

public class PreOrderTraversal {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/binary-tree-paths/
	List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(Node root) {
        poT(root);
        return ans;
    }

    private void poT(Node node){
        if(node == null){
            return;
        }
        ans.add(node.getData());
        poT(node.left);
        
        poT(node.right);
    }
}
