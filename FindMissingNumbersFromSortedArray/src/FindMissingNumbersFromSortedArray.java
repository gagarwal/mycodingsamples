import java.util.ArrayList;

public class FindMissingNumbersFromSortedArray {
	public static void main(String args[]) {
		int[] nums = { 2, 4, 5, 7 };
		//System.out.println(findMissingNumbers(nums));
		System.out.println(removeElement(nums, 5));
	}

	public static ArrayList<Integer> findMissingNumbers(int[] a) {

		int i = a[0];
		ArrayList<Integer> missing = new ArrayList<Integer>();

		for (int j = 0; j < a.length; j++) {
			if (a[j] == i) {

			}

			else {
				missing.add(i);
				j--;
			}
			i++;
		}
		return missing;
	}
	
	public static int removeElement(int[] A, int elem)
    {
        int i = 0;
        int j = 0;

        while (j < A.length )
        {
            if (A[j] != elem)
            {
                A[i] = A[j];
                i++;
            }

            j++;
        }

        for(int k=0;k< A.length;k++)
        {
        	System.out.print(A[k]+" ");
        }
        
        System.out.println();
        return i-1;
    }
}
