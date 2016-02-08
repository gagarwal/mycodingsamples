import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Longest {

	// Returns length of the longest consecutive subsequence
	static int[] findLongestConseqSubseq(int arr[], int n) {

		/*
		 * Keep track of each value we've seen in the array. Duplicates would
		 * screw up the algorithm, so we'll skip over them.
		 * 
		 */
		Set<Integer> seen = new HashSet<Integer>();

		/*
		 * Store the consecutive intervals we've seen so far. If we've seen all
		 * integers in the range [i, j] and haven't seen the integers i-1 or
		 * j+1, then (i, j) and (j, i) will both be in the map. //
		 */
		Map<Integer, Integer> intervals = new HashMap<Integer, Integer>();

		for (int i : arr) {

			if (seen.contains(i)) {
				continue;
			}

			seen.add(i);

			int low = i, high = i;

			if (intervals.containsKey(i + 1)) {
				// Coalesce with the interval above us.
				high = intervals.remove(i + 1);

			}

			if (intervals.containsKey(i - 1)) {
				// Coalesce with the interval below us.
				low = intervals.remove(i - 1);
			}

			/*
			 * Insert our new intervals. This will finish coalescing by
			 * overwriting the other half that we have not removed.
			 */
			intervals.put(low, high);
			intervals.put(high, low);
		}

		int low = 0, high = 0;

		for (Entry<Integer, Integer> pair : intervals.entrySet()) {

			if (high - low < (long) pair.getKey() - pair.getValue()) {

				low = pair.getValue();
				high = pair.getKey();
			}
		}

		int[] ret = new int[high - low + 1];

		for (int i = 0; i < ret.length; i++) {
			ret[i] = i + low;
		}
		return ret;
	}

	// Testing program
	public static void main(String args[]) {
		int arr[] = { 1, 0, 5, 6, 2 };

		int[] result = findLongestConseqSubseq(arr, arr.length);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

		int[] result2 = dynamicFindLongestConsecutiveSequence(arr);

		for (int i = 0; i < result2.length; i++) {
			System.out.print(result2[i] + " ");
		}
	}

	//https://www.quora.com/Given-an-array-of-random-numbers-how-can-one-find-the-longest-consecutive-sequence
	public static int[] dynamicFindLongestConsecutiveSequence(int[] nums) {

		if (nums == null) {
			return new int[0];
		}

		Map<Integer, Integer> numConsecutiveValuesStartingFrom = new HashMap<Integer, Integer>();

		for (int num : nums) {
			numConsecutiveValuesStartingFrom.put(num, 0);
		}

		int n = nums.length;

		int maxNumConsecutiveValues = 0;

		int maxStartIndex = 0;

		for (int i = 0; i < n; ++i) {

			int num = nums[i];

			int numConsecutiveValues = findNumConsecutiveValuesStartingAt(num, numConsecutiveValuesStartingFrom);

			if (numConsecutiveValues > maxNumConsecutiveValues) {

				maxNumConsecutiveValues = numConsecutiveValues;

				maxStartIndex = i;
			}
		}

		int[] longestConsecutiveSequence = new int[maxNumConsecutiveValues];

		for (int i = 0; i < maxNumConsecutiveValues; ++i) {
			int num = nums[maxStartIndex] + i;
			longestConsecutiveSequence[i] = num;
		}

		return longestConsecutiveSequence;
	}

	private static int findNumConsecutiveValuesStartingAt(int num,
			Map<Integer, Integer> numConsecutiveValuesStartingFrom) {

		boolean isNumInArray = numConsecutiveValuesStartingFrom.containsKey(num);

		if (!isNumInArray) {
			return 0;
		}

		int numConsecutiveValuesStartingFromNum = numConsecutiveValuesStartingFrom.get(num);

		boolean numConsecutiveValuesHaveBeenComputed = (numConsecutiveValuesStartingFromNum != 0);

		if (numConsecutiveValuesHaveBeenComputed) {
			return numConsecutiveValuesStartingFromNum;
		}

		int numConsecutiveValues = 1 + findNumConsecutiveValuesStartingAt(num + 1, numConsecutiveValuesStartingFrom);

		numConsecutiveValuesStartingFrom.put(num, numConsecutiveValues);

		return numConsecutiveValues;
	}
}