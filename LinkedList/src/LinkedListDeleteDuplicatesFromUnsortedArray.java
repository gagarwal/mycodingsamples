import java.util.HashSet;
import java.util.Set;

public class LinkedListDeleteDuplicatesFromUnsortedArray 
{
	public static LinkedListNode removeDuplicatesUsingHashSet(LinkedListNode head)
    {
        if(head == null) return null;
        
        LinkedListNode previous = head;
        LinkedListNode current = head.next;
        
        Set<Integer> nodes = new HashSet<Integer>();
        nodes.add(previous.data);
        
        while(current!=null)
        {
            if(nodes.contains(current.data))
                previous.next = current.next;
            else 
                {
                    previous = current;
                    nodes.add(current.data);
                }
            
            current = current.next;
        }
        return head;
    }
	
	private static LinkedListNode removeDuplicatesRunnerMethod(LinkedListNode head)
	{
		if(head == null)  return null;
		LinkedListNode current = head;
		
		while(current!=null)
		{
			LinkedListNode after = current.next;
			while(after !=null)
			{
				if(current.data == after.data)
					current.next = after.next;
				after = after.next;
			}	
			current = current.next;
		}	
		
		return head;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(2, null, null);
		LinkedListNode lA2 = new LinkedListNode(3, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(9, null, lA2);
		LinkedListNode lA4 = new LinkedListNode(3, null, lA3);

		System.out.println(lA1.printForward());

		LinkedListNode newHead = removeDuplicatesUsingHashSet(lA1);
		System.out.println(newHead.printForward());
		
		 newHead = removeDuplicatesRunnerMethod(lA1);
		System.out.println(newHead.printForward());
	}
}
