/** This question is from Firecode.io
 *
 * Write a method that returns a number that appears only once in an array.
 * Assume the array will surely have a unique value. The array will never be empty.
 *
 * Example: {1,2,3,4,1,2,4,3,5} ==> 5
 */

package arrays;

import java.util.HashMap;
import java.util.Map;

// Time: O(n) | Space: O(n)
public class FindTheNumberThatAppearsOnce {

    public static int singleNumber(int[] A) {
        // create a hashmap to hold the key: elements in the array and values: the number of times the element appears
        Map<Integer, Integer> hashMap = new HashMap<>();
        int result = 0;

        // if the element is not a key, add it to the hashmap with a count of 1
        // otherwise increment the count by 1
        for(int i = 0; i < A.length; i++) {
            if(!hashMap.containsKey(A[i])) {
                hashMap.put(A[i], 1);
            } else {
                hashMap.put(A[i], hashMap.get(A[i]) + 1);
            }
        }

        // iterate through the set of keys in the hashmap
        // if the value for a key is equal to 1, return that key
        for(int key: hashMap.keySet()) {
            if(hashMap.get(key) == 1) {
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,1,2,4,3,5};
        System.out.println(singleNumber(a));
    }
}

