import java.util.Scanner;

public class StaircaseRecursion {

	public static int recursiveStairCase(int n) {

		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 4;

		return recursiveStairCase(n - 1) + recursiveStairCase(n - 2)
				+ recursiveStairCase(n - 3);

	}

	public static void main(String args[]) {

		System.out.print("Enter value of n ");

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		scanner.close();
		System.out.println(recursiveStairCase(n));
	}
}
