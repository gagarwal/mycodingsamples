package arrays.strings;

public class StringHasUniqueChars {

	public static void main(String[] args) {

		System.out.println(stringHasUniqueChars("gh"));
	}

	public static boolean stringHasUniqueChars(String str) {
		if (str.length() > 256)
			return false;

		boolean[] charSet = new boolean[256];

		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}
}
