package helper;

import java.util.ArrayList;
import java.util.List;

public class SumOfNFibonocciNumbers 
{
	static List<Integer> fibonocci = new ArrayList<>();
	static List<Integer> fibonocciSum = new ArrayList<>();
	
	private static int populateFibonocci(int n)
	{
		if(fibonocciSum.size() >= n)
			return fibonocciSum.get(n-1);
		
		if(fibonocci.size() == 0)
		{
			fibonocci.add(0); fibonocci.add(1);
			fibonocciSum.add(0); fibonocciSum.add(1);
		}
		
		for(int i = fibonocciSum.size() ; i < n; i++)
		{	
			fibonocci.add(fibonocci.get(i-1)+ fibonocci.get(i-2));
			fibonocciSum.add(fibonocciSum.get(i-1) + fibonocci.get(i));
		}	
		
		return fibonocciSum.get(n-1);
	}	
	
	public static void main(String[] args) 
	{
		System.out.println(populateFibonocci(8));
		System.out.println(populateFibonocci(5));
	}
}
