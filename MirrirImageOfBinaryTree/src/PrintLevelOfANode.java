import helper.TreeNode;

public class PrintLevelOfANode 
{
	public static int getLevelOfNode(TreeNode node, int level, int key)
	{
		if(node == null) return 0;
		
		if(node.data == key) return level;
		
		int result = getLevelOfNode(node.left, level+1, key);
		
		if(result != 0) return level;
		
		result = getLevelOfNode(node.right, level+1, key);
		
		return result;
	}
}
