import java.util.HashMap;

public class LRU2 
{
	private class Node 
	{
		protected int key;
		protected int value;
		protected Node prev;
		protected Node next;

		public Node(int key, int value)
		{
			this.key = key;
			this.value = value;
			prev = next = null;
		}
	}

	private HashMap<Integer, Node> lookup;
	private Node start = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
	private Node tail;
	private int capacity;
	private int size = 0;

	public LRU2(int capacity)
	{
		lookup = new HashMap<Integer, Node>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) 
	{
		Node node = lookup.get(key);

		if (node == null) 
		{
		 return -1;
		}
		else 
		{
			removeNode(node);
			lookup.remove(node);

			addNodeToFront(node);
			lookup.put(key, node);

			return node.value;
		}
	}

	public void set(int key, int value) {
		
		Node node = lookup.get(key);

		if (node == null)
		{
			if (size >= capacity) 
			{
				Node LUNode = removeFromTail();
				lookup.remove(LUNode.key);
			}

			Node newNode = new Node(key, value);
			addNodeToFront(newNode);
			lookup.put(key, newNode);
		} 
		else 
		{
			node.value = value;

			removeNode(node);
			lookup.remove(node);

			addNodeToFront(node);
			lookup.put(key, node);
		}
	}

	private void removeNode(Node node)
	{
		if (node.next == null)
		{
			tail = node.prev;
			node.prev.next = null;
			node.prev = null;
		} 
		else
		{
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		size--;
	}

	private void addNodeToFront(Node node)
	{
		if (start.next == null) 
		{
			start.next = node;
			node.prev = start;
			tail = node;
		} 
		else
		{
			start.next.prev = node;
			node.next = start.next;
			start.next = node;
			node.prev = start;
		}
		size++;
	}

	private Node removeFromTail() {
		Node temp = tail;
		tail = tail.prev;
		removeNode(temp);
		return temp;
	}
}

