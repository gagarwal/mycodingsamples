public class DeleteKthNodeFromLinkedListKthNodeGiven {
	static LinkedListNode head;
	LinkedListNode tail;
	int length = 0;

	public static void main(String args[]) {
		DeleteKthNodeFromLinkedListKthNodeGiven list = new DeleteKthNodeFromLinkedListKthNodeGiven();
		list.addNode(1);
		list.addNode(1);
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(2);

		list.print();
		System.out.println();
		deleteKthNode(head);
		list.print();
	}

	public void print() {
		LinkedListNode n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	// Get the 'next' node, copy data from 'next' to 'current', delete 'next'
	public static boolean deleteKthNode(LinkedListNode kthNode) {
		if(kthNode == null || kthNode.next == null)
			return false;
		LinkedListNode nextNode = kthNode.next;
		kthNode.data = nextNode.data;
		kthNode.next = nextNode.next;
		return true;
	}

	public void addNode(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		if (DeleteKthNodeFromLinkedListKthNodeGiven.head == null) {
			head = newNode;
			tail = newNode;
			head.next = null;
			length++;
		} else {
			tail.next = newNode;
			newNode.next = null;
			tail = newNode;
		}
	}

	private class LinkedListNode {
		LinkedListNode next;
		int data;

		public LinkedListNode(int d) {
			this.data = d;
		}
		
		
	}
}