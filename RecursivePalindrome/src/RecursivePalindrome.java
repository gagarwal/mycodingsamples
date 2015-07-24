public class RecursivePalindrome {

	public static boolean isPalindrome(final String testString) {

		if (testString.length() <= 1)
			return true;

		return testString.charAt(0) == testString.charAt(testString.length() - 1)
				&& isPalindrome(testString.substring(1, testString.length() - 1));

	}

	public static void main(String[] args) {

		System.out.println(isPalindrome(args[0]));
	}
}
