
public class LinkedListPrintInReverse
{
	public static void main(String[] args)
	{
		LinkedListNode lA1 = new LinkedListNode(2, null, null);
		LinkedListNode lA2 = new LinkedListNode(3, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

		printLinkedListBackward(lA1);
	}

	public static void printLinkedListBackward(LinkedListNode node)
	{
		if (node == null)
			return;
		
		printLinkedListBackward(node.next);
		System.out.println(node.data);
	}
}
