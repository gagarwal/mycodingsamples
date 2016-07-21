package arrays.strings;

public class OneStringPermutationOfOther
{
	public static boolean findBySorting(String s1, String s2)
	{
		if (s1.length() != s2.length()) 
			return false;

		char[] s1Chars = s1.toCharArray();
		
		java.util.Arrays.sort(s1Chars);
		
		String sortedS1 = new String(s1Chars);
		
		char[] s2schars = s2.toCharArray();
		java.util.Arrays.sort(s2schars);
		String sortedS2 = new String(s2schars);

		return sortedS1.equals(sortedS2);
	}
	
	public static boolean findByCount(String s1, String s2)
	{
		if (s1.length() != s2.length()) 
			return false;
		
		int[] charCount = new int[256];
		for(char c: s1.toCharArray())
			charCount[c]++;
		
		for(int i = 0; i< s2.length(); i++)
		{
			int chatAtI = s2.charAt(i);
			if(--charCount[chatAtI] < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(findByCount("789","987"));
	}
}
