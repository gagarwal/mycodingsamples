public class RecursivePrintSubset {

	public static void main(String args[]) {
		printSubset("", "abcd");
	}

	private static void printSubset(final String sofar, final String remaining) {
		final int length = remaining.length();

		if (length == 0) {
			System.out.println(sofar);
		}

		else {
			printSubset(sofar + remaining.charAt(0),
					remaining.substring(1, length));

			// printSubset(remaining.substring(1, length),
			// sofar + remaining.charAt(0));
			printSubset(sofar, remaining.substring(1, length));
			// printSubset(remaining.substring(1, length), sofar);
		}
	}
}
