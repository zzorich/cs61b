import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

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

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertFalse(palindrome.isPalindrome("ccbb"));
        assertFalse(palindrome.isPalindrome("abc"));
        assertTrue(palindrome.isPalindrome("11211"));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        CharacterComparator offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("asb", offByOne));
        assertTrue(palindrome.isPalindrome("bsa", offByOne));
        assertFalse(palindrome.isPalindrome("aa", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
    }

}
