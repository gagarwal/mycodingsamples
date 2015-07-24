import java.util.Scanner;

public class RecusrionCombination {

	public static int numberOfCombinations(int n, int k) {
		if (k == n || k == 0) {
			return 1;
		} else {
			return numberOfCombinations(n - 1, k)
					+ numberOfCombinations(n - 1, k - 1);
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter value of n ");
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		System.out.print("Enter value of k ");

		int k = scanner.nextInt();
		scanner.close();
		System.out.println(RecusrionCombination.numberOfCombinations(n, k));
	}
}