import helper.TreeNode;

public class ReplaceNodeValueWithHigherNumbersInTheTree
{
	public static int sumAllNodes(TreeNode node)
	{
		if(node == null) return 0;
		return node.data + sumAllNodes(node.left) + sumAllNodes(node.right);
	}
	
	public static void replaceNodeValueWithHigherNumbersInTheTree(TreeNode node, int total, TreeNode root)
	{
		if(node == null) return;
		
		int leftSum = sumAllNodes(node.left);
		int currentData = node.data;
		node.data = total - leftSum - currentData;
		
		replaceNodeValueWithHigherNumbersInTheTree(node.right, node.data, root);
		replaceNodeValueWithHigherNumbersInTheTree(node.left, total , root);
	}
	
	public static void main(String[] args) {
		int[] array = { 0, 1, 3, 4, 7, 8 ,10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		int sumTotal = sumAllNodes(root);
		replaceNodeValueWithHigherNumbersInTheTree(root, sumTotal, root);
	}
}
