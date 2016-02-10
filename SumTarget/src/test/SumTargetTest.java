package test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.SumTarget;

/**
 * <p>
 * Test class for {@link SumTarget}
 * </p>
 * 
 * @author Bindu Kallamadi
 */
public class SumTargetTest {
	SumTarget sumTarget = new SumTarget();
	private static final int TARGET = 42;

	/**
	 * Test Sumtarget happy path.
	 */
	@Test
	public void arrayHasPair() {
		int[] array = { 2, 42, 0, 7, 3, 5, 1, 8, 9 };
		assertTrue(sumTarget.hasSumPairForTarget(array, TARGET));
	}

	/**
	 * Test sumTarget with an input array which does not have pair that sums up
	 * to target.
	 */
	@Test
	public void arrayDoesNotHavePair() {
		int[] array = { 2, 45, 7, 3, 5, 1, 8, 9 };
		assertFalse(sumTarget.hasSumPairForTarget(array, TARGET));
	}

	/**
	 * Test sumTarget with input array of zeroes.
	 */
	@Test
	public void arrayWithAllZeroes() {
		int[] array = { 0, 0, 0, 0, 0 };
		assertFalse(sumTarget.hasSumPairForTarget(array, TARGET));
	}

	/**
	 * Test sumTarget with input array with negative values, has pair.
	 */
	@Test
	public void arrayWithNegativeValuesHasPair() {
		int[] array = { -90, 132, 89, 9 };
		assertTrue(sumTarget.hasSumPairForTarget(array, TARGET));
	}

	/**
	 * Test SumTarget with input empty array.
	 */
	@Test
	public void emptyArrayInput() {
		int[] array = {};
		assertFalse(sumTarget.hasSumPairForTarget(array, TARGET));
	}
}