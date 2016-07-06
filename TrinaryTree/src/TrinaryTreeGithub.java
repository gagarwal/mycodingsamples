import java.util.LinkedList;

public class TrinaryTreeGithub<T extends Comparable<T>> {

	private class Node {
		private T value;
		private Node left;
		private Node mid;
		private Node right;

		public Node(T value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	private Node root;

	public TrinaryTreeGithub() {
		root = null;
	}

	public void insert(T value) {
		root = insert(root, value);
	}

	private Node insert(Node node, T value) {
		if (node == null) {
			Node n = new Node(value);
			return n;
		}
		int comp = value.compareTo(node.value);
		if (comp < 0)
			node.left = insert(node.left, value);
		else if (comp > 0)
			node.right = insert(node.right, value);
		else 
			node.mid = insert(node.mid, value);
		return node;

	}

	public void delete(T value) {
		root = delete(root, value);
	}

	private Node delete(Node node, T value) {
		if (node == null)
			return null;
		int comp = value.compareTo(node.value);
		if (comp < 0)
			node.left = delete(node.left, value);
		else if (comp > 0)
			node.right = delete(node.right, value);
		else {
			if (node.mid != null)
				node.mid = delete(node.mid, value);
			else {
				if (node.left == null)
					return node.right;
				if (node.right == null)
					return node.left;
				//if has both left and right children
				Node current = node;
				//find successor
				Node minNode = findMin(current.right);
				current.value = minNode.value;
				node.right = delete(node.right, minNode.value);
			}
		}
		return node;
	}

	private Node findMin(Node node) {
		while (node.left != null)
			node = node.left;
		while (node.mid != null)
			node = node.mid;
		return node;
	}

	//when delete min, first find if there is duplicate key
	//if found, delete duplicate, otherwise, delete that node
	private Node deleteMin(Node node) {
		if (node.left == null)
			return deleteMid(node);
		node.left = deleteMin(node.left);
		return node;
	}

	//delete duplicates
	private Node deleteMid(Node node) {
		if (node.mid == null)
			return node.right;
		node.mid = deleteMid(node.mid);
		return node;

	}

	//for test use

	/*
	 * specification of serialize:
	 * 
	 * The function serialize the trinary tree by using level order traversal, # indicate null,
	 * all nodes with less then 3 children will be followed by # for each null children, except
	 * for nodes in deepest level
	 */
	public String serialize() {
		return serialize(root);
	}

	private String serialize(Node root) {
		String str = "";
		LinkedList<Node> parent = new LinkedList<Node>();
		parent.add(root);
		boolean end = false;
		while (!end) {
			end = true;
			int size = parent.size();
			for (int i = 0; i < size; i++) {
				Node temp = parent.removeFirst();
				str += temp == null? "#": temp.value;
				str += ",";
				if (temp == null)
					continue;
				if (!isLeaf(temp))
					end = false;
				parent.add(temp.left);
				parent.add(temp.mid);
				parent.add(temp.right);
			}
		}
		return str.substring(0, str.length() - 1);
	}

	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null && node.mid == null;
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	
	/*
	 * 
	 * Test Cases
	 *
	 */

	//test insert without duplicate
	private static void test1() {
		TrinaryTreeGithub<Integer> t = new TrinaryTreeGithub<Integer>();
		t.insert(10);
		t.insert(5);
		t.insert(15);
		t.insert(3);
		t.insert(7);
		t.insert(8);
		t.insert(9);
		t.insert(13);
		t.insert(14);
		t.insert(18);
		t.insert(16);
		//expected result after insertion
		String res = "10,5,#,15,3,#,7,13,#,18,#,#,#,#,#,8,#,#,14,16,#,#,#,#,9,#,#,#,#,#,#";
		if (res.equals(t.serialize()))
			System.out.println("Test Case 1 passed!");
		else 
			System.out.println("Test Case 1 failed...");
	}

	//test delete without duplicate
	private static void test2() {
		TrinaryTreeGithub<Integer> t = new TrinaryTreeGithub<Integer>();
		t.insert(17);
		t.insert(10);
		t.insert(22);
		t.insert(5);
		t.insert(13);
		t.insert(19);
		t.insert(27);
		t.insert(4);
		t.insert(11);
		t.insert(14);
		t.insert(18);
		t.insert(20);
		t.insert(29);
		t.insert(3);
		t.insert(28);
		//expected result after insertion
		String res = "17,10,#,22,5,#,13,19,#,27,4,#,#,11,#,14,18,#,20,#,#,29,"
				+ "3,#,#,#,#,#,#,#,#,#,#,#,#,#,#,28,#,#";
		if (!res.equals(t.serialize())) {
			System.out.println("Test Case 2 failed...");
			return;
		}

		t.delete(10);
		//expected result after delete 10
		res = "17,11,#,22,5,#,13,19,#,27,4,#,#,#,#,14,18,#,20,#,#,29,3,#,#,#,#,#,#,#,#,#,#,#,28,#,#";
		if (!res.equals(t.serialize())) {
			System.out.println("Test Case 2 failed...");
			return;
		}

		t.delete(28);
		//expected result after delete 28
		res = "17,11,#,22,5,#,13,19,#,27,4,#,#,#,#,14,18,#,20,#,#,29,3,#,#,#,#,#,#,#,#,#,#,#,#,#,#";
		if (!res.equals(t.serialize())) {
			System.out.println("Test Case 2 failed...");
			return;
		}

		t.delete(27);
		//expected result after delete 27
		res = "17,11,#,22,5,#,13,19,#,29,4,#,#,#,#,14,18,#,20,#,#,#,3,#,#,#,#,#,#,#,#,#,#,#";
		if (!res.equals(t.serialize())) {
			System.out.println("Test Case 2 failed...");
			return;
		}

		t.delete(5);
		t.delete(19);
		t.delete(17);
		//expected result after multiple deletions
		res = "18,11,#,22,4,#,13,20,#,29,3,#,#,#,#,14,#,#,#,#,#,#";
		if (!res.equals(t.serialize()))
			System.out.println("Test Case 2 failed...");
		else
			System.out.println("Test Case 2 passed!");

	}

	//test insert with duplicates
	public static void test3() {
		TrinaryTreeGithub<Integer> t = new TrinaryTreeGithub<Integer>();
		t.insert(27);
		t.insert(15);
		t.insert(33);
		t.insert(7);
		t.insert(22);
		t.insert(30);
		t.insert(39);
		t.insert(27);
		t.insert(27);
		t.insert(15);
		t.insert(7);
		t.insert(9);
		t.insert(22);
		t.insert(31);
		t.insert(35);
		t.insert(39);
		t.insert(8);
		t.insert(9);
		t.insert(22);
		t.insert(30);
		t.insert(30);
		//expected result after insertion
		String res = "27,15,27,33,7,15,22,#,27,#,30,#,39,#,7,9,#,#,#,#,22,#,#,#,#,#,30,31,35,39,"
				+ "#,#,#,#,8,9,#,#,22,#,#,30,#,#,#,#,#,#,#,#,#,#";
		if (!res.equals(t.serialize()))
			System.out.println("Test Case 3 failed...");
		else
			System.out.println("Test Case 3 passed!");
	}

	//test delete with duplicates
	public static void test4() {
		TrinaryTreeGithub<Integer> t = new TrinaryTreeGithub<Integer>();
		t.insert(27);
		t.insert(15);
		t.insert(33);
		t.insert(7);
		t.insert(22);
		t.insert(30);
		t.insert(39);
		t.insert(27);
		t.insert(27);
		t.insert(15);
		t.insert(7);
		t.insert(9);
		t.insert(22);
		t.insert(31);
		t.insert(35);
		t.insert(39);
		t.insert(8);
		t.insert(9);
		t.insert(22);
		t.insert(30);
		t.insert(30);
		//expected result after deletion
		String res = "27,15,27,33,7,15,22,#,27,#,30,#,39,#,7,9,#,#,#,#,22,#,#,#,#,#,30,31,35,39,"
				+ "#,#,#,#,8,9,#,#,22,#,#,30,#,#,#,#,#,#,#,#,#,#";
		if (!res.equals(t.serialize())){
			System.out.println("Test Case 4 failed...");
			return;
		}

		//delete 27
		t.delete(27);
		//expected result after delete 27
		res = "27,15,27,33,7,15,22,#,#,#,30,#,39,#,7,9,#,#,#,#,22,#,#,30,31,35,39,"
				+ "#,#,#,#,8,9,#,#,22,#,#,30,#,#,#,#,#,#,#,#,#,#";
		if (!res.equals(t.serialize())){
			System.out.println("Test Case 4 failed...");
			return;
		}

		//delete 7
		t.delete(7);
		//expected result after delete 7
		res = "27,15,27,33,7,15,22,#,#,#,30,#,39,#,#,9,#,#,#,#,22,#,#,30,31,35,39,"
				+ "#,8,9,#,#,22,#,#,30,#,#,#,#,#,#,#,#,#,#";
		if (!res.equals(t.serialize())){
			System.out.println("Test Case 4 failed...");
			return;
		}

		//multiple deletions
		t.delete(22);
		t.delete(27);
		t.delete(27);
		//expected result after delete 7
		res = "30,15,#,33,7,15,22,30,#,39,#,#,9,#,#,#,#,22,#,#,30,31,35,39,"
				+ "#,8,9,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#,#";
		if (!res.equals(t.serialize()))
			System.out.println("Test Case 4 failed...");
		else 
			System.out.println("Test Case 4 passed");
	}
}