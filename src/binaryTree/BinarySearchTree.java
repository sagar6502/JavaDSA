package binaryTree;

import java.util.ArrayList;

public class BinarySearchTree {
	public class Node {
		private int value;
		 Node left;
		Node right;
		private int height;
		
		public Node(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	private Node root;
	
	public BinarySearchTree() {
		
	}
	
	public int height(Node node) {
		if(node == null) {
			return -1;
		}
		
		return node.height;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void display() {
		display(root,"Root Node: ");
	}

	private void display(Node node, String details) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		
		System.out.println(details+node.getValue());
		display(node.left,"left child of "+node.getValue()+ " : ");
		display(node.right,"right child of "+node.getValue()+ " : ");
	}
	
	public void displayPOT() {
		System.out.println("Pre order traversal of binary tree : ");
		preOrderTraversal(root);
		System.out.println();
	}
	private void preOrderTraversal(Node node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		
		System.out.print(node.getValue()+" -> ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
		
	public boolean balanced() {
		return balanced(root);
	}
	
	private boolean balanced(Node node) {
		if(node == null) {
			return true;
		}
		
		return Math.abs(height(node.left)-height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
	}
	
	public void populateMultiple(int[] nums) {
		for(int i: nums) {
			insert(i);
		}
	}
	
	public void populateSortedArray(int[] nums,int start, int end) {
		if(start >= end || nums.length == 0) {
			return;
		}
		int mid = start+(end-start)/2;
		insert(nums[mid]);
		populateSortedArray(nums,start,mid);
		populateSortedArray(nums,mid+1,end);
	}
	
	public void insert(int value) {
		root = insert(value,root);
	}
	
	private Node insert(int value, Node node) {
		if(node == null) {
			node = new Node(value);
			return node;
		}
		if(value < node.value) {
			node.left = insert(value, node.left);
		}else if(value > node.value) {
			node.right = insert(value, node.right);
		}
		
		node.height = Math.max(height(node.left),height(node.right))+1;
		
		return node;
	}
	
	//in-order traversal
	public void displayIOT() {
		System.out.println("In order traversal of binary tree : ");
		inOrderTraversal(root);
		System.out.println();
	}
	private void inOrderTraversal(Node node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.getValue()+" -> ");
		
		inOrderTraversal(node.right);
	}
	
	//post-order traversal
		public void displaypOT() {
			System.out.println("Post order traversal of binary tree : ");
			postOrderTraversal(root);
			System.out.println();
		}
		private void postOrderTraversal(Node node) {
			// TODO Auto-generated method stub
			if(node == null) {
				return;
			}
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.getValue()+" -> ");
		}
		
		// BFS - level order traversal
		public void displayLOT() {
			System.out.println("Level order traversal of binary tree : ");
			levelOrderTraversal(root);
			System.out.println();
		}
		
		private void levelOrderTraversal(Node node) {
			if(node == null) return;
			
			for(int i=0; i<=node.height;i++) {
				traverseAtLevel(node, i);
			}
		}
		
		private void traverseAtLevel(Node node,int level) {
			if(node == null) {
				return;
			}
			if(level==0)
				System.out.print(node.value+" -> ");
			
//			System.out.println(level);
			traverseAtLevel(node.left,level-1);
			traverseAtLevel(node.right,level-1);
			
		}
		
		public int findHeightOfTree() {
			if(root==null) {
				return 0;
			}
			return findHeight(root)+1;
		}
		
		private int findHeight(Node node) {
			return Math.max(height(node.left),height(node.right))+1;
		}
		
		public int countNodes() {
			if(root == null) {
				return 0;
			}
			return countNodes(root)-1;
		}
		
		public int countNodes(Node node) {
			if(node == null) {
				return 1;
			}
			int left = countNodes(node.left);
			int right = countNodes(node.right);
//			System.out.println(left);
//			System.out.println(right);
			return left+right;
		}
		
		public int height() {
			if(root == null) {
				return 0;
			}
			return height1(root)-1;
		}
//		static int left = 0 ; static int right = 0;
		private int height1(Node node) {
			if(node == null) {
				return 0;
			}
			int left = height1(node.left)+1;
			int right = height1(node.right)+1;
//			System.out.println("left: "+left);
//			System.out.println("right: "+right);
			return Math.max(left, right);
		}
		
		public void levelOrderTraversalArr() {
			System.out.println(levelOrderTraversalArr(root));
		}
		
		
		private ArrayList<Integer> levelOrderTraversalArr(Node node) {
			
//			ArrayList<Integer> ans1 =  new ArrayList<Integer>();
			if(node == null) return null;
			
			for(int i=0; i<=node.height;i++) {
				traverseAtLevelArr(node, i);
			}
//			System.out.println(ans);
			return ans;
		}
		static ArrayList<Integer> ans =  new ArrayList<Integer>();
		private void traverseAtLevelArr(Node node,int level) {
//			ArrayList<Integer> ans = new ArrayList<Integer>();
			if(node == null) {
				return;
			}
			if(level==0)
				ans.add(node.value);
			
//			System.out.println(level);
			traverseAtLevelArr(node.left,level-1);
			traverseAtLevelArr(node.right,level-1);
			
			
		}
		
		public int countLeftNodes() {
			return countNumberOfLeftNodes(root);
		}
		
		private int countNumberOfLeftNodes(Node node) {
			Node searchnode = findNode(node,11);
			System.out.println("searchNode :: "+searchnode.value);
			return searchnode == null ? 0:countNodes(searchnode.left)-1;
		}
		
		private Node findNode(Node node, int val) {
			if(node == null) {
				return node;
			}
			if(node.value == val) {
				System.out.println("found :: "+node.value);
				return node;
			}
			
			else if(node.value<val) {
				return findNode(node.right,val);
			}else {
				return findNode(node.left,val);
			}
			
//			return node;
		}
		
}
