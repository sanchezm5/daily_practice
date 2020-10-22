/** This question is from LeetCode
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is
 * missing from the array.
 *
 * Examples:
 * Input: nums = [3,0,1]                    Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
 * 2 is the missing number in the range since it does not appear in nums.
 *
 * Input: nums = [0,1]                      Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
 * 2 is the missing number in the range since it does not appear in nums.
 *
 * Input: nums = [9,6,4,2,3,5,7,0,1]        Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
 * 8 is the missing number in the range since it does not appear in nums.
 *
 * Input: nums = [0]                        Output: 1
 * Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1].
 * 1 is the missing number in the range since it does not appear in nums.
 *
 * Constraints:
 *      n == nums.length
 *      1 <= n <= 104
 *      0 <= nums[i] <= n
 *      All the numbers of nums are unique.
 */


package numbers;

import java.util.Arrays;

public class MissingNumber {

    // Solution 1: Find the sum of nums and subtract it from the sum of all the numbers in the range [0, n]
    public static int missingNumberSoln1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (nums.length * (nums.length + 1))/2 - sum;
    }

    // Solution 2: Sort the array, compare each num to the next, if the difference is not 1, return the missing number
    public static int missingNumberSoln2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1] - 1) {
                result = nums[i + 1] - 1;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        int[] a = {3,0,1}; // Output should be 2
        int[] b = {9,6,4,2,3,5,7,0,1}; // Output should be 8
        System.out.println(missingNumberSoln1(a));
        System.out.println(missingNumberSoln2(b));
    }
}
