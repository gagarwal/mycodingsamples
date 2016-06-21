package arrays.strings;

public class CircualrArrayBinarySearch
{
	public static int findInCircularlyBinaryArray(int[] array, int key)
	{
		int index = -1, low = 0, high = array.length-1, mid;
		if(high == -1) return index;
		while (low <= high)
		{
			mid = (low+high) / 2;
			
			if(array[mid] == key)
				return mid;
			else if (array[low] < array[mid-1])
			{
				if(array[low] < key && key < array[mid-1])
					high = mid - 1;
				else 
					low = mid + 1;
			}
			else {
				 	if(array[mid+1] < key && key < array[high])
				 		low = mid + 1;
				 	else
				 		high = mid - 1;
			     }
			
		}
		return index;
	}
	
	public static void main(String[] args)
	{
		int[] array = {2,3,4,5,6,7,1};
		System.out.println(findInCircularlyBinaryArray(array, 78));
	}
}
