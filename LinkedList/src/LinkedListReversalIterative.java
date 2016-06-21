
public class LinkedListReversalIterative {
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(2, null, null);
		LinkedListNode lA2 = new LinkedListNode(3, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);

		System.out.println(reverseLinkedListIterative(lA1).printForward());
	}

	public static LinkedListNode reverseLinkedListIterative(LinkedListNode head)
	{
		LinkedListNode current = head;
		LinkedListNode previous = null;
		LinkedListNode next;
		
		while(current!=null)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
	
		return previous;
	}
}
