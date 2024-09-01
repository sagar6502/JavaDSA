package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import binaryTree.BinarySearchTree1.Node;

public class CountPathsInBT {
	public static void main(String[] args) {
		
	}
	
	// count possible paths that can lead to the targetSum
	int count = 0;
	int countPaths(Node node, int sum) {
		List<Integer> path = new LinkedList<>();
		helper(node,sum,path);
		return count;
	}
	
	private int helper(Node node, int sum, List<Integer> path) {
		// TODO Auto-generated method stub
		if(node == null) {
			return 0;
		}
		
		path.add(node.getData());
		int count = 0;
		int s = 0;
		
		// how many paths to be taken
		ListIterator<Integer> itr = path.listIterator(path.size());
		while(itr.hasPrevious()) {
			sum += itr.previous();
			
			if(s == sum) {
				count++;
			}
		}
		
		
		count += helper(node.left, sum, path)+helper(node.right, sum, path);
		
		// backtrack
		path.remove(path.size()-1);
		return count;
	}
	
	
	// return all possible paths that can lead to the targetSum
		List<List<Integer>> findPaths(Node node, int sum) {
			List<List<Integer>> paths = new ArrayList<>();
			List<Integer> path = new ArrayList<>();
			helper1(node,sum,path, paths);
			return paths;
		}
		
		void helper1(Node node, int sum, List<Integer> path, List<List<Integer>> paths ) {
			// TODO Auto-generated method stub
			if(node == null) {
				return;
			}
			
			path.add(node.getData());
			
			if(node.getData() == sum && node.left == null && node.right == null) {
				paths.add(new ArrayList<>(path));
			}else {
				helper1(node.left, sum-node.getData(), path,paths);
				helper1(node.right, sum-node.getData(), path,paths);
			}
			
			// backtrack
			path.remove(path.size()-1);
		}
}
