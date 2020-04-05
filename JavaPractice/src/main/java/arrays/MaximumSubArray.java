/** This question is from LeetCode

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the
 largest sum and return its sum.

 Input: [-2,1,-3,4,-1,2,1,-5,4]       Output: 6 since [4,-1,2,1] has the largest sum
 Input: [-2,-1]                     Output: -1 since [-1] has the largest sum
 */

package arrays;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int current = 0;
        // set sum to min value in case the largest minimum sum is a negative number
        int sum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            current += nums[i];

            if(current > sum) {
                sum = current;
            }
            if(current < 0) {
                current = 0;
            }
        }
        return sum;
    }
}
