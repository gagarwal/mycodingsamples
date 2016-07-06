import helper.TreeNode;

public class CountLeafNodes
{
	public static int countLeafodes(TreeNode node)
	{
		if(node == null) return 0;

		if(node.left == null && node.right == null)
			return 1;

		return countLeafodes(node.left) + countLeafodes(node.right);
	}
}
