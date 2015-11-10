
public class FindInCircularArray {

	public static void main(String args[]) {
		int a[] = { 5, 6, 7, 8, 8, 8, 9, 80, 89 };
		System.out.println(searchInCircularArray(a, 8));
	}

	private static int searchInCircularArray(int[] a, int key) {
		int low = 0;
		int length = a.length;
		int high = length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (a[mid] == key) {
				return mid;
			}

			if (a[mid] < a[high]) // right half is sorted
			{
				if (a[mid] < key && key < a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

			else { // left half is sorted
				if (a[low] < key && key < a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}
