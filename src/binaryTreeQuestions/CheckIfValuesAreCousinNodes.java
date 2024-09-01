package binaryTreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binaryTree.BinarySearchTree1.Node;

public class CheckIfValuesAreCousinNodes {
	
	// https://leetcode.com/problems/cousins-in-binary-tree/
	public static void main(String[] args) {
		
	}
	
	public boolean isCousins(Node root, int x, int y) {
        if(root == null){
            return false;
        }

        Queue<Node> que = new LinkedList<>();
        List<List<Node>> k = new ArrayList<>();
        que.add(root);
        int level = 0;
        while(!que.isEmpty()){
            int size = que.size();
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Node> arrNode = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr = que.poll();
                // System.out.println(curr.getData());
                arr.add(curr.getData());
                arrNode.add(curr);
                if(curr.left != null){
                    que.add(curr.left);
                }
                if(curr.right != null){
                    que.add(curr.right);
                }
            }
            k.add(arrNode);
            // System.out.println("level : "+level);
            if(arr.contains(x) && arr.contains(y)){
                if(level <= 1){
                    return false;
                }
                return !haveSameParents(k.get(level-1), x, y);
            }
            level++;
        }

        return false;
    }

    private boolean haveSameParents(List<Node> arrNode,int x, int y){
        Node xPar = new Node(0);
        Node yPar = new Node(0);
        // System.out.println("x :: "+x);
        // System.out.println("y :: "+y);
        // System.out.println(arrNode.size());
        for(Node node:arrNode){
            // System.out.println("node.left.getData() :: "+node.left.getData());
            // System.out.println("node.right.getData() :: "+node.right.getData());
            if(node.left != null){
                if(node.left.getData() == x){
                    xPar = node;
                }
                if(node.left.getData() == y){
                    yPar = node;
                }
            }

            if(node.right != null){
                if(node.right.getData() == x){
                    xPar = node;
                }
                if(node.right.getData() == y){
                    yPar = node;
                }
            }
        }
        // System.out.println(xPar.getData());
        // System.out.println(yPar.getData());
        return xPar.equals(yPar);
    }
    
    
    public boolean isCousins1(Node root, int x, int y) {
        if(root == null){
            return false;
        }

        Queue<Node> que = new LinkedList<>();
        que.add(root);
        Node xPar = new Node(0);
        Node yPar = new Node(0);

        boolean xFound = false;
        boolean yFound = false;
        
        while(!que.isEmpty()){
            ArrayList<Integer> arr = new ArrayList<>();
            int size = que.size();
            for(int i=0;i<size;i++){
                Node currNode = que.poll();
                arr.add(currNode.getData());
                if(currNode.left != null){
                    if(currNode.left.getData() == x){
                        xPar = currNode;
                        xFound = true;
                    }
                    if(currNode.left.getData() == y){
                        yPar = currNode;
                        yFound = true;
                    }
                    que.add(currNode.left);
                 }
        
                if(currNode.right != null){
                    if(currNode.right.getData() == x){
                        xPar = currNode;
                        xFound = true;
                    }
                    if(currNode.right.getData() == y){
                        yPar = currNode;
                        yFound = true;
                    }
                    que.add(currNode.right);
                }
            
            }
            if(xFound && yFound){
                // System.out.println(" xPar "+xPar.getData());
                // System.out.println(" yPar "+yPar.getData());
                // System.out.println(arr);
                if(arr.contains(x) && arr.contains(y)){
                    return !xPar.equals(yPar);
                }
                //  && ;
                  
            }
        }
        
        // if(xFound && yFound){
        //     return ;
        // }

        return false;
    }
    
}
