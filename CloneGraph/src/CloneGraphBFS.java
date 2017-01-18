import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraphBFS
{
	/**
	 * Definition for undirected graph. class UndirectedGraphNode { int label;
	 * List<UndirectedGraphNode> neighbors; UndirectedGraphNode(int x) { label =
	 * x; neighbors = new ArrayList<UndirectedGraphNode>(); } };
	 */

	class UndirectedGraphNode
	{
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x)
		{
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
	{
		if (node == null)
			return null;

		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		queue.offer(node);
		map.put(node, newNode);

		while (!queue.isEmpty())
		{
			UndirectedGraphNode current = queue.poll();
			List<UndirectedGraphNode> currentNeighbors = current.neighbors;

			for (UndirectedGraphNode neighbor : currentNeighbors)
			{
				if (!map.containsKey(neighbor))
				{
					UndirectedGraphNode neighborDash = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor, neighborDash);
					queue.add(neighbor);
					map.get(current).neighbors.add(neighborDash);
				} else
				{
					map.get(current).neighbors.add(map.get(neighbor));
				}
			}
		}
		return newNode;
	}
}
