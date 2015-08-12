public class ValidParanthesisCount2 {
	public static void main(String args[]) {
		printValidParanthesis(0, 0, 3, "");
	}

	private static void printValidParanthesis(int open, int close, int max,
			String sofar) {
		
		if (open == max && close == max) {
			System.out.println(sofar);
			return;
		}

		if (open < max) {
			printValidParanthesis(open + 1, close, max, sofar + "(");
		}

		if (close < open) {
			printValidParanthesis(open, close + 1, max, sofar + ")");
		}
	}
}
