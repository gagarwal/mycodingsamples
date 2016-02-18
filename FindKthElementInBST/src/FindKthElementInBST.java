
import helper.TreeNode;

public class FindKthElementInBST {

	public static void main(String args[]) {
		
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		
		System.out.println("Root? " + root.data);
		System.out.println("kth smallest "+ + kthSmallest(root, 7));
		
		root.print();
		
	}

	public static int kthSmallest(TreeNode node, int k) {

		int count = k;

		int sizeOfLeftSubtree = 0;

		while (node != null) {
			sizeOfLeftSubtree = getNodeCount(node.left);

			if (sizeOfLeftSubtree + 1 == count)
				return node.getVal();

			else if (sizeOfLeftSubtree < count) {
				node = node.right;
				count = count - (sizeOfLeftSubtree + 1);
			}

			else {
				node = node.left;
			}
		}

		return -1;
	}

	private static int getNodeCount(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = getNodeCount(node.left);
		int right = getNodeCount(node.right);

		return 1 + left + right;
	}

}