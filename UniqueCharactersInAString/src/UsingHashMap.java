import java.util.HashMap;
import java.util.HashSet;

public class UsingHashMap {

	public static void main(String args[]) {

		char[] charArray = args[0].toCharArray();

		int length = charArray.length;
		
		 charMap = new HashSet(length);
		
		for (int i = 0; i < length; i++) {

			if(charMap.keySet().contains(charArray[0]))
			{
				return;
			}
		}
	}
}
