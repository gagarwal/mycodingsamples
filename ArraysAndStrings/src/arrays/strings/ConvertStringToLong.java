package arrays.strings;

public class ConvertStringToLong
{
	private static long stringToLong(String input)
	{
		if(!isInputValid(input))
			throw new IllegalArgumentException("input contains invalid characters");
		
		int length = input.length();
		int endIndex = length - 1;
		int startIndex = 0;
		long output = 0;
		boolean isInputNegative = false;
		
		if(input.charAt(startIndex) == '+')
			startIndex++;
		
		if(input.charAt(startIndex) == '-')
		{
			startIndex++;
			isInputNegative = true;
		}
		
		while(endIndex >= startIndex)
		{
			long value = input.charAt(endIndex--) - '0';
			if(output * 10 > Long.MAX_VALUE - value)
				throw new IllegalArgumentException("input exceeds long max value");
			output  = output * 10 + value;
		}
		
		if(isInputNegative)
			return -output;
		return output;
	}
	
	private static boolean isInputValid(String input)
	{
		int length = input.length();
		if(length == 0)
			throw new IllegalArgumentException("empty string is not an valid input");

		int index = 0;
		
		if(input.charAt(index) == '+' || input.charAt(index) == '-')
			index++;
		
		for( ; index<length; index++)
			if(input.charAt(index) > '9')
				return false;
		
		return true;
	}
	
	public static void main(String args[])
	{
		System.out.println(stringToLong("78787979979-"));
	}
}
