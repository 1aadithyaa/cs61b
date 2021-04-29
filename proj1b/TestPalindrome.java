import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset. */
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
        String pal1 = "";
        String pal2 = "a";
        String pal3 = "racecar";
        String npal1 = "bobb";
        String npal2 = "bbob";
        String npal3 = " 3lskfj";
        int len;
        Random random = new Random();
        for (int i = 0; i < 100; ++i) {
            len = 2 * random.nextInt(20);
            int j = 0;
            StringBuilder pal = new StringBuilder();
            while (j < len / 2) {
                char rc = (char) (random.nextInt(26) + 'a');
                pal.append(rc);
                pal.insert(0, rc);
                j++;
            }
            assertTrue(palindrome.isPalindrome(pal.toString()));
        }
        assertTrue(palindrome.isPalindrome(pal1));
        assertTrue(palindrome.isPalindrome(pal2));
        assertTrue(palindrome.isPalindrome(pal3));

        assertFalse(palindrome.isPalindrome(npal1));
        assertFalse(palindrome.isPalindrome(npal2));
        assertFalse(palindrome.isPalindrome(npal3));
    }

    @Test
    public void testIsPalindromeCC() {
        CharacterComparator offByOne = new OffByOne();
        String pal1 = "ab";
        String pal2 = "cd";
        String pal3 = "cad";
        String npal1 = "bob";
        String npal2 = "joj";
        String npal3 = " hoh";
        assertTrue(palindrome.isPalindrome(pal1,offByOne));
        assertTrue(palindrome.isPalindrome(pal2,offByOne));
        assertTrue(palindrome.isPalindrome(pal3,offByOne));
        assertFalse(palindrome.isPalindrome(npal1, offByOne));
        assertFalse(palindrome.isPalindrome(npal2, offByOne));
        assertFalse(palindrome.isPalindrome(npal3, offByOne));
    }
}
