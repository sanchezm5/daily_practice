/** This question is from Firecode.io
 *
 * Implement a method that checks if two strings are permutations of each other.
 *
 * Examples:
 *      permutation("CAT","ACT") --> true
 *      permutation("hello","aloha") --> false
 */

package strings;

import java.util.HashMap;
import java.util.Map;

// Time: O(n) | Space: O(n)
public class Permutations {

    public static boolean permutation(String str1, String str2) {

        // if the lengths of the strings are not equal, return false;
        if (str1.length() != str2.length()) {
            return false;
        }

        // create a hashmap to store each character in the first string along with its count
        Map<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if (!hashMap.containsKey(str1.charAt(i))) {
                hashMap.put(str1.charAt(i), 1);
            } else {
                hashMap.put(str1.charAt(i), hashMap.get(str1.charAt(i) + 1));
            }
        }

        // loop through the second string and check if the hashmap contains the character
        // if it doesn't return false, otherwise return once you iterate over the entire string
        for (int j = 0; j < str2.length(); j++) {
            if (!hashMap.containsKey(str2.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(permutation("CAT", "ACT"));
        System.out.println(permutation("hello", "aloha"));
    }
}

