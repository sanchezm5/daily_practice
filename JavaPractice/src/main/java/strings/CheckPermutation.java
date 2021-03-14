/** This question is from Cracking the Coding Interview
 *
 *  1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 */

package strings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public static boolean checkPermutation(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < str1.length(); i++) {
            if(!hashMap.containsKey(str1.charAt(i))) {
                hashMap.put(str1.charAt(i), 1);
            } else {
                hashMap.put(str1.charAt(i), hashMap.get(str1.charAt(i)) + 1);
            }
        }
        for(int j = 0; j < str2.length(); j++) {
            if(!hashMap.containsKey(str2.charAt(j))) {
                return false;
            } else {
                hashMap.replace(str2.charAt(j), hashMap.get(str2.charAt(j)) - 1);
                hashMap.remove(str2.charAt(j), 0);
            }
        }
        if (!hashMap.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("abcdd", "bdcda"));  // true
        System.out.println(checkPermutation("abc", "bbac"));     // false
        System.out.println(checkPermutation("happy", "papyp"));  // false
    }
}
