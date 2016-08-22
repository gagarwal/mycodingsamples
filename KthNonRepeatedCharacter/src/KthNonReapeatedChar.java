
public class KthNonReapeatedChar
{
	private static char  FindKthNonRepetitiveCharacter(String string, int strlen, int k)
	{
	    int[] charCnt = new int[26]; // stores count of chars 
	    int[] storesOrderOfChars = new int[26];   // stores order of chars
	    int  index, distinctCharCount = 0;                 

	    for (int i = 0; i < strlen; i++)
	    {
	        index = string.charAt(i) - 'a';
	        charCnt[index]= charCnt[index]+1;

	        if(charCnt[index] == 1) 
	        {  
	        	// only add newly discovered char.
	            storesOrderOfChars[distinctCharCount] = index;
	            distinctCharCount++;
	        }
	    }

	    int dc = 0;
	    for ( ; k > 0; dc++) 
	    {
	        if (charCnt[storesOrderOfChars[dc]] == 1)
	            k--;
	    }

	    int temp =(int) 'a';
	    int temp2=  storesOrderOfChars[dc-1] + temp;
	    return  ((char) temp2);
	}
	
	public static void main(String[] args)
	{
		System.out.println(FindKthNonRepetitiveCharacter("azcdctcy", 8, 4));
	}
}
