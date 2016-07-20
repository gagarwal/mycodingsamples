import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import helper.BTreePrinter;
import helper.TreeNode;

public class BinaryTreeTopView 
{
	private static void printTopView(TreeNode root)
	{
	  if(root == null)
	      return;
	   
	  Queue<Integer> rightView = new LinkedList<Integer>();
	  Stack<Integer> leftView = new Stack<Integer>();
	   
	  TreeNode leftNode = root;
	  TreeNode rightNode = root.right; 
	  
	  while(leftNode!=null || rightNode!=null)
	  {
	      if(leftNode!=null)
	      {
	          leftView.push(leftNode.data);
	          leftNode = leftNode.left;
	      } 
	      if(rightNode!=null)
	      {
	          rightView.offer(rightNode.data);
	          rightNode = rightNode.right;
	      }    
	  }   
	  
	  while(!leftView.isEmpty())
		  System.out.print(leftView.pop()+" ");
	  
	  while(!rightView.isEmpty())
		  System.out.print(rightView.poll()+" ");
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 0, 1, 3, 4, 7, 8  };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		printTopView(root);
	}
}
