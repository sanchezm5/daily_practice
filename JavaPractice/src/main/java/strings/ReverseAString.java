/** This question is from Firecode.io
 *
 * Write a method that takes in a String and returns the reversed version of the String.
 * Examples:    reverseString("abcde") -> "edcba"
 *              reverseString("1") -> "1"
 *              reverseString("") -> ""
 *              reverseString("madam") -> "madam"
 *              reverseString(null) -> null
 */

package strings;

public class ReverseAString {

    public static String reverseString(String str) {
        String inputString = str;
        String outputString = "";

        if (inputString == null || inputString == "") {
            return str;
        }
        for (int i = inputString.length() - 1; i >= 0; i--) {
            outputString += inputString.charAt(i);
        }
        return outputString;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcde"));
        System.out.println(reverseString(null));
        System.out.println(reverseString(""));
    }
}
