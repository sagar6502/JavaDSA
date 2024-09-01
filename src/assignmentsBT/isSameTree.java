package assignmentsBT;

import binaryTree.BinarySearchTree1.Node;

public class isSameTree {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/same-tree/description/
	public boolean isSameTree(Node p, Node q) {
        if(p==null && q==null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }

        if(p.getData() != q.getData()){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
