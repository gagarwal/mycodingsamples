import java.util.Random;

public class RandomNumberGenerator {

	public static void main(String args[]) {
		Random ran = new Random();
		int x = ran.nextInt(6) + 5;
	}

	private static void permuatationsWithRepetetions(String prefix, String str) {
		if (prefix.length() == str.length()) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < str.length(); i++)
			permuatationsWithRepetetions(prefix + str.charAt(i), str);
	}
}
