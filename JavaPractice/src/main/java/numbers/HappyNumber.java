/** This question is from LeetCode

 Write a number to determine if a number is happy. A happy number is a number defined by the following process. Start
 with any positive integer, replace the number by the sum of the squares of the digits, and repeat the process until
 the number equals 1 (where it will stay) or it loops endlessly in a cycle which does not include 1. Those numbers for
 which this process ends in 1 are happy numbers.

 Input: 19          Output: true            Explanation:
                                            1^2 + 9^2 = 82
                                            8^2 + 2^2 = 68
                                            6^2 + 8^2 = 100
                                            1^2 + 0^2 + 0^2 = 1
 */

package numbers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {
        // Create a hash set to store the sums
        Set<Integer> sums = new HashSet<Integer>();
        // initialize sum = 0
        int sum = 0;

        // while the sum does not equal 1, find the sum of squares of the number's digits
        // and replace the number by this sum
        while (sum != 1) {
            sum = sumOfSquares(n);
            n = sum;

            // check to see if the sum is in the hash set
            // if so return false, if not add the sum to the hash set
            if(sums.contains(sum)) {
                return false;
            } else {
                sums.add(sum);
            }
        }
        // sum is 1 so the number is happy, return true
        return true;
    }
    // helper method to find the sum of squares of the number's digits
    public static int sumOfSquares(int num) {
        int newSum = 0;
        while (num > 0) {
            newSum += (num % 10) * (num % 10);
            num = num / 10;
        }
        return newSum;
    }

    public static void main(String[] args) {
        // HappyNumber
        int happyNum = 19;
        int unhappyNum = 6;
        System.out.println("Is 19 happy? : " + isHappy(happyNum));
        System.out.println("Is 6 happy? : " + isHappy(unhappyNum));
        System.out.println("\n---------------------------------------\n");
    }
}
