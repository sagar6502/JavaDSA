package segmentTree;

public class SegmentTree {

	private static class Node {
		int data;
		int startInterval;
		int endInterval;
		Node left;
		Node right;

		public Node(int startInterval, int endInterval) {
			this.startInterval = startInterval;
			this.endInterval = endInterval;
		}

	}

	Node root;

	public SegmentTree(int[] nums) {
		this.root = constructTree(nums, 0, nums.length - 1);
	}

	private Node constructTree(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		if (i == j) {
			// leaf node
			Node leaf = new Node(i, j);
			leaf.data = nums[i];
			return leaf;
		}

		// create new node with index we are at.
		Node node = new Node(i, j);
		int mid = i + (j - i) / 2;

		node.left = constructTree(nums, i, mid);
		node.right = constructTree(nums, mid + 1, j);

		node.data = node.left.data + node.right.data;

		return node;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		// TODO Auto-generated method stub
		String str = "";

		if (node.left != null) {
			str = str + "Interval = [" + node.left.startInterval + "," + node.left.endInterval + "] and data :: "
					+ node.left.data + " || ";

		} else {
			str = str + "No left child || ";
		}

		// for current node
		str = str + "Interval = [" + node.startInterval + "," + node.endInterval + "] and data :: " + node.data
				+ " || ";

		if (node.right != null) {
			str = str + "Interval = [" + node.right.startInterval + "," + node.right.endInterval + "] and data :: "
					+ node.right.data;

		} else {
			str = str + "No right child";
		}

		System.out.println(str+ '\n');

		// calling recursion
		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}

	}

	// query
	public int query(int qsi, int qei) {
		return this.query(this.root, qsi, qei);
	}

	public int query(Node node, int qsi, int qei) {
		
		if(node.startInterval >= qsi && node.endInterval <= qei) {
			// node is completely inside query
			return node.data;
		}
		else if(node.startInterval > qei || node.endInterval < qsi) {
			// completely outside
			return 0;
		} else {
			return query(node.left,qsi,qei)+query(node.right,qsi,qei);
		}
		
	}

	
	// update 
	public void update(int index, int value) {
		this.root.data = update(root,index, value);
	}

	private int update(Node node, int index, int value) {
		// TODO Auto-generated method stub
		
		if(node.startInterval <= index && index <= node.endInterval) {
			if(node.startInterval == index && node.endInterval == index) {
				node.data = value;
				return node.data;
			}else {
				int leftAns = update(node.left,index,value);
				int rightAns = update(node.right, index, value);
				node.data = leftAns+rightAns;
				return node.data;
			}
		}
		return node.data;
	}
}
