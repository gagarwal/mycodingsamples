
import java.util.Stack;

public class StackWithMinWithExtraStack extends Stack<Integer> {
	private static final long serialVersionUID = 1L;
	Stack<Integer> s2;

	public StackWithMinWithExtraStack() {
		s2 = new Stack<Integer>();
	}

	public int size() {
		return elementCount;
	}

	public void push(int value) {
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}

	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}
