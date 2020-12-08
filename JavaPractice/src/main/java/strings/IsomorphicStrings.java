/** This question is from Firecode.io
 *
 * Given two strings - input1 and input2, determine if they are isomorphic.
 * Two strings are isomorphic if the letters in one string can be remapped to get the second string. Remapping a letter
 * means replacing all occurrences of it with another letter. The ordering of the letters remains unchanged. You can
 * also think of isomorphism as it is used in chemistry - i.e. having the same form or overall shape. Target linear
 * time and space complexity with your solution.
 *
 * Examples:
 * Input 1 : css        Output  : true
 * Input 2 : dll
 *
 * Input 1 : css        Output  : false
 * Input 2 : dle
 *
 * Input 1 : abcabc     Output  : true
 * Input 2 : xyzxyz
 *
 * Input 1 : abcabc     Output  : false
 * Input 2 : xbexyz
 */

package strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String input1, String input2) {
        // if input strings are empty, return true
        if (input1 == "" && input2 == "") return true;

        // create a hashmap to store characters in the input strings which will be compared
        Map<Character, Character> hashMap = new HashMap<>();

        for (int i = 0; i < input1.length(); i++) {
            // if the hashmap does not contain the key of the current character in the first input string
            // store the current character as the key and for the value, store the character in the same position from the second input string

            if (!hashMap.containsKey(input1.charAt(i))) {
                hashMap.put(input1.charAt(i), input2.charAt(i));
            } else {
                // if the key already exists in the hashmap, check to see that the value has not changed, if it did change, return false
                if(hashMap.get(input1.charAt(i)) != input2.charAt(i)) {
                    return false;
                }
            }
        }
        // repeat the same process as above for second input string compared to first input string
        // for case where Input1: abcd and Input2: aabb
        for (int j = 0; j < input2.length(); j++) {
            if (!hashMap.containsKey(input2.charAt(j))) {
                hashMap.put(input2.charAt(j), input1.charAt(j));
            } else {
                if(hashMap.get(input2.charAt(j)) != input1.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcabc";
        String b = "xyzxyz";
        String c = "xbexyz";
        System.out.println(isIsomorphic(a,b)); //true
        System.out.println(isIsomorphic(a,c));  //false
    }
}


