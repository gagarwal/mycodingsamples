import helper.BTreePrinter;
import helper.TreeNode;

public class BalancedBinaryTree
{
	private static boolean isBinaryTreeBalanced(TreeNode root)
	{
		return getBalancedHeight(root) > -1 ? true : false;
	}

	private static int getBalancedHeight(TreeNode root)
	{
		if (root == null) return 0;
			
		int leftHeight = getBalancedHeight(root.left);
		int rightHeight = getBalancedHeight(root.right);

		if (leftHeight == -1 || rightHeight == -1)
			return -1;

		if (Math.abs(rightHeight - leftHeight) > 1)
			return -1;

		return leftHeight > rightHeight ? (leftHeight + 1) : (rightHeight + 1);
	}
	
	public static void main(String[] args)
	{
		int[] array = { 0, 1, 3, 4, 7, 8 ,10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		System.out.println(isBinaryTreeBalanced(root));
	}
}
