import helper.BTreePrinter;
import helper.TreeNode;

public class FindLCA 
{
	@SuppressWarnings("unused")
	private static TreeNode findLCAWithOutLinkToParents(TreeNode nodeN1, TreeNode nodeN2, TreeNode root) 
	{
		if(root == null || nodeN1 == null || nodeN2 == null) // if either of the node is null or root is null
			return null;
		
		if(nodeN1 == root || nodeN2 == root) // if any of the node is root
			return root;
		
		TreeNode left = findLCAWithOutLinkToParents(nodeN1, nodeN2, root.left);
		TreeNode right = findLCAWithOutLinkToParents(nodeN1, nodeN2, root.right);
		
		if(left == null && right == null)
			return null;
		
		if(left!= null && right!=null)
			return root;
		
		return (left == null ? right : left);
	}

	@SuppressWarnings("unused")
	private static TreeNode findLCAWithLinkToParents(TreeNode nodeN1, TreeNode nodeN2, TreeNode root)
	{
		if(root == null || nodeN1 == null || nodeN2 == null) // if either of the node is null or root is null
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

	private static int getHeightWithParent(TreeNode node)
	{
		int height = 0;
		while (node!=null)
		{
			height++;
			node = node.parent;
		}
		return height;
	}
	
	public static TreeNode lowestCommonAncestorBinarySearchTree( TreeNode p, TreeNode q, TreeNode root)
	{
		if(root == null)
			return null;
	            
	    if(p == root || q == root)
	        return root;
	        
	    if(p == null || q == null)
	            return null;
	        
	    if(root.data > p.data && root.data < q.data)
	        return root;  
	    
	    else if(root.data > p.data && root.data > q.data)
	        return lowestCommonAncestorBinarySearchTree(p, q, root.left);
	    
	    else 
	        return lowestCommonAncestorBinarySearchTree(p, q, root.right);
	}
	 

	public static void main(String[] args) {
		int[] array = { 2 };
		TreeNode root = TreeNode.createMinimalBST(array);
		root.setLeftChild(new TreeNode(1));
		BTreePrinter.printNode(root);
		
		int n1 = 2; int n2 = 1;
		
		TreeNode nodeN1 = root.find(n1);
		TreeNode nodeN2 = root.find(n2);

		TreeNode lca = lowestCommonAncestorBinarySearchTree(nodeN2, nodeN1, root);
		
		if(lca!=null)
			System.out.println(lca.data);
	}
}
