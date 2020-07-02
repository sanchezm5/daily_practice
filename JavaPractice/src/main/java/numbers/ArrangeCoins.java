/** This question is from LeetCode
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Input: n = 5     Output: 2
 * Explanation: The coins can form the following rows:
 *              ¤
 *              ¤ ¤
 *              ¤ ¤
 *              Because the 3rd row is incomplete, we return 2.
 *
 * Input: n = 8     Output: 3
 * Explanation: The coins can form the following rows:
 *              ¤
 *              ¤ ¤
 *              ¤ ¤ ¤
 *              ¤ ¤
 *              Because the 4th row is incomplete, we return 3.
 *
 */
package numbers;

// Time: O(1) | Space: O(1)
public class ArrangeCoins {
    // Use the formula for Triangular Numbers: k(k+1)/2 <= n
    // To find the kth row, use the quadratic formula
    public static int arrangeCoins(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (int)Math.floor((-1 + Math.sqrt(1 + (long)8 * n))/2);
        }
    }
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5)); // Output: 2
        System.out.println(arrangeCoins(8)); // Output: 3
    }
}
