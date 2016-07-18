import java.util.LinkedList;
import java.util.Queue;

import helper.BTreePrinter;
import helper.TreeNode;

public class CreateBinaryTreeFromLevelOrderTraversal
{
	private static TreeNode CreateTreeFromLevelOrderTraversal(int[] input)
	{
		if(input.length == 0) return null;
		if(input[0] == '#') return null;
		
		Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(input[0]);
		nodesQueue.add(root);
		int index = 1;
		
		while(!nodesQueue.isEmpty() && index < input.length)
		{
			Queue<TreeNode> tempNodesQueue = new LinkedList<TreeNode>();
			while(!nodesQueue.isEmpty() && index < input.length)
			{
				TreeNode current = nodesQueue.poll();
				if(input[index]!='#')
				{
					TreeNode leftChild = new TreeNode(input[index]);
					current.setLeftChild(leftChild);
					tempNodesQueue.add(leftChild);
				}
				index++;
				if(input[index]!='#')
				{
					TreeNode rigthNode = new TreeNode(input[index]);
					current.setRightChild(rigthNode);
					tempNodesQueue.add(rigthNode);
				}
				index++;
			}
			nodesQueue = tempNodesQueue;
		}
		return root;
	}
	
	public static void main(String[] args) {
		int[] array = { 1,2,'#',4,5,6,'#'};
		TreeNode root = CreateTreeFromLevelOrderTraversal(array);
		BTreePrinter.printNode(root);
	}
}
