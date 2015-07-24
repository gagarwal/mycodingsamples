public class RecursivePermutationsWithDuplicates {

	private static void permutation(String sofar, String rest) {

		int n = rest.length();

		if (n == 0)
			System.out.println(sofar);

		else {
			for (int i = 0; i < n; i++) {

				char charAtI = rest.charAt(i);

				if (charAtI == rest.charAt(i + 1)) {

					continue;
				}

				String next = sofar + charAtI;

				String remaining = rest.substring(0, i)
						+ rest.substring(i + 1, n);

				permutation(next, remaining);
			}
		}
	}

	public static void main(String args[]) {
		permutation("", "abc");
	}
}
