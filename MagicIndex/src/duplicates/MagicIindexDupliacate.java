package duplicates;

public class MagicIindexDupliacate {

	public static void main(String args[]) {

		// int a[] = { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };

		int a[] = { -10, -5, -1, -1, -1, -1, -1, -1, -1, -1, 11 };
		System.out.println("magic index brute force exists??  "
				+ maigcIndexDuplicates(a, 0, a.length));
	}

	private static int maigcIndexDuplicates(int[] a, int start, int end) {

		if (start < 0 || end >= a.length || start > end) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (mid == a[mid])
			return mid;

		// search left
		int leftIndex = Math.min(mid, a[mid]);
		int left = maigcIndexDuplicates(a, start, leftIndex);
		if (left >= 0)
			return left;

		// search right
		int rightIndex = Math.max(mid + 1, a[mid]);
		int right = maigcIndexDuplicates(a, rightIndex, end);
		return right;
	}
}
