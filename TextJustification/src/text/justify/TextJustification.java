package text.justify;
public class TextJustification
{
	public static void main(String[] args)
	{
		// replace input and maxLength with new values if you want to test with new inputs
		String input = "The quick brown fox jumps over the lazy dog.";
		int maxLength = 52;
		String output = myImpl(input, maxLength);
		System.out.println(output);
	}

	/**
	 * Justifies the input string to maxLength given.
	 * <p>
	 * If input string has just one word, justifying is not done and input is
	 * returned without change
	 * </p>
	 * <p>
	 * Trailing and leading white spaces are trimmed before justifying
	 * </p>
	 * <p>
	 * Difference between white spaces count between any two words in the output
	 * does not exceed one
	 * </p>
	 * 
	 * @throws IllegalArgumentException
	 *             if either of the following is true
	 *             <li>if input is either null</li>
	 *             <li>just white spaces</li>
	 *             <li>given max length is not greater than the max length</li>
	 * @param input
	 *            String to be justified
	 * @param maxLength
	 *            length of to justify the input string
	 * @return string after justifying the input string
	 */
	private static String myImpl(String input, int maxLength)
	{
		if (input == null || input.length() == 0 || input.trim().length() == 0)
		{
			throw new IllegalArgumentException("input string either null or just white spacesß");
		}

		String trimmed = input.trim();
		if (trimmed.length() > maxLength)
		{
			throw new IllegalArgumentException("max length should be greater that the string length");
		}

		int wordsCount = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
		int originalLength = trimmed.length();
		int noOfGaps = wordsCount - 1;

		if (noOfGaps == 0 || trimmed.length() == maxLength)
		{
			return input;
		}

		int characterCountWithOutSpaces = 0;
		for (int i = 0; i < originalLength; i++)
		{
			if (trimmed.charAt(i) != ' ')
			{
				characterCountWithOutSpaces++;
			}
		}

		int totalNumberOfSpacesToAdd = maxLength - characterCountWithOutSpaces;
		int noOfSpacesToAddToEachGap = totalNumberOfSpacesToAdd / noOfGaps;
		int remainingSpacesAfterDistribution = maxLength
				- ((noOfSpacesToAddToEachGap * noOfGaps) + characterCountWithOutSpaces);

		int[] gapsCountArray = new int[noOfGaps];
		for (int i = 0; i < gapsCountArray.length; i++)
		{
			gapsCountArray[i] = noOfSpacesToAddToEachGap;
		}

		int u = 0;
		while (remainingSpacesAfterDistribution != 0)
		{
			gapsCountArray[u] = gapsCountArray[u] + 1;
			u++;
			remainingSpacesAfterDistribution--;
		}

		StringBuffer sb = new StringBuffer();

		int i = 0;
		for (int o = 0; o < originalLength; o++)
		{
			if (trimmed.charAt(o) != ' ')
			{
				sb.append(trimmed.charAt(o));
			}

			else if (i < gapsCountArray.length)
			{
				for (int k = 0; k < gapsCountArray[i]; k++)
				{
					sb.append(" ");
				}
				i++;
			}
		}
		return sb.toString();
	}
}
