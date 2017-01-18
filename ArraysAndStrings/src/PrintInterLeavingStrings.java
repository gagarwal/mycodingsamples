
public class PrintInterLeavingStrings
{
	public static void printInterLeavingStrings(String s1, String s2, String soFar)
	{
		if ((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0))
			return;
		
		if(s1 == null || s1.length() == 0)
		{	
			System.out.println("  "+ soFar +" "+ s2 +" ");
			return;
		}
		
		if(s2 == null || s2.length() == 0)
		{	
			System.out.println("  "+ soFar + " " + s1 );
			return;
		}
		
		printInterLeavingStrings(s1.substring(1), s2, soFar+s1.charAt(0));
		printInterLeavingStrings(s1, s2.substring(1), soFar+s2.charAt(0));
	}
	
	public static void main(String args[])
	{
       printInterLeavingStrings("ab", "c", "");
    }
}
