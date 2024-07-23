package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//import javax.swing.tree.Node;

public class BinarySearchTree1 {
	
	private Node root;
	
	 public static class Node{
		 public Node left;
		 public Node right;
		private int data;
		public Node next;
		
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
	
	 //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node root) 
    {
       ArrayList<Integer> arr = new ArrayList<Integer>();
       
       Queue<Node> que = new LinkedList<>();
       que.add(root);
       
       while(!que.isEmpty()){
           Node currNode = que.remove();
           arr.add(currNode.data);
           if(currNode.left != null){
               que.add(currNode.left);
           }
           if(currNode.right != null){
               que.add(currNode.right);
           }
       }
       
       return arr;
    }
    
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> arr = new ArrayList<>();
        if(root == null){
            return arr;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int LevelSize = queue.size();
            List<Integer> ans1 = new ArrayList<Integer>(LevelSize);
            for(int i=0;i<LevelSize;i++){
                Node currNode = queue.remove(); 
                ans1.add(currNode.getData());
                if(currNode.left !=  null){
                queue.offer(currNode.left);
                 }
           
                if(currNode.right != null){
                     queue.offer(currNode.right);
                // queue.add()
                 }
            }
            arr.add(ans1);
            // ans = new ArrayList<Integer>();
            
            
           
            // arr.add(ans);
        }
        return arr;
    }
    
    List<List<Integer>> al = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder2(Node root) {
        if(root == null){
            return al;
        }
        helper(root,0);
        return al;
    }

    private void helper(Node node, int level){
        if(al.size() == level) al.add(new ArrayList<Integer>());
        
        al.get(level).add(node.getData());

        if(node.left != null) helper(node.left,level+1);
        if(node.right != null) helper(node.right,level+1);


    }
    
}
