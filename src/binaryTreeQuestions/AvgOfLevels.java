package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import binaryTree.BinarySearchTree.Node;

public class AvgOfLevels {
	
//	https://leetcode.com/problems/average-of-levels-in-binary-tree/
    	public List<Double> averageOfLevels(Node root) {
            List<Double> arr = new ArrayList<>();
            if(root == null) return arr;

            Queue<Node> que = new LinkedList<>();
            que.add(root);

            while(!que.isEmpty()){
                int level = que.size();
                double sum = 0;
                for(int i=0; i<level; i++){
                    Node currNode = que.remove();
                    sum += currNode.getValue();
                    if(currNode.left != null){
                        que.add(currNode.left);
                    }
                    if(currNode.right != null){
                        que.add(currNode.right);
                    }
                }
                arr.add(sum/level);
            }
            Collections.reverse(arr);
            return arr;
    }
    	
    	


}
