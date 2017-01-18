import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MapImpl<K, V>
{
	private int size;
	private int DEFAULT_CAPACITY = 16;
	private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];

	public V get(K key)
	{
		for (int i = 0; i < size; i++)
		{
			if (values[i] != null)
			{
				if (values[i].getKey().equals(key))
				{
					return values[i].getValue();
				}
			}
		}
		return null;
	}

	public Boolean put(K key, V value)
	{
		boolean exists = false;
		for (int i = 0; i < size; i++)
		{
			if (values[i].getKey().equals(key))
			{
				exists = true;
				values[i].setValue(value);
				return true;
			}
		}

		if (!exists)
		{
			increaseCapacity();
			values[size++] = new MyEntry<K, V>(key, value);
			return true;
		}
		return null;
	}

	private void increaseCapacity()
	{
		if (size == values.length)
		{
			int newSize = values.length * 2;
			values = Arrays.copyOf(values, newSize);
		}
	}

	public int size()
	{
		return size;
	}

	public Object remove(K key)
	{
		for (int i = 0; i < size; i++)
		{
			if (values[i].getKey().equals(key))
			{
				K temp = values[i].getKey();
				values[i] = null;
				size--;
				condenseArray(i);
				return temp;
			}
		}
		return null;
	}

	private void condenseArray(int start)
	{
		for (int i = start; i < size; i++)
		{
			values[i] = values[i + 1];
		}
	}

	public Set<K> keySet()
	{
		Set<K> set = new HashSet<K>();
		for (int i = 0; i < size; i++)
		{
			set.add(values[i].getKey());
		}
		return set;
	}
	
	public void clear()
	{
		values = new MyEntry[DEFAULT_CAPACITY];
	}

	public boolean isEmpty()
	{
		return size == 0;
	}
}