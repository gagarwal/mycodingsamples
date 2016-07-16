import java.util.LinkedList;
import java.util.Queue;

import helper.BTreePrinter;
import helper.TreeNode;

public class LevelOrderTraversal 
{
	private static void levelOrderTraversal(TreeNode root)
	{
		if(root == null) return;

		Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
		nodesQueue.add(root);
		
		while(!nodesQueue.isEmpty())
		{
			TreeNode node = nodesQueue.poll();
			System.out.println(node.data);
			
			if(node.left!=null)
				nodesQueue.add(node.left);
			if(node.right!=null)
				nodesQueue.add(node.right);
		}
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 0, 1, 3, 4, 7, 8 ,10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		levelOrderTraversal(root);
	}
}
