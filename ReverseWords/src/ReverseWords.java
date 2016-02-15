import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {

	public String reverseWords(String s) {
		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
	}

}

