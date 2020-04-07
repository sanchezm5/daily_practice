/** This question is from LeetCode

 Given an integer array arr, count element x such that x + 1 is also in arr.
 If there're duplicates in arr, count them separately.

 Constraints:
    1 <= arr.length <= 1000
    0 <= arr[i] <= 1000

 Input: arr = [1,2,3]
 Output: 2          Explanation: 1 and 2 are counted cause 2 and 3 are in arr.

 Input: arr = [1,1,3,3,5,5,7,7]
 Output: 0          Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.

 Input: arr = [1,3,2,3,5,0]
 Output: 3          Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.

 Input: arr = [1,1,2,2]
 Output: 2          Explanation: Two 1s are counted cause 2 is in arr.

 */

package arrays;

import java.util.HashMap;
import java.util.Map;

public class CountingElements {

    public static int countElements(int[] arr) {
        int counted = 0;
        Map<Integer, Integer> allElements = new HashMap<Integer, Integer>();

        // for each element in the arr array
        // check if the key exists in the hash map
        // if it doesn't, create one with a value equal to 1 for that key
        // if it does exist, the value for that key is incremented by 1
        for (int elem: arr) {
            if(!allElements.containsKey(elem)) {
                allElements.put(elem, 1);
            } else {
                allElements.put(elem, allElements.get(elem) + 1);
            }
        }
        // for each element in the hash map's key set
        // check if the hash map contains a key for the x + 1 element in the arr
        // if so, return the counted number of x elements by getting the count value from the hash map
        for (int el: allElements.keySet()) {
            if(allElements.containsKey(el + 1)) {
                counted += allElements.get(el);
            }
        }
        return counted;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,3,5,0};
        System.out.println("The number of counted elements is : " + countElements(a));
        int[] b = {1,1,2,2};
        System.out.println("The number of counted elements is : " + countElements(b));
    }
}
