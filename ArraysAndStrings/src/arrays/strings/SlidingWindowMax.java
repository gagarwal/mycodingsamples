package arrays.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax 
{
	public static int[] maxSlidingWindow(int[] input, int k) 
    {
		if (input == null || k <= 0) return new int[0];
		
		int[] output = new int[input.length-k+1];
		int opIndex = 0;
		
		// store index
		Deque<Integer> queue = new ArrayDeque<>();
		
		for (int i = 0; i < input.length; i++) 
		{
			// remove numbers out of range k
			if (!queue.isEmpty() && i - queue.peek() > k-1)
				queue.poll();

			// remove smaller numbers in k range as they are useless
			while (!queue.isEmpty() && input[queue.peekLast()] < input[i]) {
				queue.pollLast();
			}
			// q contains index... r contains content
			queue.offer(i);
			if (i >= k - 1) 
				output[opIndex++] = input[queue.peek()];
		}
		return output;
    }
    
    public static void main(String args[])
    {
    	int[] input = {9, 11};
    			
    	int[] output = SlidingWindowMax.maxSlidingWindow(input, 3);
    	
    	for(int i: output)
    	System.out.println( i);
    }
}