import helper.LinkedListNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class SwapPairsRecursively {

	public static void main(String args[]) {

		/* Create linked list */
		int[] vals = { 1, 3, 7, 5, 2, 9, 4 };
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());

		swapPairwiseIteratively(head);

		System.out.println(swapPairwiseIteratively(head).printForward());
	}

	public static LinkedListNode swapPairwiseIteratively(LinkedListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		LinkedListNode fakehead = new LinkedListNode(-1, null, null);

		fakehead.next = head;

		LinkedListNode ptr1 = fakehead;

		LinkedListNode ptr2 = head;

		while (ptr2 != null && ptr2.next != null) {
			
			LinkedListNode nextstart = ptr2.next.next;

			ptr2.next.next = ptr2;

			ptr1.next = ptr2.next;

			ptr2.next = nextstart;

			ptr1 = ptr2;

			ptr2 = ptr2.next;
		}

		return fakehead.next;

	}
}