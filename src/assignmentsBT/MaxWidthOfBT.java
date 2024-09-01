package assignmentsBT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTree.BinarySearchTree1.Node;

public class MaxWidthOfBT {
	public static void main(String[] args) {

	}

	// https://leetcode.com/problems/maximum-width-of-binary-tree/

	// TLE at some point
	int maxWidth = 0;

	public int widthOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		}
		helper(root);
		return maxWidth;
	}

	private void helper(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		List<List<Integer>> nd = new ArrayList<>();
		int h = height(root);
		for (int j = 0; j < h; j++) {
			int size = queue.size();
			List<Integer> ans = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node currNode = queue.poll();
				ans.add(currNode.getData());
				if (currNode.left != null) {
					queue.add(currNode.left);
				} else {
					queue.add(new Node(-1));
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				} else {
					queue.add(new Node(-1));
				}
			}
			nd.add(ans);

		}

		for (List<Integer> i : nd) {
			int width = 0;
			if (!i.contains(-1)) {
				width = i.size();
			} else {
				int startInd = 0;
				int endInd = i.size() - 1;
				boolean sF = false;
				boolean sE = false;
				while (!sF || !sE) {
					if (i.get(startInd) == -1) {
						startInd++;
					} else {
						sF = true;
					}
					if (i.get(endInd) == -1) {
						endInd--;
					} else {
						sE = true;
					}
				}
				// System.out.println(i.size()+" i.size() + startInd "+startInd+" endInd
				// "+endInd);
				width = endInd - startInd + 1;
			}
			maxWidth = Math.max(maxWidth, width);
			// System.out.println(i+" : "+width);
		}
	}

	private int height(Node node) {
		if (node == null) {
			return 0;
		}

		int left = height(node.left);
		int right = height(node.right);

		return Math.max(left, right) + 1;
	}
	
	// little more optimized
	
    public int widthOfBinaryTree1(Node root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
       helper(root);
       return maxWidth;
    }

    private void helper1(Node root){
        if(root == null){
            return;
        }
        
        Deque<Node> queue = new ArrayDeque();
        queue.add(root);
        int h = height(root);
        int k = -820;
        for(int j=0;j<h;j++){
            int width = 0;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node currNode = queue.removeFirst();
                if(currNode.left != null){
                    queue.add(currNode.left);
                }else{
                    queue.add(new Node(k));
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }
                else{
                    queue.add(new Node(k));
                }
            }
            // for (Node node : queue) {
            //     System.out.print(node.getData() + " ");
            // }
            
            // System.out.println();
            if(queue.peekFirst() != null && queue.getFirst().getData() != k && queue.getLast().getData() != k && queue.peekLast() != null){
                width = queue.size();
            }else{
                while( queue.peekFirst() != null && queue.getFirst().getData() == k){
                    queue.removeFirst();
                }
                while(queue.peekLast() != null && queue.getLast().getData() == k){
                    queue.removeLast();
                }
                width = queue.size();
            }
            maxWidth = Math.max(width, maxWidth);
        }
    }

}
