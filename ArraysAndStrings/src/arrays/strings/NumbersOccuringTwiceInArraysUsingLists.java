package arrays.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NumbersOccuringTwiceInArraysUsingLists 
{
	private static void print()
	{
		int[][] arrays = { { 6, 2, 2, 0, 4 }, { 5, 0, 2, 6, 7, 1 }, { 6, 7, 9, 9, 0 } };
		Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		
		for(int i = 0; i< arrays.length; i++)
		{
			for(int j = 0; j< arrays[i].length; j++)
			{
				HashSet<Integer> arrayNumbers = map.get(arrays[i][j]);
				
				if(arrayNumbers != null)
					arrayNumbers.add(i);
				else 
					{
						HashSet<Integer> set = new HashSet<Integer>();
						set.add(i);
						map.put(arrays[i][j], set);
					}
			}	
		}	
		
		for(Map.Entry<Integer, HashSet<Integer>> entry: map.entrySet())
		{
			if(entry.getValue().size() == 2)
				System.out.println(entry.getKey());
		}	
	}
	
	 public static void main(String args[])
	 {
		 print();
     }
}