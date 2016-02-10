package main;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Utility for the SumTarget
 * </p>
 * 
 * @author Bindu Kallamadi
 */
public class SumTarget {
	/**
	 * @param array
	 *            Array of itegers to check if any the two elements sums to
	 *            target.
	 * @param target
	 *            Target value to check if any two elements in the array sums to
	 *            this value.
	 * @return True if any two values in the array sums to target, false
	 *         otherwise.
	 */
	public boolean hasSumPairForTarget(int[] array, int target) {
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			if (pairs.containsKey(array[i])) {
				return true;
			}
			pairs.put(target - array[i], i);
		}
		return false;
	}
}
