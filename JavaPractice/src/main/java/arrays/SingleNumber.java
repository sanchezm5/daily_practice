/** This question is from LeetCode

 Given a non-empty array of integers, every element appears twice except for one. Find that single one.

 Input: [2,2,1]          Output: 1
 Input: [4,1,2,1,2]      Output: 4
 */

package arrays;

import java.util.Arrays;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        // sort the given nums array
        Arrays.sort(nums);

        // initialize the single variable to the minimum integer value
        int single = Integer.MIN_VALUE;

        // if the current value does not equal the next, it is a single number
        for (int i = 0; i < nums.length - 1; i+=2) {
            if(nums[i] != nums[i+1]) {
                single = nums[i];
                break;
            }
        }
        // if the value of single is still the initialized value,
        // the single number must be the last element in the nums array
        if(single == Integer.MIN_VALUE) {
            single = nums[nums.length-1];
        }
        // return the single number
        return single;
    }

    public static void main(String[] args) {
        // SingleNumber
        int[] a = {2,2,1};
        System.out.println("The single number for [2,2,1] is: " + singleNumber(a));
        int[] b = {4,1,2,1,2};
        System.out.println("The single number for [4,1,2,1,2] is: " + singleNumber(b));
    }
}
