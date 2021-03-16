/** This question is from Cracking the Coding Interview
 *
 *  1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 *  A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of
 *  letters. The palindrome does not need to be limited to just dictionary words.
 *
 *  EXAMPLE
 *      Input: "Tact Coa"
 *      Output: True (permutations: "taco cat"; "atco eta"; etc.)
 */

package strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    public static boolean isPalindromePermutation(String string) {
        Map<Character, Integer> hashMap = new HashMap<>();
        String givenStr = string.toLowerCase();

        for (int i = 0; i < givenStr.length(); i++) {
            if (!hashMap.containsKey(givenStr.charAt(i)) && givenStr.charAt(i) != ' ') {
                hashMap.put(givenStr.charAt(i), 1);
            } else {
                hashMap.remove(givenStr.charAt(i));
            }
        }
        if (hashMap.size() <= 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa"));
    }
}
