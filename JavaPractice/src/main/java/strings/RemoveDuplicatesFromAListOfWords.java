/** This question is from Firecode.io
 *
 * Given a List of Strings, write a method removeDuplicates that removes duplicate words from the List and returns
 * an ArrayList of all the unique words. The returned ArrayList should be lexically alphabetically.
 *
 * Example:
 *      Input: [Hi, Hello, Hey, Hi, Hello, Hey]
 *      Output: [Hello, Hey, Hi]
 */

package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

// Time: O(log n) | Space: O(n)
public class RemoveDuplicatesFromAListOfWords {

    public static ArrayList<String> removeDuplicates(List<String> input) {

        // all elements are added to the treeSet where no duplicates will get inserted
        // additionally, the elements will be sorted by default in ascending order
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(input);

        // create an arrayList to hold the treeSet with the sorted strings
        // then return this arrayList
        ArrayList<String> list = new ArrayList<>(treeSet);
        return list;
    }

    public static void main(String[] args) {
        String[] input = {"Hi", "Hello", "Hey", "Hi", "Hello", "Hey"};
        List<String> list = Arrays.asList(input);
        System.out.println(removeDuplicates(list));
    }
}

