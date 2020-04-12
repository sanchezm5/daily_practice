/** This question is from LeetCode

 Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace
 character.

 Input: S = "ab#c", T = "ad#c"          Output: true        Explanation: Both S and T become "ac".

 Input: S = "ab##", T = "c#d#"          Output: true        Explanation: Both S and T become "".

 Input: S = "a##c", T = "#a#c"          Output: true        Explanation: Both S and T become "c".

 Input: S = "a#c", T = "b"              Output: false       Explanation: S becomes "c" while T becomes "b".

 Note:
     1 <= S.length <= 200
     1 <= T.length <= 200
     S and T only contain lowercase letters and '#' characters.
 */

package strings;

import java.util.Stack;

//Solution: Use stacks to model the results of typing into the key editor
//Time O(m + n), where m and n are the lengths of the given strings | Space O(m + n)

public class BackspaceStringCompare {

    // Compare two strings created by stacks
    // if the two strings are equal or not, return the boolean value
    public static boolean backspaceCompare(String S, String T) {
        boolean compareStrings = (stackResult(S).equals(stackResult(T))) ? true : false;
        return compareStrings;
    }

    // Method used to create stacks out of given string
    public static String stackResult(String str) {
        // create a new stack of characters and an array of characters using the given string
        Stack<Character> stack = new Stack();
        char[] arrOfChar = str.toCharArray();

        // for each character in the array of characters
        // if the current character is not equal to '#', push that character onto the stack
        // if it is equal to '#' and the stack is not empty, pop that character off the stack
        for (char ch : arrOfChar) {
            if (ch != '#') {
                stack.push(ch);
            } else if (!stack.empty()) {
                stack.pop();
            }
        }
        // return the resulting stack in the form of a string
        return stack.toString();
    }

    public static void main(String[] args) {
        String s1 = "ab#c";
        String t1 = "ad#c";
        System.out.println("For S = \"" + s1 + "\" and T = \"" + t1 + "\", both S and T become \"c\" so the value is : ");
        System.out.println(backspaceCompare(s1, t1));

        String s2 = "a#c";
        String t2 = "b";
        System.out.println("For S = \"" + s2 + "\" and T = \"" + t2 + "\", S becomes \"c\" while T becomes \"b\" so the value is: ");
        System.out.println(backspaceCompare(s2, t2));
    }
}
