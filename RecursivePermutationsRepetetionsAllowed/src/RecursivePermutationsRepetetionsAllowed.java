public class RecursivePermutationsRepetetionsAllowed {
	public static void main(String args[]) {
		permuatationsWithRepetetions("", "ab");
	}

	private static void permuatationsWithRepetetions(String prefix, String str) {

		if (prefix.length() == str.length()) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < str.length(); i++)
			permuatationsWithRepetetions(prefix + str.charAt(i), str);
	}
}
