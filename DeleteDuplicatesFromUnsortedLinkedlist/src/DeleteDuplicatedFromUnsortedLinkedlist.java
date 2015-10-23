import java.util.Hashtable;

public class DeleteDuplicatedFromUnsortedLinkedlist {
	LinkedListNode head;
	LinkedListNode tail;
	int length = 0;

	public static void main(String args[]) {
		DeleteDuplicatedFromUnsortedLinkedlist list = new DeleteDuplicatedFromUnsortedLinkedlist();
		list.addNode(1);
		list.addNode(1);
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(2);

		list.print();
		list.deleteDupsNoStorage(list.head);
		System.out.println();
		list.print();
	}

	public void print() {
		LinkedListNode n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public void deleteDups(LinkedListNode head) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		LinkedListNode prev = null;

		while (head != null) {
			if (table.containsKey(new Integer(head.data))) {
				prev.next = head.next; // skip the previously stored references
									// next node
			} else {
				table.put(new Integer(head.data), true);
				prev = head; // stores a reference to n
			}

			head = head.next;
		}
	}

	public void deleteDupsNoStorage(LinkedListNode n) {
		LinkedListNode current = n;

		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}

	}

	public void addNode1(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		if (this.head == null) {
			this.head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void addNode(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		if (this.head == null) {
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