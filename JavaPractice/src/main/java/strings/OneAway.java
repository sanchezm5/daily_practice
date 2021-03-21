/** This question is from Cracking the Coding Interview
 *
 *  1.5 One Away: There are three types of edits that can be performed on strings: insert a character,
 *  remove a character, or replace a character. Given two strings, write a function to check if they are one edit
 *  (or zero edits) away.
 *
 *  EXAMPLE
 *      pale, ple -> true
 *      pales, pale -> true
 *      pale, bale -> true
 *      pale, bae -> false
 */

package strings;

public class OneAway {

    public static boolean isOneEditAway(String str1, String str2) {

        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        String s1 = str1.length() < str2.length() ? str1 : str2;
        String s2 = str1.length() < str2.length() ? str2 : str1;

        int i = 0;
        int j = 0;
        boolean changeFound = false;
        while (i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) != s2.charAt(j)) {
                if (changeFound) {
                    return false;
                }
                changeFound = true;

                if(s1.length() == s2.length()) {
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditAway("pales", "pale"));
    }
}
