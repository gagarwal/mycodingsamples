package helper;

import java.util.Stack;

public class InorderIterative
{
	private static void inorderTraversalIterative(TreeNode root)
	{
		if(root == null) return;
			
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		
		while(!nodes.isEmpty() || root!=null)
		{
			if(root != null)
			{
				nodes.push(root);
				root = root.left;
			}
			else {
					TreeNode temp = nodes.pop();
					System.out.print(temp.data + " ");
					root = temp.right;
				}
		}
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 0, 1, 3, 4, 7, 8 ,10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		inorderTraversalIterative(root);
	}
}
