public class RecusrionExponentialHalfBase {

	public static int getExponential(int n) {
		if (n == 0) {
			return 1;
		} else {
			if (n % 2 == 0) {
				return getExponential(n / 2) * getExponential(n / 2);
			}
			return n * getExponential(n / 2) * getExponential(n / 2);
		}
	}

	public static void main(String[] args) {

		System.out.println(getExponential(Integer.parseInt(args[0])));
	}
}
