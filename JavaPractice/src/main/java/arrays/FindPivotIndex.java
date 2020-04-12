/** This question is from LeetCode

 Given an array of integers nums, write a method that returns the "pivot" index of this array.
 We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of
 the numbers to the right of the index. If no such index exists, we should return -1. If there are multiple pivot
 indexes, you should return the left-most pivot index.

 Input: nums = [1, 7, 3, 6, 5, 6]          Output: 3
 Explanation: The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right
 of index 3. Also, 3 is the first index where this occurs.

 Input: nums = [1, 2, 3]                    Output: -1
 Explanation: There is no index that satisfies the conditions in the problem statement.

 Note:
     The length of nums will be in the range [0, 10000].
     Each element nums[i] will be an integer in the range [-1000, 1000].
 */

package arrays;

//Time: O(n) | Space: O(1)
public class FindPivotIndex {
    // method used to find the sum of the entire array
    public static int sumOfArray(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        return sum;
    }

    public static int pivotIndex(int[] nums) {
        int pivotIndex = -1;
        int leftSum = 0;
        int rightSum;

        for (int i = 0; i < nums.length; i++) {
            // if i is the first index, leftSum equals 0
            // otherwise the left sum is the previous sum plus previous value of the current index
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum += nums[i-1];
            }
            // the rightSum is the total sum of the array minus the leftSum and the current value at index i
            rightSum = sumOfArray(nums) - leftSum - nums[i];

            // if the left and right sums are equal, return the current index
            if(leftSum == rightSum) {
                pivotIndex = i;
                break;
            }
        }
        // return the pivot index
        return pivotIndex;
    }

    public static void main(String[] args) {
        // FindPivotIndex
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {0, 1, -1};

        System.out.println("For [1, 7, 3, 6, 5, 6], the output is : " + pivotIndex(nums1));
        System.out.println("For [0, 1, -1], the output is : " + pivotIndex(nums2));
    }
}
