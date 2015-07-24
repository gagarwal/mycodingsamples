public class RecursivePrintSubsetOrderMatters {

	public static void main(String args[]) {
		printSubset("", "abcd");

	}

	private static void printSubset(final String sofar, final String remaining) {
		final int length = remaining.length();

		if (length == 0) {

			System.out.println(sofar);

		}

		else {

			for (int i = 0; i < remaining.length(); i++) {

				// printSubset(sofar + remaining.charAt(0),
				// remaining.substring(1, length));

				printSubset(sofar + remaining.charAt(i),
						remaining.substring(i + 1, length));

				printSubset(sofar, remaining.substring(i + 1, length));

				// printSubset(sofar, remaining.substring(1, length));

			}
		}
	}
}
