public class MaximumSumArray {

	public static void main(String[] args) {
//		 int[] intArr = { 3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
//		int[] intArr = { -1, 3, -5, 4, 6, -1, 2, -7, 13, -3 };
		// int[] intArr={-6,-2,-3,-4,-1,-5,-5};
//		 int[] intArr = { -1, -2, 3, 4, -5, 6 };
		int[] intArr = { -1, -2, -4,9 };
		findMaxSubArray(intArr);
		System.out.println(maxSubArraySum(intArr, intArr.length));
	}

	public static int maxSubArraySum(int a[], int size) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < size; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	public static void findMaxSubArray(int[] inputArray) {

		int maxStartIndex = 0;
		int maxEndIndex = 0;

		int maxCur = Integer.MIN_VALUE;
		int max = maxCur;

		for (int currentIndex = 0; currentIndex < inputArray.length; currentIndex++) {

			if (maxCur < 0) {
				maxCur = inputArray[currentIndex];
				maxStartIndex = currentIndex;
				maxEndIndex = currentIndex;
			}

			else {
				maxCur = maxCur + inputArray[currentIndex];
				maxEndIndex = currentIndex;
			}

			if (maxCur > max) {
				max = maxCur;
			}
		}

		System.out.println("Max sum         : " + max);
		System.out.println("Max start index : " + maxStartIndex);
		System.out.println("Max end index   : " + maxEndIndex);
	}
}