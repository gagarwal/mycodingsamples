package test.java;

import static org.junit.Assert.*;
import main.java.Palindrome;

import org.junit.Test;

/**
 * <p>
 * Test class for {@link Palindrome}
 * </p>
 * 
 * @author BK
 */
public class PalindromeTest
{

    /**
     * Tests empty string
     */
    @Test
    public void testEmptyString()
    {
        assertTrue(Palindrome.isPalindrome(""));
    }

    /**
     * Test string with just spaces.
     */
    @Test
    public void testStringWithSpaces()
    {
        assertTrue(Palindrome.isPalindrome("     "));
    }

    /**
     * Tests a string which is a palindrome.
     */
    @Test
    public void testPalindrome()
    {
        assertTrue(Palindrome.isPalindrome("abccba"));
    }

    /**
     * Tests a string which is not a palindrome.
     */
    @Test
    public void testNotPalindrome()
    {
        assertFalse(Palindrome.isPalindrome("abccba1"));
    }

    /**
     * Tests a string which is a palindrome by ignoring case.
     */
    @Test
    public void testPalindromeIgnoreCase()
    {
        assertTrue(Palindrome.isPalindrome("abccbA"));
    }

    /**
     * Tests a string which is a palindrome by ignoring case and special characters.
     */
    @Test
    public void testPalindromeIgnoreCaseWithSpecialCharacters()
    {
        assertTrue(Palindrome.isPalindrome("abccbA$$,"));
    }
}
