/** This question is from LeetCode

 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 non-zero elements.

 Input: [0,1,0,3,12]     Output: [1,3,12,0,0]

 Note:
    1. You must do this in-place without making a copy of the array.
    2. Minimize the total number of operations.
 */

package arrays;

// Solution: Use multiple pointers
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        // initialize a left pointer at index 0
        // and a right pointer at last index of nums array
        int j = 0;
        int k = nums.length - 1;

        // iterate through the array with i
        for (int i = 0; i < nums.length-1; i++) {
            // move the right pointer to the left if the current element is a zero
            while (nums[k] == 0 && k > 0) {
                k--;
            }

            // if the current index i and right pointer k are equal, no more zeroes need to be moved to the end
            if(i == k) break;

            // if the current element is a zero, use the left pointer to find the element that is not a zero
            if (nums[i] == 0) {
                while(nums[j] == 0 && j < nums.length - 1) {
                    j++;
                }
                // swap the two element values to change the array in place
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            // increment the left pointer if the current element is not zero
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        moveZeroes(a);
        System.out.println("After moving zeroes for [0,1,0,3,12], the elements are : ");
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}

