import java.util.IllegalFormatWidthException;

public class TrinaryTree {
	private class Node {
		private int val;
		private Node left = null;
		private Node right = null;
		private Node mid = null;

		Node(int val) {
			this.val = val;
		}
	}

	private Node root;

	public void insert(int val) {
		root = insert(root, val);
	}

	private Node insert(Node node, int val)
	{
		if (node == null)
			node = new Node(val);
		
	    else if (val < node.val)
			node.left = insert(node.left, val);
		
		else if (val == node.val)
			node.mid = insert(node.mid, val);
		
		else
			node.right = insert(node.right, val);
		
		return node;
	}

	public void delete(int val)
	{
		root = delete(root, val);
	}
	
	private Node delete(Node node, int val)
	{
		if(node == null) 
			return null;
		
		else if(val < node.val)
			node.left = delete(node.left, val);
		
		else if(val > node.val)
			node.right = delete(node.right, val);
		
		else 
		{
			if(node.mid!=null)
				node.mid = delete(node.mid, val);
			else
			{
				if(node.left == null && node.right == null)
					return null;
				
				else if(node.left == null)
					return node.right; 
				
				else if(node.right == null)
					return node.left;
				
				else  // it has left and right children
				{
					Node current = node;
					current.val = findMin(current).val;
					node.right = delete(current.right, current.val);
					node.left = current.left;
				}
								
			}
		}
		
		return node;
	}

	private Node findMin(Node node) 
	{
		while (node.left != null)
			node = node.left;
		while (node.mid != null)
			node = node.mid;
		return node;
	}

	public Node findNode(int val) {
		Node previous = null;
		Node current = root;

		while (current != null)
		{
			if (val < current.val)
				current = current.left;
			else if (val > current.val)
				current = current.right;
			else if (val == current.val)
				return previous;
			else current = current.mid;
		}
		
			return null;
	}

	public void print() {
		print(root);
	}

	public void print(Node node) {
		if (node == null)
			return;

		System.out.println(node.val);

		print(node.left);
		print(node.mid);
		print(node.right);

	}

	public static void main(String args[]) {
		
		double test = 8000000000d;
		long test2=  9223372036854775807L;
		
		TrinaryTree tree = new TrinaryTree();
		tree.insert(7);
		tree.insert(10);
		tree.insert(10);
//		tree.insert(2);
//		tree.insert(4);
//		tree.insert(6);
//		tree.insert(5);
//		tree.insert(6);
//		tree.insert(6);
//		tree.insert(6);
		
		tree.delete(10);

	}
}
