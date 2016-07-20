/**
 * pure storage buddy system bitmap Given a complete binary tree with nodes of
 * values of either 1 or 0, the following rules always hold: (1) a node's value
 * is 1 if and only if all its subtree nodes' values are 1 (2) a leaf node can
 * have value either 1 or 0 Implement the following 2 APIs: set_bit(offset,
 * length), set the bits at range from offset to offset+length-1
 * clear_bit(offset, length), clear the bits at range from offset to
 * offset+length-1
 * 
 * i.e. The tree is like: 0 / \ 0 1 / \ / \ 1 0 1 1 /\ / \ / 1 1 1 0 1 Since
 * it's complete binary tree, the nodes can be stored in an array:
 * [0,0,1,1,0,1,1,1,1,1,0,1]
 */
public class BuddyBitMap
{
	// @formatter:off
	private static void setBit(int[] input, int offset, int length)
	{
		if (input == null || offset < 0 || length <= 0)
			return;
		int n = length - 1;

		for (int i = offset; i < Math.min(n + 1, Math.min(offset + length, 2 * offset + 1)); i++) {
			if (input[i] == 1)
				continue;

			input[i] = 1;

			// set descendants
			setbit_down(input, i, n);
			// set ancestors
			while (i > 0) {
				// make sure its sibling is 1, if its sibling is 0, cannot set
				// ancestors
				if ((i % 2 == 0 && input[i - 1] == 1) || (i % 2 == 1 && i < n && input[i + 1] == 1))
					input[(i - 1) / 2] = 1;
				i = (i - 1) / 2;
			}
		}
	}

	private static void setbit_down(int[] input, int index, int n) 
	{
		if (index >= n)
			return;

		if (2 * index + 1 <= n && input[2 * index + 1] == 0) 
		{
			input[2 * index + 1] = 1;
			setbit_down(input, 2 * index + 1, n);
		}

		if (2 * index + 2 <= n && input[2 * index + 2] == 0)
		{
			input[2 * index + 2] = 1;
			setbit_down(input, 2 * index + 2, n);
		}
	}
	// @formatter:on
	private static void clear_bit(int[] input, int pos, int length) 
	{
		if (input == null || pos < 0 || length <= 0)
			return;

		int n = length - 1; // last index of A

		for (int index = pos; index < Math.min(n + 1, pos + length); index++) 
		{
			// # clear self
			if (input[index] == 0)
				continue;

			input[index] = 0;

			// clear descendants
			while (2 * index + 1 <= n) 
			{
				input[2 * index + 1] = 0;
				index = 2 * index + 1;
			}
			// # clear ancestors
			while (index > 0) 
			{
				if (input[(index - 1) / 2] == 0)
					break;
				
				input[(index - 1) / 2] = 0;
				index = (index - 1) / 2;
			}
		}
	}

	 public static void main(String args[])
     {
    int[] A={0,0,1,1,0,1,1,1,1,1,0,1};
     setBit(A,0, 6);
     
     for(int i: A)
    	 System.out.print(i+ " ");
     
	}
}
