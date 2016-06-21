
public class LinkedListReversalRecursion {
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(2, null, null);
		LinkedListNode lA2 = new LinkedListNode(3, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

		System.out.println(reverseLinkedListRecursion(lA1).printForward());
	}

	public static LinkedListNode reverseLinkedListRecursion(LinkedListNode node)
	{
		LinkedListNode reverseHead = null;
		
		if (node.next == null)
		{
			reverseHead = node;
			return reverseHead;
		}

		reverseHead = reverseLinkedListRecursion(node.next);

		LinkedListNode nextNode = node.next;
		nextNode.next = node;
		node.next = null;

		return reverseHead;
	}
}
