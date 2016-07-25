package arrays.strings;

public class ReverseString
{
	public static String reverseString(String input)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = input.length() - 1; i >= 0; i--)
			sb.append(input.charAt(i));

		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(reverseString("80"));
	}
}
