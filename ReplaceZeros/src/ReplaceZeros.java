import helper.AssortedMethods;

public class ReplaceZeros {
	// Assume string has sufficient free space at the end
	public static void replaceSpaces(char[] charArray, int length) {

		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (charArray[i] == ' ') {
				spaceCount++;
			}
		}

		int index = length + (spaceCount * 2);
		charArray[index] = '\0';

		for (int i = length - 1; i >= 0; i--) {
			if (charArray[i] == ' ') {
				charArray[--index] = '0';
				charArray[--index] = '2';
				charArray[--index] = '%';
			} else {
				charArray[--index] = charArray[i];
			}
		}
	}

	public static void main(String[] args) {
		String str = "abc d e f";
		char[] arr = new char[str.length() + 3 * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		replaceSpaces(arr, str.length());
		System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
	}
}