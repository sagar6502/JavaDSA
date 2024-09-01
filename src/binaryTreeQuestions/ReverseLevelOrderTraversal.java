package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import binaryTree.BinarySearchTree.Node;

public class ReverseLevelOrderTraversal {
	public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
       if(root == null){
           return ans;
       }

       helper(root,0,ans);
       Collections.reverse(ans);

       return ans;
   }

   private void helper(Node node, int level, List<List<Integer>> ans){
       if(node == null) return;
       if(level == ans.size()) ans.add(new ArrayList<Integer>());

       ans.get(level).add(node.getValue());

       if(node.left != null) helper(node.left,level+1,ans);
       if(node.right != null) helper(node.right,level+1,ans);
   }
}
