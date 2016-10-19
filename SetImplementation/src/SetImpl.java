public class SetImpl<E>
{
	private MapImpl<E, Object> map;

	public SetImpl()
	{
		map = new MapImpl<>();
	}

	public boolean add(E e)
	{
		return map.put(e, e) == null;
	}

	public boolean remove(E o)
	{
		return map.remove(o) != null;
	}
	
	public void clear()
	{
		map.clear();
	}
	
	public boolean isEmpty() 
	{
        return map.isEmpty();
    }
}
