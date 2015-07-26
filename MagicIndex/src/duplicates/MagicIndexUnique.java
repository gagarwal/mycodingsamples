package duplicates;

public class MagicIndexUnique {

	public static void main(String args[]) {

		int a[] = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
		System.out.println("magic index brute force exists??  "
				+ maigcIndexBruteForce(a));

		System.out.println("magic index brute force exists??  "
				+ magicIndexBinarySearch(a, 0, a.length - 1));
	}

	// brute force
	private static int maigcIndexBruteForce(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (i == a[i])
				return i;
		}
		return -1;
	}

	// similar to binary search
	private static int magicIndexBinarySearch(int[] a, int start, int end) {

		if (start < 0 || end >= a.length || end < start) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (mid == a[mid])
			return mid;

		else if (a[mid] > mid) {
			return magicIndexBinarySearch(a, start, mid - 1);
		}

		else
			return magicIndexBinarySearch(a, mid + 1, end);
	}
}
