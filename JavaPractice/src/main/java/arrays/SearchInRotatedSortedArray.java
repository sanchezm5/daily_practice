/** This question is from LeetCode
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). You are given a target value to search. If found in the array
 * return its index, otherwise return -1. You may assume no duplicate exists in the array. Your algorithm's runtime
 * complexity must be in the order of O(log n).
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */

package arrays;

// Solution: Use two pointers
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        // based on the value of the element in the array, return the index or increment or decrement the pointer
        // otherwise return -1
        while (i <= j) {
            if (nums[i] == target) {
                return i;
            } else if (nums[j] == target) {
                return j;
            } else if (nums[i] != target) {
                i++;
            } else if (nums[j] != target) {
                j--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target1 = 0;
        int target2 = 3;

        System.out.println(search(nums, target1)); // Output should be 4
        System.out.println(search(nums, target2)); // Output should be -1
    }
}
