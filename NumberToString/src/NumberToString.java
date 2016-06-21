import java.util.HashMap;
import java.util.Map;

import helper.AssortedMethods;

public class NumberToString {
	public static String[] digits = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	public static String[] teens = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	public static String[] tens = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };
	public static String[] bigs = { "", "Thousand", "Million", "Billion" };

	public static String numToString(int number) {
		if (number == 0) {
			return "Zero";
		}

		if (number < 0) {
			return "Negative " + numToString(-1 * number);
		}

		int count = 0;
		String str = "";

		while (number > 0) {
			if (number % 1000 != 0) {
				str = numToString100(number % 1000) + bigs[count] + " " + str;
			}

			number /= 1000;
			count++;
		}
		return str;
	}

	public static String numToString100(int number) {
		Map map = new HashMap<Long, Long>();
		String str = "";

		/* Convert hundreds place */
		if (number >= 100) {
			str += digits[number / 100 - 1] + " Hundred ";
			number %= 100;
		}

		/* Convert tens place */
		if (number >= 11 && number <= 19) {
			return str + teens[number - 11] + " ";
		} else if (number == 10 || number >= 20) {
			str += tens[number / 10 - 1] + " ";
			number %= 10;
		}

		/* Convert ones place */
		if (number >= 1 && number <= 9) {
			str += digits[number - 1] + " ";
		}

		return str;
	}

	public static void main(String[] args) {
		// Accept up to 3 parameters
		String[] list = new String[3];

		int index = 0;

		while ((index < args.length) && (index < 3)) {
			list[index++] = args[index];
		}

		// Check all the parameters
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals("-help")) {
				// .........
			} else if (list[i].equals("-cp")) {
				// .........
			}
			// else .....
		}

		String abc = "abc";
		String def = "def";
		if ((abc + def) == "abcdef") {
			System.out.println("This string matches abcdef");
		} else {
			System.out.println("This string does not match abcdef");
		}

		int a = 5;
		boolean b = true;
		// int c = a + b;
		double d = a + 1.4;
		/* numbers between 100000 and 1000000 */
		for (int i = 0; i < 8; i++) {
			int value = (int) Math.pow(10, i);
			String s = numToString(-1 * value);
			System.out.println(value + ": " + s);
		}

		/* numbers between 0 and 100 */
		for (int i = 0; i < 1; i++) {
			int value = 43;
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}

		/* numbers between 100 and 1000 */
		for (int i = 0; i < 10; i++) {
			int value = AssortedMethods.randomIntInRange(100, 1000);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}

		/* numbers between 1000 and 100000 */
		for (int i = 0; i < 10; i++) {
			int value = AssortedMethods.randomIntInRange(1000, 100000);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}

		/* numbers between 100000 and 100000000 */
		for (int i = 0; i < 10; i++) {
			int value = AssortedMethods.randomIntInRange(100000, 100000000);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}

		/* numbers between 100000000 and 1000000000 */
		for (int i = 0; i < 10; i++) {
			int value = AssortedMethods.randomIntInRange(100000000, 1000000000);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}

		/* numbers between 1000000000 and Integer.MAX_VALUE */
		for (int i = 0; i < 10; i++) {
			int value = AssortedMethods.randomIntInRange(1000000000, Integer.MAX_VALUE);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}
	}
}