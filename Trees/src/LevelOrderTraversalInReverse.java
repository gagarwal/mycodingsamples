import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import helper.BTreePrinter;
import helper.TreeNode;

public class LevelOrderTraversalInReverse
{
	private static void printLevelOrderTraversal(TreeNode node)
	{
		if(node == null) return;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		queue.offer(node);
		
		while(!queue.isEmpty())
		{
			TreeNode current = queue.poll();
			
			if(current.right!=null)
				queue.offer(current.right);
			
			if(current.left!=null)
				queue.offer(current.left);
			
			stack.push(current);
		}	
	   
		while(!stack.isEmpty())
			System.out.print(stack.pop().data + " ");
	}
	
	public static void main(String[] args)
	{
		int[] array = { 0, 1, 3, 4, 7, 8 ,10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		printLevelOrderTraversal(root);
	}
}
