import java.util.ArrayList;

public class FindMissingNumbersFromSortedArray {
	public static void main(String args[]) {
		int[] nums = { 2, 4, 5, 7 };
		System.out.println(findMissingNumbers(nums));
	}

	public static ArrayList<Integer> findMissingNumbers(int[] a) {

		int j = a[0];
		ArrayList<Integer> missing = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == j) {

			}

			else {
				missing.add(j);
				i--;
			}
			j++;
		}
		return missing;
	}
}
