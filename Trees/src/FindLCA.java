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
	
	public static TreeNode commonAncestorWithLinkToParents(TreeNode root, TreeNode p, TreeNode q) 
	{
		if ((p == null) || (q == null)) 
			return null;
		
		TreeNode ap = p.parent;
		while (ap != null)
		{
			TreeNode aq = q.parent;
			while (aq != null)
			{ 
				if (aq == ap) 
				{
					return aq;
				}
				aq = aq.parent;
			}
			ap = ap.parent;
		}
		return null;
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
	
	private static TreeNode findLCAWhile(TreeNode root, int v1, int v2)
	{
	      if (root == null) return null;
	 
	      if (v1 > v2)
	      {          
	        int temp = v2;
	        v2 = v1;
	        v1 = temp;
	       }
	    
	      while (root.data < v1 || root.data > v2)
	      {
	        if (root.data < v1) 
	            root = root.right;
	        else if (root.data > v2) 
	            root = root.left;
	       }       
	       return root;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] array = {5, 3, 6, 1, 9, 11};
		TreeNode root = new TreeNode(20);
		for (int a : array) {
			root.insertInOrder(a);
		}
		BTreePrinter.printNode(root);
		TreeNode n1 = root.find(5);
		TreeNode n9 = root.find(1);
		TreeNode ancestor = commonAncestorWithLinkToParents(root, n1, n9);
		System.out.println(ancestor.data);
	}
}
