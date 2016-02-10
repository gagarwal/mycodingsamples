import java.util.LinkedList;
import java.util.List;

import helper.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class GenerateUniqueBinaryTrees {

	public static void main(String args[]) {
		List<TreeNode> trees = generateTrees(3);
		
		for(TreeNode treeNode : trees)
		{
			treeNode.print();
		}
	}

	public static List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new LinkedList<TreeNode>();
		return generateTrees(1, n);
	}

	public static List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new LinkedList<>();

		if (start > end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = generateTrees(start, i - 1);
			List<TreeNode> rights = generateTrees(i + 1, end);
			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		return list;
	}

}