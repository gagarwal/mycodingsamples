public class RecursionPermutations {

	// Helper function
	private static void perm1(String prefix, String rest) {
		int N = 0;

		if (rest != null)
			N = rest.length();

		if (N == 0) {

			System.out.println(prefix);

		} else {
			for (int i = 0; i < rest.length(); i++) {
				if (i > 0) {
					if (rest.charAt(i) == rest.charAt(i - 1)) {
						continue;
					}
				}

				String newPrefix = prefix + rest.charAt(i);
				String newRest = rest.substring(0, i)
						+ rest.substring(i + 1, N);
				perm1(newPrefix, newRest);
			}
		}
	}

	public static void main(String[] args) {
		String alphabet = "abab";
		String elements = alphabet.substring(0, alphabet.length());
		perm1("", elements);
	}

}