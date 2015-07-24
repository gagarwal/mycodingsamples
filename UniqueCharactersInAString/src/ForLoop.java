
public class ForLoop {

	public static void main(String args[]) {

		System.out.println(hasUniqueCharacters(args[0]));
	}

	private static boolean hasUniqueCharacters(String testString) {

		int length = testString.length();

		for (int i = 0; i < length; i++) {

			for (int j = i + 1; j < length; j++) {

				if (testString.substring(i, i).equals(
						testString.substring(j, j))) {
					return false;

				}
			}
		}
		return false;
	}
}
