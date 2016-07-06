import helper.TreeNode;

public class PrintPathsFromRootToNode
{
	public static void printPathsFromRootToLeaf(TreeNode node, int[] array, int length)
	{
		if(node == null) return;
		
		array[length] = node.data;
		
		length++;
		
		if(node.left == null && node.right == null)
			print(array, length);
		
		printPathsFromRootToLeaf(node.left, array, length);
		printPathsFromRootToLeaf(node.right, array, length);
	}

	private static void print(int[] array, int length) 
	{
		for(int i = 0; i < length; i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
}
