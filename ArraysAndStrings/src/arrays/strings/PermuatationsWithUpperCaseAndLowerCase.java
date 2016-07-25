package arrays.strings;

public class PermuatationsWithUpperCaseAndLowerCase
{
	private static void printPermutations(String str)
	{
		printPermutations(str,new char[str.length()], 0);
	}
	
	private static void printPermutations(String word, char[] chars, int index)
	{
		if(index == word.length())
			System.out.println(chars);
		
		else
		{
			char lowerChar = Character.toLowerCase(word.charAt(index));
			chars[index]  = lowerChar;
			printPermutations(word, chars, index+1);
			
			char upperChar = Character.toUpperCase(word.charAt(index));
			chars[index]  = upperChar;
			printPermutations(word, chars, index+1);
		}
	}
	
	public static void main(String args[])
	{
		printPermutations("abc");
	}
}
