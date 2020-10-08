/** This question is from Firecode.io
 *
 * A palindrome is a string or sequence of characters that reads the same backward as forward.
 * For example, "madam" is a palindrome. Write a method that takes in a String and returns a boolean -> true if the input
 * String is a palindrome and false if it is not. An empty string and a null input are considered palindromes. You also
 * need to account for the space character. For example, "race car" should return false as read backward it is "rac ecar".
 *
 * Examples:
 *      Input: isStringPalindrome("madam")      Output: true
 *      Input: isStringPalindrome("aabb")       Output: false
 *      Input: isStringPalindrome("race car")   Output: false
 *      Input: isStringPalindrome("")           Output: true
 *      Input: isStringPalindrome(null)         Output: true
 */

package strings;

// Time: O(n) | Space: O(1)
public class PalindromeTester {

    // Solution 1: Compare reversed string to original string
    public static boolean isStringPalindromeSoln1(String str) {
        // Empty and null strings are considered a palindrome
        if (str == null) return true;

        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return str.equals(reversed);
    }

    // Solution 2: Compare first character to last character, then second to second-to-last and so on
    public static boolean isStringPalindromeSoln2(String str) {
        // If the length is < 1, return true
        if(str == null || str.length() < 1) return true;

        // Run a for loop from 0 to length/2
        for (int i = 0; i <= str.length() / 2; i++) {
            // Compare the first char with the last char, if not the same, return false
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        // Otherwise, return true
        return true;
    }

    public static void main(String[] args) {
        // Palindromes --> true
        System.out.println(isStringPalindromeSoln1("madam"));
        System.out.println(isStringPalindromeSoln2("racecar"));
        // Not Palindromes --> false
        System.out.println(isStringPalindromeSoln1("aabb"));
        System.out.println(isStringPalindromeSoln2("aac"));
        // Null --> true
        System.out.println(isStringPalindromeSoln1(null));
        System.out.println(isStringPalindromeSoln2(null));
        // Empty Strings --> true
        System.out.println(isStringPalindromeSoln1(""));
        System.out.println(isStringPalindromeSoln2(""));
    }
}

