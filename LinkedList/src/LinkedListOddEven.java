
public class LinkedListOddEven
{
	private static LinkedListNode oddEvenLinkedListNode(LinkedListNode head)
	{
		if(head == null || head.next == null)
			return head;
		
		LinkedListNode odd = head;
		LinkedListNode even = head.next;
		LinkedListNode evenHead = head.next;
		
		while(even != null && even.next != null)
		{
			odd.next = even.next;
			odd = odd.next;
			
			even.next = odd.next;
			even = even.next;
		}	
		
		odd.next = evenHead;
		
		return head;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode lA1 = new LinkedListNode(2, null, null);
		LinkedListNode lA2 = new LinkedListNode(3, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		LinkedListNode lA4 = new LinkedListNode(3, null, lA3);

		System.out.println(lA1.printForward());

		LinkedListNode newHead = oddEvenLinkedListNode(lA1);
		System.out.println(newHead.printForward());
	}
}
