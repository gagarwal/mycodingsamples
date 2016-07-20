import helper.BTreePrinter;
import helper.TreeNode;

public class InorderSuccessor 
{
	private static TreeNode findInorderSuccessor(TreeNode node, TreeNode root)
	{
		if(node == null) return null;
		
		if(node.right != null)
			return findMin(node.right);
		
		else return getSuccessor(node, root);
	}

	private static TreeNode findMin(TreeNode node) 
	{
		if(node == null) return null;
		
		while(node.left!=null)
			node = node.left;
				
		return node;
	}
	
	private static TreeNode getSuccessor(TreeNode current, TreeNode root)
	{
		TreeNode ancestor = root;
		TreeNode successor = null;
		while(ancestor != current)
		{
			if(current.data < root.data)
			{
				successor = ancestor;
				ancestor = ancestor.left;
			}
			else ancestor = ancestor.right;
		}
		return successor;
	}
	
	public static void main(String[] args)
	{
		// Create balanced tree
		int[] array = { 0, 1, 3, 4, 7, 8 ,10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		System.out.println(findInorderSuccessor(root.right, root).data);
	}
}
