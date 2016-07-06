import java.util.Stack;

import helper.BTreePrinter;
import helper.TreeNode;

public class HeightOfTreeIterative {

	public static int getHeightOfTree(TreeNode node)
	{
		if (node == null)
			return 0;
		
		Stack<TreeNode> nodesStack = new Stack<TreeNode>();
		nodesStack.push(node);
		
		int height = 0;

		while (!nodesStack.isEmpty())
		{
			height++;
			Stack<TreeNode> nodesTempStack = new Stack<TreeNode>();

			while (!nodesStack.isEmpty())
			{
				TreeNode tempNode = nodesStack.pop();
				if (tempNode.left != null)
					nodesTempStack.push(tempNode.left);
				if (tempNode.right != null)
					nodesTempStack.push(tempNode.right);
			}
			
			nodesStack = nodesTempStack;

		}
		return height;
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 0, 1, 3, 4 };
		TreeNode root = TreeNode.createMinimalBST(array);

		System.out.println("Is balanced? " + getHeightOfTree(root));

		root.insertInOrder(4); // Add 4 to make it unbalanced

		System.out.println("Is balanced? " + getHeightOfTree(root));
		
		BTreePrinter.printNode(root);
	}
}
