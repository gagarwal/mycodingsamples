import helper.BTreePrinter;
import helper.TreeNode;

public class FindLCA {
	private static void findLCAWithOutLinkToParents() {

	}

	private static TreeNode findLCAWithLinkToParents(TreeNode nodeN1, TreeNode nodeN2, TreeNode root)
	{
		if(nodeN1 == null || nodeN2 == null) // if either of the node is null
			return null;
		
		if(nodeN1 == nodeN2) // if both are null
			return nodeN1;
		
		if(nodeN1 == root || nodeN2 == root) // if any of the node is root
			return root;
		
		int heightN1 = getHeightWithParent(nodeN1);
		int heightN2 = getHeightWithParent(nodeN2);

		// make heightN2 the deeper node
		if (heightN1 > heightN2)
		{
			int tempHeight = heightN2;
			heightN2 = heightN1;
			heightN1 = tempHeight;

			TreeNode tempNode = nodeN1;
			nodeN1 = nodeN2;
			nodeN2 = tempNode;
		}
		
		int heightDifference = heightN2 - heightN1;
		
		for(int i = 0; i < heightDifference ; i++)
				nodeN2 = nodeN2.parent;
		
		while (nodeN1!=null && nodeN2 != null)
		{
		    if (nodeN1 == nodeN2) 
		    	return nodeN1;
		    nodeN1 = nodeN1.parent;
		    nodeN2 = nodeN2.parent;
		 }
		 return null;
	}

//	private static int getHeight(TreeNode node) {
//		if (node == null)
//			return 0;
//		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
//	}

	static int getHeightWithParent(TreeNode node)
	{
		int height = 0;
		while (node!=null) {
			height++;
			node = node.parent;
		}
		return height;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] array = { 0, 1, 3, 4, 7, 8, 10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		BTreePrinter.printNode(root);
		
		int n1 = 0; int n2 = 18;
		
		TreeNode nodeN1 = root.find(n1);
		TreeNode nodeN2 = root.find(n2);

		TreeNode lca = findLCAWithLinkToParents(nodeN1, nodeN2, root);
		if(lca!=null)
			System.out.println(lca.data);
	}
}
