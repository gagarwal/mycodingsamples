package arrays.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NumbersOccuringTwiceInArraysUsingPair 
{
	private static void print()
	{
		int[][] arrays = { { 6, 2, 2, 0, 4 }, { 5, 0, 2, 6, 7, 1 }, { 6, 7, 9, 9, 0 } };
		Map<Pair<Integer, Integer>, Integer> map = new HashMap<Pair<Integer, Integer>, Integer>();
		
		for(int i = 0; i< arrays.length; i++)
		{
			for(int j = 0; j< arrays[i].length; j++)
			{
				Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i, arrays[i][j]);
				
				if(!map.containsKey(pair))
					map.put(pair, 1);
				
			}	
		}	
		
		int count = 0;
		for(Map.Entry<Pair<Integer, Integer>, Integer> entry : map.entrySet())
		{
			if(entry.getKey().second == 0)
				count++;
				
		}
	
		System.out.println(count);	
	}
	
	 public static void main(String args[])
	 {
		 print();
     }
	 
	 public static class Pair<F, S> 
	 {
		    public final F first;
		    public final S second;

		    /**
		     * Constructor for a Pair.
		     *
		     * @param first the first object in the Pair
		     * @param second the second object in the pair
		     */
		    public Pair(F first, S second)
		    {
		        this.first = first;
		        this.second = second;
		    }

		    /**
		     * Checks the two objects for equality by delegating to their respective
		     * {@link Object#equals(Object)} methods.
		     *
		     * @param o the {@link Pair} to which this one is to be checked for equality
		     * @return true if the underlying objects of the Pair are both considered
		     *         equal
		     */
		    @Override
		    public boolean equals(Object o) 
		    {
		        if (!(o instanceof Pair))
		        {
		            return false;
		        }
		        Pair<?, ?> p = (Pair<?, ?>) o;
		        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
		    }

		    /**
		     * Compute a hash code using the hash codes of the underlying objects
		     *
		     * @return a hashcode of the Pair
		     */
		    @Override
		    public int hashCode() 
		    {
		        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
		    }

		    /**
		     * Convenience method for creating an appropriately typed pair.
		     * @param a the first object in the Pair
		     * @param b the second object in the pair
		     * @return a Pair that is templatized with the types of a and b
		     */
		    public <A, B> Pair <A, B> create(A a, B b)
		    {
		        return new Pair<A, B>(a, b);
		    }
		}
}