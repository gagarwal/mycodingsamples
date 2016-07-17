import java.util.ArrayList;

public class StackMultiThreading 
{

    private int size;
    private int maxSize;

    private final ArrayList<Object> list;

    public StackMultiThreading(int size)
    {
        this.size = 0;
        this.maxSize = size;
        this.list = new ArrayList<Object>(size);
    }

    public boolean push(Object o) 
    {
        if (size >= maxSize) 
        {
            return false;
        }

        this.list.add(0, o);
        this.size++;
        return true;
    }

    public Object pop() 
    {
        Object o;
        if (this.size == 0)
        {
            return null;
        }

        o = this.list.remove(0);
        this.size--;
        return o;
    }

    public int size() 
    {
        return this.size;
    }
    
    public static void main(String args[])
    {
    	final StackMultiThreading stack = new StackMultiThreading(4);
    	for(int i = 0; i < 10000; i++)
    	{
    	    final String data = "hello " + i;
    	    final int x = i;
    	    
    	    new Thread(new Runnable()
    	    {
    	        public void run() 
    	        {
    	            if(x % 2 == 0)
    	            {
    	                System.out.println(stack.push(data));
    	            } else 
    	            {
    	                System.out.println(stack.pop());
    	            }
    	        }
    	    }).start();
    	}
    }
}