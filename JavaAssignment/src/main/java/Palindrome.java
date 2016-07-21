package main.java;

/**
 * <p>
 * Program to find out whether given string is palindrome or not by ignoring case and special characters. 
 * <p>
 * Examples; 'A', 'AA', 'Aa', 'ghhj^^,'
 * </p>
 * 
 * @author BK
 */
public class Palindrome
{

    /**
     * 
     * @param testString
     *            String value to test whether it is palindrome or not
     * @return True if the given string is palindrome (ignores case and special characters), False
     *         other wise.
     */
    public static boolean isPalindrome(final String testString)
    {
        int startIndex = 0;
        int endIndex = testString.length() - 1;

        while (endIndex > startIndex)
        {
            char startChar = Character.toLowerCase(testString.charAt(startIndex)); // Compare character by character
            char endChar = Character.toLowerCase(testString.charAt(endIndex));

            // check whether start character is special character, if so loop until you get a letter digit
            while (!Character.isLetterOrDigit(startChar) && startIndex < endIndex)
                startChar = Character.toLowerCase(testString.charAt(++startIndex));

            // check whether last character is special character, if so loop until you get a letter/digit
            while (!Character.isLetterOrDigit(endChar) && startIndex < endIndex)
                endChar = Character.toLowerCase(testString.charAt(--endIndex));

            // compare first and last characters, if they are not same return false
            if (startChar != endChar)
                return false;

            startIndex++;
            endIndex--;
        }
        return true;
    }
}
