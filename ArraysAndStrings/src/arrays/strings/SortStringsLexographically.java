package arrays.strings;

public class SortStringsLexographically 
{
	public static String[] sortStrings(String[] array)
	{
		int left = 0;
		int right = array.length;
		for (int i = left; i < right; i++)
		{
			for (int j = i+1; j < right ; j++)
			{
				if (array[i].compareTo(array[j]) > 0)
				{
					String temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String args[])
	{
		String[] array = new String[] {"Jenny", "Rob", "Dereck", "Mike", "Kristin"};
	    sortStrings(array);
		for(String string:array)
			System.out.println(string);
	}
}
