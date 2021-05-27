import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } 
//    Uncomment this class once you've created your Palindrome class. */
    
    @Test
    public void testPalindrome() {
    	assertFalse(palindrome.isPalindrome("cat"));
    	assertTrue(palindrome.isPalindrome("racecar"));
    	assertTrue(palindrome.isPalindrome("a"));
    	assertFalse(palindrome.isPalindrome("aA"));
    	assertTrue(palindrome.isPalindrome("reoer"));
    	assertTrue(palindrome.isPalindrome("reer"));
    	assertTrue(palindrome.isPalindrome(""));
    }
    
    
    @Test
    public void testPalindrome2() {
    	assertTrue(palindrome.isPalindrome("flake", new OffByOne()));
    	assertFalse(palindrome.isPalindrome("racecar", new OffByOne()));
    }
}
