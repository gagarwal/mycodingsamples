
public class PrintPermutationReplaceQuestionMarkWith1Or0
{
	private static void printPermutations(String str)
	{
		printPermutations(str, new char[str.length()], 0);
	}

	private static void printPermutations(String word, char[] chars, int index)
	{
		if (index == word.length())
			System.out.println(chars);

		else
		{
			if (word.charAt(index) == '?')
			{
				chars[index] = '1';
				printPermutations(word, chars, index + 1);

				chars[index] = '0';
				printPermutations(word, chars, index + 1);
			}

			else
			{
				chars[index] = word.charAt(index);
				printPermutations(word, chars, index + 1);
			}
		}
	}

	public static void main(String args[])
	{
		printPermutations("abc?");
	}
}
