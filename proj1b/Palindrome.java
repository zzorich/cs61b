import java.util.Locale;

public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque result = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    /* Iterative version
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        while (wordDeque.size() > 1) {
            if (wordDeque.removeFirst() != wordDeque.removeLast()) {
                return false;
            }
        }
        return true;
    }
    */

    /* recursive version, short circuit*/
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word.toLowerCase(Locale.ROOT));
        return isPalindrome(wordDeque);
    }

    private boolean isPalindrome(Deque wordDeque) {
        if (wordDeque.size() <= 1) {
            return true;
        }
        return wordDeque.removeFirst() == wordDeque.removeLast()
                && isPalindrome(wordDeque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word.toLowerCase(Locale.ROOT));
        return isPalindrome(wordDeque, cc);
    }

    private boolean isPalindrome(Deque wordDeque, CharacterComparator cc) {
        if (wordDeque.size() <= 1) {
            return true;
        }
        return cc.equalChars(((char) wordDeque.removeFirst()), ((char) wordDeque.removeLast()))
                && isPalindrome(wordDeque, cc);
    }


}
