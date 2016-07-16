import java.util.LinkedList;
import java.util.Queue;

import helper.BTreePrinter;
import helper.TreeNode;

public class LeverOrderTraversalLevelByLevel
{
	private static void levelOrderTraversalLevelByLevel(TreeNode root)
	{
		if(root == null) return;
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root);
		
		while(!nodeQueue.isEmpty())
		{
			Queue<TreeNode> tempNodeQueue = new LinkedList<TreeNode>();
			while(!nodeQueue.isEmpty())
			{
				TreeNode temp = nodeQueue.poll();
				System.out.print(temp.data + " ");
				
				if(temp.left!=null)
					tempNodeQueue.add(temp.left);
				
				if(temp.right!=null)
					tempNodeQueue.add(temp.right);
			}
			nodeQueue = tempNodeQueue;
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 0, 1, 3, 4, 7, 8 ,10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		levelOrderTraversalLevelByLevel(root);
	}
}
