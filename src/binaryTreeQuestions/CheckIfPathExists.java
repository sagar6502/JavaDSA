package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.List;

import binaryTree.BinarySearchTree1.Node;

public class CheckIfPathExists {
	public static void main(String[] args) {
		
	}
	
	// https://leetcode.com/problems/binary-tree-paths/description/
	List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(Node root) {
        helper(root, new StringBuilder());
        return ans;
    }

    private void helper(Node node, StringBuilder str){
        if(node == null){
            return;
        }

        int len = str.length();

        if(str.isEmpty()){
            str.append(node.getData());
        }else{
            str.append("->");
            str.append(node.getData());
        }
        
        if(node.left == null && node.right == null){
            ans.add(str.toString());
        }else{
            helper(node.left,str);
            helper(node.right, str);
        }

        str.setLength(len);
       
    }
}
