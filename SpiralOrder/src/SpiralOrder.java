
public class SpiralOrder {

	public static void main(String args[]) {
		int[][] twoDArray = new int[][] { 
			{ 1, 2, 3, 4 }, 
			{ 5, 6, 7, 8 }, 
			{ 9, 10, 11, 12 }, };
		printSpiralOrder(twoDArray, 3, 4);
	}

	private static void printSpiralOrder(int[][] a, int m, int n) {
		int dir = 0, T = 0, L = 0;
		int B = m - 1, R = n - 1;

		while (T <= B && L <= R) {

			if (dir == 0) {
				for (int k = L; k <= R; k++) {
					System.out.print(a[T][k]);
					System.out.print(" ");
				}
				System.out.println();
				T++;

			} else if (dir == 1) {
				for (int k = T; k <= B; k++) {
					System.out.print(a[k][R]);
					System.out.print(" ");
				}
				System.out.println();
				R--;

			} else if (dir == 2) {
				for (int k = R; k >= L; k--) {
					System.out.print(a[B][k]);
					System.out.print(" ");
				}
				System.out.println();
				B--;

			} else {
				for (int k = B; k >= T; k--) {
					System.out.print(a[k][L]);
					System.out.print(" ");
				}
				System.out.println();
				L++;
			}
			dir = (dir + 1) % 4;
		}
	}
}
