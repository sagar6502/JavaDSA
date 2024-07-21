package binaryTree;

public class BinarySearchTree1 {
	
	private Node root;
	
	 static class Node{
		 Node left;
		 Node right;
		private int data;
		
		Node(int data){
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
	}
	
	public void insert(int item) {
		root = insert(root,item);
	}
	
	public Node insert(Node node,int item) {
		if(node == null) {
			node = new Node(item);
			return node;
		}
		if(item < node.data) {
			node.left = insert(node.left,item);
		}else {
			node.right = insert(node.right,item);
		}
		return node;
	}
	
	public void populate(int[] arr) {
		for(int i:arr) {
			insert(i);
		}
	}
	
	public void display() {
		display(root,"Root is :");
	}
	
	public int countNodes() {
		if(root.left == null && root.right == null) {
			return 1;
		}
		return countNodes(root)-1;
	}
	
	
	 int countNodes(Node node) {
		if(node == null) {
			return 1;
		}
		
		int left = countNodes(node.left);
		int right = countNodes(node.right);
		
		return left+right;
	}

	private void display(Node node,String details) {
		if(node == null) {
			return;
		}
		
		System.out.println(details+node.data);
		display(node.left,"left of "+node.data+" is ");
		display(node.right,"right of "+node.data+" is ");
	}
	
	public Node find(int data) {
		return findNode(root, data);
	}
	
	public Node findNode(Node node, int val) {
		if(node == null) {
			return node;
		}
		
		if(node.data == val) {
			return node;
		}
		
		if(node.data > val) {
			return findNode(node.left, val);
		}else {
			return findNode(node.right, val);
		}
	}
}
