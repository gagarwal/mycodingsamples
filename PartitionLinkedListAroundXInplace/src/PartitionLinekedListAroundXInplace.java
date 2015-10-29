
public class PartitionLinekedListAroundXInplace {
	static LinkedListNode head = null;
	LinkedListNode tail = null;
	int length = 0;

	public static void main(String args[]) {
		PartitionLinekedListAroundXInplace list = new PartitionLinekedListAroundXInplace();
		list.addNode(15);
		list.addNode(53);
		list.addNode(450);
		list.addNode(30);
		list.addNode(20);

		list.print(head);
		System.out.println();
		System.out.println();
		head = list.partitionLinekedListAroundXInplace2(head, 50);
		list.print(head);
	}

	private LinkedListNode partitionLinekedListAroundXInplace2(LinkedListNode node, int value) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;

		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < value) {
				/* Insert node into start of before list */
				node.next = beforeStart;
				beforeStart = node;
			//	print(node);
			} else {
				/* Insert node into front of after list */
				node.next = afterStart;
				afterStart = node;
				//print(afterStart);
				//print(node);
			}
			node = next;
		}

		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}

		LinkedListNode head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}

	private LinkedListNode partitionLinekedListAroundXInplace(LinkedListNode head1, int value) {
		if (head == null)
			return null;

		LinkedListNode fakeHead1 = new LinkedListNode(0);
		LinkedListNode fakeHead2 = new LinkedListNode(0);
		fakeHead1.next = head;

		LinkedListNode p = head;
		LinkedListNode prev = fakeHead1;
		LinkedListNode p2 = fakeHead2;

		while (p != null) {
			if (p.data < value) {
				p = p.next;
				prev = prev.next;
			} else {

				p2.next = p;
				prev.next = p.next;

				p = prev.next;
				p2 = p2.next;
			}
		}
		// close the list
		p2.next = null;

		prev.next = fakeHead2.next;

		return fakeHead1.next;
		// if(head == null) return head;
		// LinkedListNode prev = null;
		// LinkedListNode current = head;
		// while(current != null){
		// if(current.data > value || current == head){
		// prev = current;
		// current = current.next;
		// }
		// else{
		// LinkedListNode next = current.next;
		// current.next = head;
		// if(prev != null) {
		// prev.next = next;
		// }
		// head = current;
		// current = next;
		// }
		// }
		// return head;
	}

	public void print(LinkedListNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public void addNode(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		if (PartitionLinekedListAroundXInplace.head == null) {
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
		private int data;

		public LinkedListNode(int d) {
			this.data = d;
		}

		public int getData() {
			return data;
		}
	}
}