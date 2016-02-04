public class RemoveDuplicatesSortedArray {
	public static void main(String args[]) {
		int[] nums = { 1 };
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {

		int i = nums.length > 0 ? 1 : 0;
		int distinctElemenCount = 0;

		for (int n : nums) {
			if (n > nums[i - 1]) {
				distinctElemenCount = i;
				nums[i++] = n;
			}
		}

		for (int k = 0; k < distinctElemenCount; k++)
			System.out.print(nums[k] + " ");
		return i;
	}
}
