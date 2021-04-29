/**
 *
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    /**
     * Returns true if the word is a palindrome and false otherwise
     * Any word of length 1 or 0 is a palindrome
     * Case sensitive
     * @param word Word that we want to check is a palindrome
     */
    public boolean isPalindrome(String word) {
        Deque<Character> c = wordToDeque(word);
        while (c.size() >= 2) {
            char f = c.removeFirst();
            char l = c.removeLast();
            if (f != l) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> c = wordToDeque(word);
        while (c.size() >= 2) {
            char f = c.removeFirst();
            char l = c.removeLast();
            if (!cc.equalChars(f, l)) {
                return false;
            }
        }
        return true;
    }
}
