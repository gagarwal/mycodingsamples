package arrays.strings;

//https://www.youtube.com/watch?v=NdF1QDTRkck 4.37
public class PermutationsOfAString
{
	private static void printPermutations(String prefix, String rest)
	{
		int restLength = rest.length();
		if (restLength == 0)
			System.out.println(prefix);

		for (int i = 0; i < restLength; i++)
			printPermutations(prefix + rest.charAt(i), rest.substring(0, i) + rest.substring(i + 1, restLength));
	}

	public static void main(String[] args)
	{
		printPermutations("", "ab");
	}
}
