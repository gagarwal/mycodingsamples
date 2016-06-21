import helper.AssortedMethods;
import helper.TreeNode;

public class MirrirImageOfBinaryTree {

	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	public static TreeNode getMirrorImage(TreeNode root) {
		if (root == null)
			return root;

		else {

			TreeNode temp = root.right;
			root.right = root.left;
			root.left = temp;

			getMirrorImage(root.right);
			getMirrorImage(root.left);
		}

		return root;
	}

	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		helper.BTreePrinter.printNode(root);

		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(3);
		for (int i = 0; i < 3; i++) {
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}

		// System.out.println("Root? " + unbalanced.data);
		// System.out.println("Is balanced? " + isBalanced(unbalanced));

		helper.BTreePrinter.printNode(getMirrorImage(root));
	}

}