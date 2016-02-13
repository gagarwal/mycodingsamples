import java.util.HashMap;

public class LRUCache {

	private HashMap<Integer, LRUCache.DoubleLinkedListNode> table = new HashMap<Integer, LRUCache.DoubleLinkedListNode>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private int len;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
	}

	public int get(int key) {
		if (table.containsKey(key)) {
			removeNode(table.get(key));
			setHead(table.get(key));
			return table.get(key).val;
		} else {
			return -1;
		}
	}

	private void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.post;
		if (pre != null) {
			pre.post = post;
		} else {
			head = post;
		}
		if (post != null) {
			post.pre = pre;
		} else {
			end = pre;
		}
	}

	private void setHead(DoubleLinkedListNode node) {
		node.post = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}
		head = node;
		if (end == null) {
			end = node;
		}
	}

	public void set(int key, int value) {
		if (table.containsKey(key)) {
			DoubleLinkedListNode cur = table.get(key);
			cur.val = value;
			removeNode(cur);
			setHead(cur);
		} else {
			DoubleLinkedListNode cur = new DoubleLinkedListNode(key, value);
			if (len < capacity) {
				setHead(cur);
				table.put(key, cur);
				len++;
			} else {
				table.remove(end.key);
				end = end.pre;
				if (end != null) {
					end.post = null;
				}

				setHead(cur);
				table.put(key, cur);
			}
		}
	}

	public class DoubleLinkedListNode {
		public int val;
		public int key;
		public DoubleLinkedListNode pre;
		public DoubleLinkedListNode post;

		public DoubleLinkedListNode(int key, int value) {
			val = value;
			this.key = key;
		}

	}

	public static void main(String args[]) {
		LRUCache cache = new LRUCache(3);
		cache.set(4, 5);
		cache.set(6, 7);
		cache.set(8, 8);
		cache.set(9, 10);
		System.out.println(cache.get(7));
		System.out.println(cache.get(4));
	}
}