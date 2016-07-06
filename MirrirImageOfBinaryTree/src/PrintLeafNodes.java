import helper.TreeNode;

public class PrintLeafNodes
{
	public  static void printLeafNodes(TreeNode node)
	{
		if(node == null) return;
		if(node.left == null && node.right == null)
			System.out.println(node.data);
		printLeafNodes(node.left);
		printLeafNodes(node.right);
	}
}
