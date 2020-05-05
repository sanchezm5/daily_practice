/** This question is from LeetCode
 *
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this
 * string is valid. We define the validity of a string by these rules:
 *      Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 *      Any right parenthesis ')' must have a corresponding left parenthesis '('.
 *      Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 *      '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 *      An empty string is also valid.
 *
 * Input: "()"      Output: True
 * Input: "(*)"     Output: True
 * Input: "(*))"    Output: True
 *
 * Note: The string size will be in the range [1, 100].
 */


package strings;

import java.util.Stack;

// Solution: Use two stacks
// Time: O(n) | Space: O(1)
public class ValidParenthesisString {

    public static boolean checkValidString(String s) {

        // create two stacks, one to hold the index for '(' and the other will be used to store the index of '*'
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        // depending on the character in the string, store the index into the appropriate stack
        // when the character is equal to ')', if stack 1 or stack 2 is not empty, pop the value off the corresponding stack
        // if the two stacks are empty, then a ')' has come before a '(' so return false
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack1.push(i);
            } else if(s.charAt(i) == '*') {
                stack2.push(i);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                } else if(!stack2.isEmpty()) {
                    stack2.pop();
                } else {
                    return false;
                }
            }
        }

        // if the index value of stack 1 is greater than that of stack 2, return false
        // otherwise pop the values off of each stack
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() > stack2.peek()){
                return false;
            } else {
                stack1.pop();
                stack2.pop();
            }
        }

        // if there are still values stored in stack 1 without any values in stack 2, return false
        // otherwise the given input is a valid parenthesis string so return true
        if (!stack1.isEmpty() && stack2.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "(*))";
        String s2 = ")(*";
        System.out.println(checkValidString(s1)); // Output should be true
        System.out.println(checkValidString(s2)); // Output should be false
    }
}
