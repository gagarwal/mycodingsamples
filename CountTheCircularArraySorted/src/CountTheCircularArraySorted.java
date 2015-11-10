
public class CountTheCircularArraySorted {

	public static void main(String args[]) {
		int a[] = { 6, 7, 8, 9, 10, 2, 3, 4, 5 };
		// System.out.println(countInterative(a));

		System.out.println(findRotationCount(a));
	}

	private static int findRotationCount(int[] a) {
		int low = 0;
		int length = a.length;
		int high = length - 1;

		while (low <= high) {
			if (a[low] < a[high]) {
				return low; // array is already sorted
			}

			int mid = (low + high) / 2;
			int next = (mid + 1) % length;
			int prev = (mid - 1 + length) % length;

			if (a[prev] > a[mid] && a[mid] < a[next]) { //check if it is a pivot element
				return mid;
			}

			if (a[low] < a[mid]) {
				low = mid + 1;
			}

			if (a[mid] < a[high]) {
				high = mid - 1;
			}

		}
		return -1;
	}

	private static int countInterative(int[] a) {
		int i = 0;
		int min = a[0];
		while (i < a.length) {
			if (a[i] < min) {
				min = a[i];
				break;
			}
			i++;
		}
		return i;
	}
}
