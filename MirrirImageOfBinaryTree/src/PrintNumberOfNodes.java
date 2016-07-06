import helper.TreeNode;

public class PrintNumberOfNodes
{
	public static int countNodes(TreeNode node)
	{
		if(node == null)
			return 0;
		
		return 1+countNodes(node.left)+countNodes(node.right);
	}
}
