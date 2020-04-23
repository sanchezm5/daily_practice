/** This question is from HackerRank

 You are given a string containing characters  and  only. Your task is to change it into a string such that there are no
 matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string. Your task is
 to find the minimum number of required deletions.

 Input:             Output:             Explanations:
    AAAA                3                 AAAA -> A
    BBBBB               4                 BBBBB -> B
    ABABABAB            0                 ABABABAB -> ABABABAB
    BABABA              0                 BABABA -> BABABA
    AAABBB              4                 AAABBB -> AB

 Constraints:
    1 <= |s| <= 10^5
    Each string  will consist only of characters A and B
 */

package strings;

public class AlternatingCharacters {

    public static int alternatingCharacters(String s) {
        int removeChar = 0;
        int i = 0, j = 1;

        while (j < s.length()) {
            // if the previous character is equal to the next character
            // increment the remove character counter and j
            if (Character.compare(s.charAt(i), s.charAt(j)) == 0) {
                removeChar++;
                j++;
                // otherwise, move the i pointer to j and increment j
            } else {
                i = j;
                j++;
            }
        }
        return removeChar;
    }

    public static void main(String[] args) {
        String s1 = "AAAA";     // should output 3
        String s2 = "BBBBB";    // should output 4
        String s3 = "BABABA";   // should output 0
        String s4 = "AAABBB";   // should output 4
        System.out.println(alternatingCharacters(s1));
        System.out.println(alternatingCharacters(s2));
        System.out.println(alternatingCharacters(s3));
        System.out.println(alternatingCharacters(s4));
    }
}
