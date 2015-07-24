import java.util.ArrayList;

public class PathFromXtoY {
	public static void main(String args[]) {
		System.out.print(existsPathFromXtoY(2, 2, new ArrayList<Point>(),
				new boolean[3][3]));
		// System.out.println(existsPathFromXto
	}

	private static boolean existsPathFromXtoY(int x, int y,
			ArrayList<Point> path, boolean[][] board) {

		path.add(new Point(x, y));
		board[x-1][y-1] = true;

		if (x == 0 && y == 0) {
			return true;
		}

		boolean success = false;

		if (x > 1 && isFree(board, x - 2, y-1)) {
			success = existsPathFromXtoY(x - 1, y, path, board);
		}

		if (!success && y > 1 && isFree(board, x-1, y - 2)) {
			success = existsPathFromXtoY(y, y - 1, path, board);
		}

		if (!success) {
			board[x-1][y-1] = false;
			path.remove(new Point(x, y));
		}

		System.out.println("size is "+path);
		return success;
	}

	static boolean isFree(boolean[][] board, int x, int y) {
		return !board[x][y];
	}

}