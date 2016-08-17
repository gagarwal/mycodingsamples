import helper.BTreePrinter;
import helper.TreeNode;

public class ReplaceNodeWithItsChildrenSum 
{
	public static int sumDesc(TreeNode root)
	{
	    if(root == null) return 0;
	    int temp = root.data;
	    root.data = sumDesc(root.left)+ sumDesc(root.right);
	    return root.data+temp;
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 0, 1, 3 };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		sumDesc(root);
		BTreePrinter.printNode(root);
	}
}
