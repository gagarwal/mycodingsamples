import java.util.Hashtable;

public class GetKthNodeFromLastLinkedList {
	static LinkedListNode head = null;
	LinkedListNode tail = null;
	int length = 0;

	public static void main(String args[]) {
		GetKthNodeFromLastLinkedList list = new GetKthNodeFromLastLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);

		list.print();
		System.out.println();
		LinkedListNode kthNode = list.getNthNodeFromLast(head, head, 2);
		System.out.println(kthNode.data);
		list.print();
	}

	private LinkedListNode getNthNodeFromLast(LinkedListNode fastHead, LinkedListNode slowHead, int k) {
		for (int i = 0; i < k; i++) {
			if (fastHead == null)
				return null;
			fastHead = fastHead.next;
		}

		if (fastHead == null)
			return null;

		while (fastHead != null) {
			fastHead = fastHead.next;
			slowHead = slowHead.next;
		}
		return slowHead;
	}

	public void print() {
		LinkedListNode n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
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
		private int data;

		public LinkedListNode(int d) {
			this.data = d;
		}

		public int getData() {
			return data;
		}
	}
}