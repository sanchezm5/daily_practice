/** This question is from Firecode.io
 *
 * Find the first non-duplicate character in a string. Return null if no unique character is found.
 *
 * Examples:
 *      firstNonRepeatedCharacter( "abcdcd" ) --> 'a'
 *      firstNonRepeatedCharacter( "cbcd" ) --> 'b'
 *      firstNonRepeatedCharacter( "cdcd" ) --> null
 */

package strings;

import java.util.HashMap;
import java.util.Map;

// Time: O(n) | Space: O(n)
public class FindTheFirstNonDuplicateCharInAString {

    public static Character firstNonRepeatedCharacter(String str) {

        Map<Character, Integer> hashMap = new HashMap<>();

        // loop through the string and store each character and the number of time it appears in a hashmap
        // increment the count if the character is already in the hashmap
        for (int i = 0; i < str.length(); i++) {
            if (!hashMap.containsKey(str.charAt(i))) {
                hashMap.put(str.charAt(i), 1);
            } else {
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
            }
        }
        // loop through the set of keys in the hashmap
        // return the key that is the first to have a count equal to 1
        for (char key: hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                return key;
            }
        }
        // otherwise return null
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacter("abcdcd")); // output: a
        System.out.println(firstNonRepeatedCharacter("cbcd")); // output: b
        System.out.println(firstNonRepeatedCharacter("cdcd")); // output: null
    }
}
