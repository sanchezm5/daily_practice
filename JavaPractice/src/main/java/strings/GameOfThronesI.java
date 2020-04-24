/** This question is from HackerRank
 *
 * Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and
 * plans to lock the single door through which the enemy can enter his kingdom. But, to lock the door he needs a key
 * that is an anagram of a palindrome. He starts to go through his box of strings, checking to see if they can be
 * rearranged into a palindrome.
 *
 * For example, given the string s = [aabbccdd], one way it can be arranged into a palindrome is abcddcba.
 *
 * Function Description:
 * Complete the gameOfThrones function below to determine whether a given string can be rearranged into a palindrome.
 * If it is possible, return YES, otherwise return NO.
 *
 * Constraints:
 * 1 <= |s| <= 10^5
 * s contains only lowercase letters in the range ascii[a...z]
 *
 * Input: aaabbbb                 Output: YES
 * Explanation: A palindromic permutation of the given string is bbaaabb.
 *
 * Input: cdefghmnopqrstuvw       Output: NO
 * Explanation: Palindromes longer than 1 character are made up of pairs of characters. There are none here.
 *
 * Input: cdcdcdcdeeeef           Output: YES
 * Explanation: An example palindrome from the string: ddcceefeeccdd.
 */


package strings;

import java.util.Arrays;

//Solution: Use Two Pointers, i and j, to iterate through a sorted characters array
public class GameOfThronesI {

    public static String gameOfThrones(String s) {
        int count = 0;
        int i = 0;
        int j = 1;
        char[] sortedString = s.toCharArray();
        Arrays.sort(sortedString);

        // if there is one element in the array, return YES
        // if the length of the array is 2 and the two elements are not equal, return NO
        if (sortedString.length == 1) return "YES";
        if (sortedString.length == 2 && sortedString[i] != sortedString[j]) return "NO";

        // otherwise, while i and j are less than the length of the sorted array,
        // if the char at index i is equal to the char at index j, increment j by 1
        while (i < sortedString.length && j < sortedString.length) {

            if(sortedString[i] == sortedString[j]) {
                j++;
            }

            // if j is beyond the last index or if the two characters are not equal,
            // check to see if the length of the subarray is of odd size
            // if it is odd, increment the counter, set i equal to the jth position, then increment j
            if (j == sortedString.length || (sortedString[i] != sortedString[j])) {
                if((j - i) % 2 == 1) {
                    count++;
                }
                i = j;
                j++;
            }
        }
        // the counter keeps track of the odd length of characters in the array
        // if there is more than one of odd length, there can be no palindrome so return NO
        // otherwise return YES
        if (count > 1) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        String s1 = "cdefghmnopqrstuvw";
        String s2 = "cdcdcdcdeeeef";
        System.out.println(gameOfThrones(s1)); // should output NO
        System.out.println(gameOfThrones(s2)); // should output YES
    }
}
