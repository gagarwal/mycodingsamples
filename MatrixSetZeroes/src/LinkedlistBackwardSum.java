
import helper.LinkedListNode;

public class LinkedlistBackwardSum {

	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		if (l1 == null || l2 == null) {
			result.data = value;
		} else {
			result.data = value % 10;
		}

		if (l1 != null || l2 != null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
					((value - (value % 10)) / 10));
			result.setNext(more);
		}
		return result;
	}

	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(8, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(790, null, lA2);

		LinkedListNode lB1 = new LinkedListNode(6, null, null);
		LinkedListNode lB2 = new LinkedListNode(8, null, lB1);
		// LinkedListNode lB3 = new LinkedListNode(12, null, lB2);

		System.out.println("  " + lA1.data);
		System.out.println("  " + lA1.next.data);
		System.out.println("  " + lA1.next.next.data);
		System.out.println("  " + lA1.next.next.next);

		LinkedListNode list3 = addLists(lA1, lB1, 0);

		System.out.println("  " + lA1.printForward());
		System.out.println("+ " + lB1.printForward());
		System.out.println("= " + list3.printForward());

		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);

		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");

		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
	}
}