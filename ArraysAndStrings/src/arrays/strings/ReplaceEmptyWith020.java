package arrays.strings;

public class ReplaceEmptyWith020
{
	public static String replaceChars(String input)
	{
		int initialLength = input.length();
		int spaceCount = 0;
		
		for(int i =0 ;i< initialLength; i++)
		{
			if(input.charAt(i) == ' ')
			{
				spaceCount ++;
			}
		}

		int newLength = initialLength + spaceCount*2;
		if(spaceCount == 0)
		{
			return input;
		}

		char[] charArray = new char[initialLength + spaceCount * 2 + 1 ];
		
		for(int i = 0; i < initialLength ; i ++)
		{
			charArray[i] = input.charAt(i);
		}

		charArray[newLength] = '\0';

		for(int i = initialLength - 1 ; i >= 0 ; i--)
		{
			if(charArray[i] == ' ')
			{
				charArray[newLength - 1] = '0';
				charArray[newLength - 2] = '2';
				charArray[newLength - 3] = '%';

				newLength = newLength - 3;
			}
			else {
					charArray[newLength - 1] = charArray[i];
					newLength = newLength - 1;
				 }
		}

		return charArrayToString(charArray);
	}
	
	public static void main(String[] args)
	{
		System.out.println(replaceChars("7 8 0 "));
	}
	
	public static String charArrayToString(char[] array) 
	{
		StringBuilder buffer = new StringBuilder(array.length);
		for (char c : array)
		{
			if (c == 0) 
			{
				break;
			}
			buffer.append(c);
		}
		return buffer.toString();
	}
}
