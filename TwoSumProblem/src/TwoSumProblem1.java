import java.util.HashMap;

public class TwoSumProblem1 {

	public static void main(String args[]) {
		int a[] = { 2, 5 };
		// System.out.println(countInterative(a));

		System.out.println(twoSum1(a, 7).length);
	}

	private static int[] twoSum1(int[] numbers, int target) {
		if (numbers.length >= 2) {
			HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
			
			for (int i = 0; i < numbers.length; i++) {
				
				if (!h.isEmpty() && h.containsKey(target - numbers[i])) {
					int[] k = { h.get(target - numbers[i]) + 1, i + 1 };
					return k;
				}

				h.put(numbers[i], i);
			}
		}

		int[] k = { -1, -1 };
		return k;
	}

}
