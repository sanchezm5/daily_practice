/** This question is from LeetCode
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Input: [0,1]               Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

 Input: [0,1,0]             Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 Input: [0,1,1,0,1,1,1,0]   Output: 4
 Explanation: [0,1,1,0] is the longest contiguous subarray with equal number of 0 and 1.

 Note: The length of the given binary array will not exceed 50,000.
 */

package arrays;

import java.util.HashMap;
import java.util.Map;

//Solution: Use a HashMap
//Time O(n) | Space O(n)
public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        // create a HashMap to hold the current count and the index
        Map<Integer, Integer> hashmap = new HashMap<>();

        // need first value in hashmap to have (key)currCount = 0 and (value)index = -1
        hashmap.put(0, -1);
        int currCount = 0;
        int maxLength = 0;

        // for every element in the array
        // if the current element is equal to 0, subtract 1 from the current count
        // if the current element is equal to 1, add 1 to the current count
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currCount -= 1;
            } else {
                currCount += 1;
            }

            // if the HashMap does not contain the current count key,
            // create a new key, with the corresponding value equal to i
            if (!hashmap.containsKey(currCount)) {
                hashmap.put(currCount, i);

            // otherwise, find the maximum value by comparing the current max length
            // to the difference between the current index and the previously stored index
            } else {
                maxLength = Math.max(maxLength, i - hashmap.get(currCount));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0}; // should output 2
        int[] b = {0,1,1,0,1,1,1,0}; // should output 4
        System.out.println("For [0,1,0], the longest contiguous subarray has a length of: " + findMaxLength(a));
        System.out.println("For [0,1,1,0,1,1,1,0], the longest contiguous subarray has a length of: " + findMaxLength(b));
    }
}
