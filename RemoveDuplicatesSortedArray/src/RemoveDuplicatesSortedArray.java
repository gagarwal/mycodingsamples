import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
	public static void main(String args[]) {
		int[] nums = { 1, 2,3 , 4, 5, 5 };
		System.out.println(removeDuplicates2(nums));
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

	public static int removeDuplicates2(int[] A) {
		if (A.length < 2)
			return A.length;

		int j = 0;
		int i = 1;

		while (i < A.length) 
		{
			if (A[i] != A[j])
			{
				j++;
				A[j] = A[i];
			}
			i++;
		}

		int[] B = Arrays.copyOf(A, j + 1);
		return B.length;
	}
}