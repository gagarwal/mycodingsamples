import java.util.Scanner;

public class RecursiveTowerOfHanoi {

	public static void solve(int n, String start, String auxiliary, String end) {
	
		if (n > 0) {
		
			solve(n - 1, start, end, auxiliary);
			
			System.out.println(start + " -> " + end);
			
			solve(n - 1, auxiliary, start, end);
		}
	}

	public static void main(String[] args) {
		
		System.out.print("Enter number of discs: ");
		
		Scanner scanner = new Scanner(System.in);
		
		int discs = scanner.nextInt();
		
		scanner.close();
		
		RecursiveTowerOfHanoi.solve(discs, "A", "B", "C");
	}
}
