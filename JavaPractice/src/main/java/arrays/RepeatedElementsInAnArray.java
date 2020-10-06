/** This question is from Firecode.io
 *
 * Write a method duplicate to find the repeated or duplicate elements in an array.
 * This method should return a list of repeated integers in a string with the elements sorted in ascending order.
 *
 * Input: {1,3,4,2,1}       Output: "[1]"
 * Input: {1,3,4,2,1,2,4}   Output: "[1, 2, 4]"
 *
 * Note: You may use toString() method to return the standard string representation of most data structures, and
 * Arrays.sort() to sort your result.
 */

package arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

// Time: O(n) | Space: O(n)
public class RepeatedElementsInAnArray {

    public static String duplicate(int[] numbers) {
        // sort the input array using Arrays.sort()
        Arrays.sort(numbers);

        // A TreeSet implements the Set interface that uses a tree for storage of elements in ascending order
        // Duplicates and null values are not allowed in a TreeSet
        Set<Integer> treeSet = new TreeSet<>();

        // loop through the sorted array
        for (int i = 1; i < numbers.length; i++) {
            // if the current element is equal to the previous element
            // store the current element in the treeSet as duplicates will not be inserted
            if (numbers[i] == numbers[i-1]) {
                treeSet.add(numbers[i]);
            }
        }
        // convert the treeSet list to a string
        return treeSet.toString();
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,2,1};
        int[] b = {1,3,4,2,1,2,4};
        System.out.println(duplicate(a));   // should output: "[1]"
        System.out.println(duplicate(b));   // should output: "[1,2,4]"
    }
}

