package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import binaryTree.BinarySearchTree1.Node;

public class Binary_Tree_Right_Side_View {
	
	// https://leetcode.com/problems/binary-tree-right-side-view/
	public List<Integer> rightSideView(Node root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        // System.out.println(findHeight(root));
        Integer[] ans = new Integer[findHeight(root)];
        helper(root, 0, ans);
        List<Integer> ans1 = new ArrayList<>(Arrays.asList(ans));
        return ans1;
    }

    private void helper(Node node, int level, Integer[] ans){
        if(node == null) return;

        // if(ans.size() == level) ans.add(0);

        // System.out.println(level+" = "+node.val+" - "+ans.size());
        // if(ans.size() < level){
            ans[level] = node.getData();
            
            Node node1;
            Node node2;
        
        

        if(node.left != null) helper(node.left, level+1, ans);

        if(node.right != null) helper(node.right, level+1, ans);

    }

    private int findHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return 1+Math.max(left,right);
    }
}
