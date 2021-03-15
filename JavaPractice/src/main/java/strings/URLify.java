/** This question is from Cracking the Coding Interview
 *
 *  1.3 URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 *  has sufficient space at the end to hold the additional characters, and that you are given the "true"
 *  length of the string. (Note: if implementing in Java, please use a character array so that you can
 *  perform this operation in place.)
 *
 *  EXAMPLE
 *      Input:  "Mr John Smith    ", 13
 *      Output: "Mr%20John%20Smith"
 */

package strings;

public class URLify {

    // Use a character array and work backwards to fill the spaces with either the given or replacement characters
    // Then convert the character array into a string using the String.valueOf(array) method
    public static String urlifyStringSoln1(String string, int length) {
        char[] arrayOfChars = string.toCharArray();
        int index = length - 1;

        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(index) == ' ') {
                arrayOfChars[i] = '0';
                arrayOfChars[i - 1] = '2';
                arrayOfChars[i - 2] = '%';
                i = i - 2;
            } else {
                arrayOfChars[i] = string.charAt(index);
            }
            index--;
        }
        return String.valueOf(arrayOfChars);
    }

    // Use a StringBuilder to create the final string, replacing the spaces with '%20'
    public static String urlifyStringSoln2(String string, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == ' '){
                sb.append("%20");
            } else {
                sb.append(string.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(urlifyStringSoln1("Mr John Smith    ", 13));
        System.out.println(urlifyStringSoln2("Mr John Smith    ", 13));
    }
}
