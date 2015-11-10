
public class FindingFirstOccurance {
	private static int bSearchVal(int[] a, int low, int high, long key) {
	//	int low = fromIndex;
		//int high = toIndex - 1;
		int result = low;
		while (low <= high) {
			int mid = (low + high) / 2;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else {
				result = mid;
				high = mid - 1;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int a[] = { 5, 6, 7, 8, 8, 8, 9, 80, 89 };
		System.out.println(bSearchVal(a, 0, a.length, 8));
	}
}
