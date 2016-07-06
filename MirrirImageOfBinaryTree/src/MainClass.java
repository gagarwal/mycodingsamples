import helper.AssortedMethods;
import helper.TreeNode;

public class MainClass {
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = TreeNode.createMinimalBST(array);
		//System.out.println("Root? " + root.data);
		

		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(3);
		for (int i = 0; i < 3; i++)
		{
			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
		}
		helper.BTreePrinter.printNode(root);

		int[] test = new int[9];
		System.out.println(CountLeafNodes.countLeafodes(root));
	}
}
