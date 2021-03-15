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

    public static String urlifyString(String string, int length) {
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

    public static void main(String[] args) {
        System.out.println(urlifyString("Mr John Smith    ", 13));
    }
}
