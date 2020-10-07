/** This question is from Firecode.io
 *
 * Write a method that takes in an input String and returns true if all the characters in the String are unique and
 * false if there is even a single repeated character. The method should return true if the input is null or empty String.
 *
 * Examples:
 *      Input: areAllCharactersUnique("abcde")   Output: true
 *      Input: areAllCharactersUnique("aa")      Output: false
 *      Input: areAllCharactersUnique("")        Output: true
 *      Input: areAllCharactersUnique(null)      Output: true
 */

package strings;

import java.util.HashSet;
import java.util.Set;

// Time: O(n) | Space: O(1)
public class UniqueCharsInAString {

    public static boolean areAllCharactersUnique(String str) {

        Set<Character> hashSet = new HashSet<>();

        if (str == null) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (hashSet.contains(str.charAt(i))) {
                return false;
            }
            hashSet.add(str.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "aa";
        String c = "";
        String d = null;
        System.out.println(areAllCharactersUnique(a));
        System.out.println(areAllCharactersUnique(b));
        System.out.println(areAllCharactersUnique(c));
        System.out.println(areAllCharactersUnique(d));
    }
}

