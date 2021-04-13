/** This question is from Cracking the Coding Interview
 *
 *  1.9 String Rotation: Assume you have a method isSubstring which checks if one word is a substring of another.
 *  Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 *  call to isSubstring.
 *
 *  EXAMPLE
 *      Input: s1 = "waterbottle", s2 = "erbottlewat"
 *      Output = true
 *      Explanation: "waterbottle" is a rotation of "erbottlewat"
 */

package strings;

public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() == s2.length()) {
            String doubleS1 = s1 + s1;
            return isSubstring(doubleS1, s2);
        }
        return false;
    }

    public static boolean isSubstring(String str1, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            if (str1.substring(i, i + str2.length()).equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
}
