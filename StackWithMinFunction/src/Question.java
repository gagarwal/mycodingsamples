import helper.AssortedMethods;

public class Question {
	public static void main(String[] args) {
		StackWithMinStoreMinAtEachValue stack = new StackWithMinStoreMinAtEachValue();

		StackWithMinWithExtraStack stack2 = new StackWithMinWithExtraStack();

		for (int i = 0; i < 15; i++) {
			int value = AssortedMethods.randomIntInRange(0, 100);
			 stack.push(value);
			stack2.push(value);

			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < 15; i++) {
			// System.out.println("Popped " + stack.pop().value + ", " +
			// stack2.pop());
			// System.out.println("New min is " + stack.min() + ", " +
			// stack2.min());

			System.out.println("Popped " + stack2.pop());
			System.out.println("New min is " + stack2.min());
		}
	}

}
