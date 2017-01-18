import helper.BTreePrinter;
import helper.TreeNode;

public class ReplaceNodeValueWithSumOfRIghtChild 
{

	public static void nodeGetSumGreater(TreeNode node)
	{
		if(node == null) return ;
		
		node.data = getSum(node.right);
		
		nodeGetSumGreater(node.left);
		nodeGetSumGreater(node.right);
	}
	
	private static int getSum(TreeNode node)
	{
		int sum = 0;
		while(node!=null)
		{
			sum = sum + node.data;
			node = node.right;
		}
			
		return sum;
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 0, 1, 3, 4, 7, 8 ,10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		nodeGetSumGreater(root);
		BTreePrinter.printNode(root);
	}
}
