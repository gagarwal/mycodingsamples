import java.util.ArrayList;

public class MoveAllElementsToRight {
	public static void main(String args[]) {
		int[] nums = { 2, 0, 4, 0, 0, 5, 7 };
		// moveZeroesToRight(nums);
		moveZeroesToLeft(nums);
		// moveAllZerosToRight(nums);
	}

	private static ArrayList<Integer> moveZeroesToRight(int[] arr) {

		int count = 0; // Count of non-zero elements

		// Traverse the array. If element encountered is non-zero, then
		// replace the element at index 'count' with this element
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != 0)
				arr[count++] = arr[i]; // here count is incremented

		// Now all non-zero elements have been shifted to front and 'count' is
		// set as index of first 0. Make all elements 0 from count to end.
		while (count < arr.length)
			arr[count++] = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		return null;
	}

	private static void moveZeroesToLeft(int[] arr) {

		int count = arr.length - 1; // Count of non-zero elements

		// Traverse the array. If element encountered is non-zero, then
		// replace the element at index 'count' with this element
		for (int i = arr.length - 1; i >= 0; i--)
			if (arr[i] != 0)
				arr[count--] = arr[i]; // here count is decremented

		// Now all non-zero elements have been shifted to front and 'count' is
		// set as index of first 0. Make all elements 0 from count to end.
		int j = 0;
		while (j <= count) {
			arr[j] = 0;
			j++;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}