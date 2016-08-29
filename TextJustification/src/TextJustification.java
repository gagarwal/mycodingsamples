import java.util.ArrayList;
import java.util.List;

public class TextJustification
{
	public static List<String> fullJustify(String[] words, int maxWidth)
	{
		List<String> result = new ArrayList<>();
		if (words == null || words.length == 0 || maxWidth < 0)
		{
			return result;
		}

		if (maxWidth == 0)
		{
			result.add("");
			return result;
		}

		fullJustifyHelper(0, words, result, maxWidth);

		return result;
	}

	private static void fullJustifyHelper(int start, String[] words, List<String> result, int L)
	{
		if (start >= words.length)
		{
			return;
		}

		int total = 0;
		int len = 0;
		int next = -1;
		int i = start;

		while (i < words.length && total < L)
		{
			total += words[i].length();

			if (total > L)
			{
				next = i;
				break;
			}

			len += words[i].length();
			total++;
			i++;
		}

		if (next == -1)
		{
			next = i;
		}

		addLists(words, start, next, result, len, L);

		fullJustifyHelper(next, words, result, L);
	}

	private static void addLists(String[] words, int start, int next, List<String> result, int len, int L)
	{
		int slots = next - start - 1;
		StringBuffer sb = new StringBuffer();
		// Last line or only one word in a line
		if (slots == 0 || next == words.length)
		{
			for (int i = start; i < next; i++)
			{
				sb.append(words[i]);
				if (i == next - 1)
				{
					break;
				}
				sb.append(" ");
			}

			int trailingSpace = L - len - slots;
			for (int i = 0; i < trailingSpace; i++)
			{
				sb.append(" ");
			}

			result.add(sb.toString());
		} else
		{
			int aveSpace = (L - len) / slots;
			int moreSpace = (L - len) % slots;
			for (int i = start; i < next; i++)
			{
				sb.append(words[i]);
				if (i == next - 1)
				{
					break;
				}
				for (int j = 0; j < aveSpace; j++)
				{
					sb.append(" ");
				}

				if (moreSpace > 0)
				{
					sb.append(" ");
					moreSpace--;
				}
			}
			result.add(sb.toString());
		}
	}

	public static void main(String[] args)
	{
		String output = myImpl("The quick brown fox jumps over the lazy dog.", 52);
		System.out.println(output.equals("The  quick  brown  fox  jumps  over  the  lazy  dog."));
		System.out.println(output + output.length());
	}

	private static String myImpl(String string, int maxLength)
	{
		int originalLength = string.length();
		/// my name is Bindu, 50

		String trimmed = string.trim();
		int wordsCount = trimmed.isEmpty() ? 0 : trimmed.split("\\s+").length;
		// wordsCount = 4

		int noOfGaps = wordsCount - 1;
		// noOfGaps = 3

		int characterCountNoSpace = 0;
		for (int i = 0; i < originalLength; i++)
		{
			if (string.charAt(i) != ' ')
			{
				characterCountNoSpace++;
			}
		}

		int totalNumberOfSpacesToAdd = maxLength - characterCountNoSpace;
		int noOfSpacesToAddToEachGap = totalNumberOfSpacesToAdd / noOfGaps;
		int remainingGaps = maxLength - ((noOfSpacesToAddToEachGap * noOfGaps) + characterCountNoSpace);

		int[] gapsArray = new int[noOfGaps];
		for (int i = 0; i < gapsArray.length; i++)
		{
			gapsArray[i] = noOfSpacesToAddToEachGap;
		}

		int u = 0;
		while (remainingGaps != 0)
		{
			gapsArray[u] = gapsArray[u] + 1;
			u++;
			remainingGaps--;
		}

		StringBuffer sb = new StringBuffer();

		int i = 0;
		while (i < noOfGaps)
		{
			for (int j = 0; j < originalLength; j++)
			{
				if (string.charAt(j) != ' ')
				{
					sb.append(string.charAt(j));
				}

				else
				{
					for (int k = 0; k < gapsArray[i]; k++)
					{
						sb.append(" ");
					}

//					if (i == noOfGaps - 1)
//					{
//						for (int l = 0; l < remainingGaps; l++)
//						{
//							sb.append(" ");
//						}
//					}
					i++;
				}

			}
		}

		return sb.toString();
	}
}
