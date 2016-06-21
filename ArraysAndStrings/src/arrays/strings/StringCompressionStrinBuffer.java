package arrays.strings;

public class StringCompressionStrinBuffer
{
	public static String compressString(String input)
	{
		char last = input.charAt(0);
		StringBuffer compressedStringBuffer = new StringBuffer();
		int count = 0;
		
		for(int i = 1; i<input.length() ; i++)
		{
			char now = input.charAt(i);
			if(last == now)
			{
				count++;
			}
			else {
					compressedStringBuffer.append(last);
					compressedStringBuffer.append(String.valueOf(count).length()+1);
					last = now;
					count = 1;
			     }
		}
		
		compressedStringBuffer.append(last);
		compressedStringBuffer.append(String.valueOf(count));
		
		String compressedString = compressedStringBuffer.toString();
		
		if(input.length() <= compressedString.length())
			return input;
		
		return compressedString;
	}
	
	public static void main(String[] args)
	{
		System.out.println(compressString("aabb"));
	}
}
