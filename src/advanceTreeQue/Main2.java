package advanceTreeQue;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import binaryTree.BinarySearchTree1.Node;

public class Main2 {

	// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
	/*
	 * Given the root of a binary tree, calculate the vertical order traversal of
	 * the binary tree.
	 * 
	 * For each node at position (row, col), its left and right children will be at
	 * positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of
	 * the tree is at (0, 0).
	 * 
	 * The vertical order traversal of a binary tree is a list of top-to-bottom
	 * orderings for each column index starting from the leftmost column and ending
	 * on the rightmost column. There may be multiple nodes in the same row and same
	 * column. In such a case, sort these nodes by their values.
	 * 
	 * Return the vertical order traversal of the binary tree.
	 */

	public static void main(String[] args) {

	}
	
	public List<List<Integer>> verticalTraversal(Node node) {
		List<List<Integer>> ans = new ArrayList<>();
		
		if(node == null) {
			return ans;
		}
		
		int col = 0;
		
		Queue<Map.Entry<Node, Integer>> queue = new ArrayDeque<>();
		
		Map<Integer, ArrayList<Integer>> map = new HashMap();
		
		queue.offer(new AbstractMap.SimpleEntry<>(node,col));
		
		int min = 0;
		int max = 0;
		
		while(!queue.isEmpty()) {
			Map.Entry<Node, Integer> removed = queue.poll();
			node = removed.getKey();
			col = removed.getValue();
			
			if(node != null) {
				if(!map.containsKey(col)) {
					map.put(col,new ArrayList<Integer>());
				}
				
				map.get(col).add(node.getData());
				
				min = Math.min(min, col);
				max = Math.max(max, col);
				
				queue.offer(new AbstractMap.SimpleEntry(node.left,col-1));
				queue.offer(new AbstractMap.SimpleEntry(node.right,col+1));
			}
			
			
			
		}
		
		for(int i=min ; i<=max; i++) {
			ans.add(map.get(i));
		}
		
		
		return ans;
	}
	
	/*
	HashMap<Integer,Integer> map = new LinkedHashMap<>();
	List<List<Integer>> ans = new ArrayList<>();
	int min = 0; int max = 0;
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		List<List<Integer>> ans = new ArrayList<>();
		helper(root,0);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            System.out.print("Key: "+key);
            System.out.println(", Value: " + value);
        }
		
		
		for(int i=min;i<=max;i++) {
			ArrayList<Integer> mini = new ArrayList<>();
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		        Integer key = entry.getKey();
		        if(key==i) {
		        	mini.add(map.get(key));
		        } 
		    }
            // Collections.sort(mini);
			ans.add(mini);
		}
		
		return ans;
	}

	private void helper(TreeNode node, int col) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		
		map.put(node.val, col);
		min = Math.min(min,col);
        max = Math.max(max,col);
        
		helper(node.left, col - 1);
		helper(node.right, col + 1);
	}
	
	private void dfs(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> an = new ArrayList<Integer>();
			for(int i=0; i<size;i++) {
				Node currNode = queue.remove();
				an.add(currNode.getData());
				if(currNode.left != null) {
					queue.add(currNode.left);
				}
				if(currNode.right != null) {
					queue.add(currNode.right);
				}
			}
			Collections.sort(an);
			ans.add(an);
		}
	}
	*/

	/*
	 * 
	 * HashMap<Integer[],Integer> map = new HashMap<>();
	int min = 0; int max = 0;
	
	
	public List<List<Integer>> verticalTraversal(Node root) {
		if(root == null) {
			return null;
		}
		
		List<List<Integer>> ans = new ArrayList<>();
		helper(root,0,0);
		
		
		
		for(int i=min;i<=max;i++) {
			ArrayList<Integer> mini = new ArrayList<>();
			for (Map.Entry<Integer[], Integer> entry : map.entrySet()) {
		        Integer[] key = entry.getKey();
		        if(key[1]==i) {
		        	mini.add(map.get(key));
		        } 
		    }
			Collections.sort(mini);
			ans.add(mini);
		}
		
		return ans;
	}

	private void helper(Node node,int row, int col) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		min = Math.min(min,col);
        max = Math.max(max,col);
		map.put(new Integer[]{row,col}, node.getData());
		
		helper(node.left,row + 1, col - 1);
		helper(node.right,row + 1, col + 1);
	}
	
	 * 
	 */
	
	
	

	
	/*
	 * 
	 */
	
}
 