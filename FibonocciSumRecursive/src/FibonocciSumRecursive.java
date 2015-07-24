public class FibonocciSumRecursive {

	public static void main(String args[]) {

		System.out.println(sumFibonocci(5));
	}

	private static int sumFibonocci(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		return sumFibonocci(n - 1) + sumFibonocci(n - 2) + 1;
	}
}
