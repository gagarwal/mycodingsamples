
public class PrintKthNodeFromLastLinedList {
	static LinkedListNode head = null;
	LinkedListNode tail = null;
	int length = 0;

	public static void main(String args[]) {
		PrintKthNodeFromLastLinedList list = new PrintKthNodeFromLastLinedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);

		list.print();
		System.out.println();
		int kthNodeValue = list.printNthNodeFromLast(head, head, 2);
		System.out.println(kthNodeValue);
		list.print();
	}

	private int printNthNodeFromLast(LinkedListNode fastHead, LinkedListNode slowHead, int k) {
		for (int i = 0; i < k; i++) {
			if (fastHead == null)
				return 0;
			fastHead = fastHead.next;
		}

		if (fastHead == null)
			return 0;

		while (fastHead != null) {
			fastHead = fastHead.next;
			slowHead = slowHead.next;
		}
		return 0;
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