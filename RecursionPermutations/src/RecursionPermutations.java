public class RecursionPermutations {

	// Helper function
	private static void getPermutations(String prefix, String rest) {
		int length = 0;

		if (rest != null)
			length = rest.length();

		if (length == 0) {
			System.out.println(prefix);
			return;
		} else {
			for (int i = 0; i < rest.length(); i++) {
				// if (i > 0) {
				// if (rest.charAt(i) == rest.charAt(i - 1)) {
				// continue;
				// }
				// }
				getPermutations(prefix + rest.charAt(i), rest.substring(0, i)
						+ rest.substring(i + 1, length));
			}
		}
	}

	public static void main(String[] args) {
		String alphabet = "abc";
		String elements = alphabet.substring(0, alphabet.length());
		getPermutations("", elements);
	}
}