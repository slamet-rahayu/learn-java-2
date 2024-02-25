import java.util.ArrayList;

public class testfunction {
    public static void main(String[] args) {
        String word = "apa";
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String str) {
        // Remove spaces and convert the string to lowercase
        str = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        ArrayList<Character> charsLeft = new ArrayList<Character>();

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Characters at the left and right positions do not match
            }
            left++;
            right--;
            charsLeft.add(str.charAt(left));
        }

        System.out.println(charsLeft);

        return true; // All characters matched, so it's a palindrome
    }
}
