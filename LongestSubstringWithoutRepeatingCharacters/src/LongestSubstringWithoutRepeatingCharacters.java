import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters
{
	public static void main(String args[])
	{
		LongestSubstringWithoutRepeatingCharacters instance = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(instance.findLengthOfLongestSubstringWithoutRepeatingCharacters("adcbce"));
		System.out.println(instance.findLengthOfLongestSubstringWithoutRepeatingCharactersOptimized("abba"));
	}

	// using sliding window
	private int findLengthOfLongestSubstringWithoutRepeatingCharacters(String input)
	{
		if (input == null)
			throw new IllegalArgumentException("input should not be null");

		int inputLength = input.length();
		int substringLength = 0;

		if (inputLength == 0)
			return substringLength;

		Set<Character> set = new HashSet<>();

		for (int i = 0, j = 0; i < inputLength && j < inputLength;)
		{
			Character currentChar = input.charAt(j);
			if (!set.contains(currentChar))
			{
				set.add(input.charAt(j));
				substringLength = Math.max(substringLength, j - i + 1);
				j++;
			} else
			{
				set.remove(input.charAt(i));
				i++;
			}
		}

		return substringLength;
	}

	private int findLengthOfLongestSubstringWithoutRepeatingCharactersOptimized(String input)
	{
		if (input == null)
			throw new IllegalArgumentException("input should not be null");

		int inputLength = input.length();
		int substringLength = 0;

		if (inputLength == 0)
			return substringLength;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0, j = 0; j < inputLength; j++)
		{
			Character currentChar = input.charAt(j);
			if (map.containsKey(currentChar))
			{
				i = Math.max(i, map.get(currentChar) + 1);
			}

			substringLength = Math.max(substringLength, j - i + 1);
			map.put(currentChar, j);
		}

		return substringLength;
	}
}
