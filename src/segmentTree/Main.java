package segmentTree;

public class Main {
	public static void main(String[] args) {
		int[] nums = {3,8,6,7,-2,-8,4,9};
		int[] nums1 = {3,4,9,2,7};

		SegmentTree tree = new SegmentTree(nums1);
		
		tree.display();

		tree.update(2, 12);
		
		int sum = tree.query(2, 4);
		
		
		System.out.println(sum);
	}
}
