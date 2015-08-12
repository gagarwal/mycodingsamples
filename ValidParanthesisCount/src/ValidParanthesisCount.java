public class ValidParanthesisCount {
	public static void main(String args[]) {
		printValidParanthesis(3, 3, "");
	}

	private static void printValidParanthesis(int openStock, int closedStock,
			String sofar) {

		if (openStock == 0 && closedStock == 0) {
			System.out.println(sofar);
			return;
		}

		if (openStock > 0) {
			printValidParanthesis(openStock - 1, closedStock, sofar + "(");
		}

		if (closedStock > 0) {
			printValidParanthesis(openStock, closedStock - 1, sofar + ")");
		}
	}
}
