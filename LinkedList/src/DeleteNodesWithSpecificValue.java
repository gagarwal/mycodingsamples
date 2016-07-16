
public class DeleteNodesWithSpecificValue
{
	private static LinkedListNode deleteNodesWithSpecificValue(LinkedListNode head, int key)
	{
		if((head == null) || (head.next == null && head.data == key))
		{	
			head = null;
			return null;
		}	
				
		LinkedListNode newHead = head;
		LinkedListNode previous = head;
		LinkedListNode current = head.next;

		while(current != null)
		{
			if(current.data == key)
				previous.next = current.next;
			else
				previous = current;
			
			current = current.next;
		}
		
		return newHead;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode lA1 = new LinkedListNode(2, null, null);
		LinkedListNode lA2 = new LinkedListNode(3, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		LinkedListNode lA4 = new LinkedListNode(3, null, lA3);
		
		System.out.println(lA1.printForward());
		
		LinkedListNode newHead = deleteNodesWithSpecificValue(lA1, 3);

		System.out.println(newHead.printForward());
	}
}
