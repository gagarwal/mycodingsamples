package helper;

import java.util.Stack;

public class InorderIterative
{
	public static void inorderTraversalIterative(TreeNode root)
	{
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        
        while(true)
        {
            if(node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                	if(stack.isEmpty())
                		break;

                	node = stack.pop();
                	System.out.println(node.data);
                	node = node.right;
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
