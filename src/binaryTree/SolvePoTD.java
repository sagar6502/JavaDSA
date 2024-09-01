package binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import binaryTree.BinarySearchTree.Node;

public class SolvePoTD {
	public static void main(String[] args) {
		
	}
	
//	static List<Integer> al = new ArrayList<Integer>();
	public List<Integer> merge(Node root1, Node root2) {
        // Write your code here
		List<Integer> ans = new ArrayList<Integer>();
        ans.addAll(inOrder(root1));
        ans.addAll(inOrder(root2));
        Collections.sort(ans);
        return ans;
        
    }
    
    private static List<Integer> inOrder(Node node){
    	List<Integer> al = new ArrayList<>();

    	inOrderHelper(node,al);
        return al;
    }

	private static void inOrderHelper(Node node, List<Integer> al) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		
		inOrderHelper(node.left,al);
		al.add(node.getValue());
		inOrderHelper(node.right, al);
	}
}
