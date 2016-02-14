
import java.util.Stack;

/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/
 * IDeserve</a> Given an array of integers(positive or negative), print the next
 * greater element of all elements in the array. If there is no greater element
 * then print null.
 *
 * @author Saurabh
 */
public class NextGreaterElement {

	public static void printNextGreaterElement(int[] input)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		int inputSize = input.length;
		
		stack.push(input[0]);
		
		for (int i = 1; i < inputSize; i++)
		{
			while (!stack.isEmpty() && stack.peek() < input[i])
			{
				System.out.println("Next greater element for " + stack.pop() + "\t = " + input[i]);
			}
			stack.push(input[i]);
		}
		
		while (!stack.isEmpty()) {
			int top = (int) stack.pop();
			System.out.println("Next greater element for " + top + "\t = " + null);
		}
	}

	public static void main(String[] args) {
		int[] input = { 98, 23, 54, 12, 20, 55,7, 27 };
		printNextGreaterElement(input);
	}
}