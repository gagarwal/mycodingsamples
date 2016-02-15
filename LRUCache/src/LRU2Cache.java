
public class LRU2Cache {

	public static void main(String args[]) {
		LRU2 cache = new LRU2(3);

		cache.set(6, 7);
		cache.set(8, 9);
		cache.set(6, 10);

		// cache.set(8, 8);
		// cache.set(9, 10);
		System.out.println(cache.get(6));
		System.out.println(cache.get(4));
	}
}
