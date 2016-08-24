import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintAllAnagramsInArrayOfStrings
{
	public static List<List<String>> groupAnagrams(String[] strs)
	{
		List<List<String>> result = new ArrayList<List<String>>();

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs)
		{
			char[] arr = new char[26];
			for (int i = 0; i < str.length(); i++)
			{
				arr[str.charAt(i) - 'a']++;
			}
			String ns = new String(arr);

			if (map.containsKey(ns))
			{
				map.get(ns).add(str);
			} else
			{
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}
		result.addAll(map.values());
		return result;
	}

	public static void main(String[] args)
	{
		String[] testString =
		{ "abc", "cab" };

		List<List<String>> result = groupAnagrams(testString);
		for (List<String> temp1 : result)
		{
			for (String str : temp1)
				System.out.print(str + " ");
			System.out.println();
		}
	}
}
