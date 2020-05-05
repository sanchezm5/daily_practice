/** This question is from LeetCode
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 *
 * Input: J = "aA", S = "aAAbbbb"       Output: 3
 * Input: J = "z", S = "ZZ"             Output: 0
 *
 * Note: S and J will consist of letters and have length at most 50. The characters in J are distinct.
 */

package strings;

// Time: O(n) | Space: O(1)
public class JewelsAndStones {

    public static int numJewelsInStones(String J, String S) {
        int count = 0;

        // if a stone is also a jewel, a character in S will be found in J
        // whenever it is found, increment the count, then return it after one pass of the string S
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String j1 = "aA", s1 = "aAAbbbb";
        String j2 = "z", s2 = "ZZ";

        System.out.println(numJewelsInStones(j1, s1)); // Output should be 3
        System.out.println(numJewelsInStones(j2, s2)); // Output should be 0
    }
}
