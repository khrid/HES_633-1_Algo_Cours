public class TestPalindrome {

    public static void main(String[] args) {
        String words[] = {"palindrome", "test", "sugus"};
        for (String word: words
             ) {
            System.out.println(word + " : " + palindrome(word));
        }
    }

    public static boolean palindrome(String word) {
        int size = word.length();

        // Clause de finitude
        if(size == 0 || size == 1) {
            return true;
        }

        // Pas récursif
        if(word.charAt(0) == word.charAt(size-1)) {
            return palindrome(word.substring(1, size-1));
        } else {
            return false;
        }
    }
}
