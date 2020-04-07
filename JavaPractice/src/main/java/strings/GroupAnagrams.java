/** This question is from LeetCode

 Given an array of strings, group anagrams together.

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 Output: [
             ["ate","eat","tea"],
             ["nat","tan"],
             ["bat"]
         ]

 Note:
     1. All inputs will be in lowercase.
     2. The order of your output does not matter.
 */

package strings;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {

        // create an array list to hold the lists of strings
        // create a hash map where the sorted word is a key
        // and the list of strings that correspond to that key can be added to the hash map
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String, List<String>> hashmap = new HashMap<>();

        // for every word in the strs array
        // convert the word into an array of characters, sort it
        // then convert the sorted array into a string
        for(String word: strs) {
            char[] lettersArray = word.toCharArray();
            Arrays.sort(lettersArray);
            String sortedWord = new String(lettersArray);

            // if the word is not in the hash map, create a new key and value pair for the hash map
            if(!hashmap.containsKey(sortedWord)) {
                List<String> anagrams = new ArrayList<>();
                hashmap.put(sortedWord, anagrams);
            }
            // otherwise add the word to the existing list of words associated with the sorted word key
            hashmap.get(sortedWord).add(word);
        }
        // finally add all the lists of hash map values to the grouped anagrams array list, then return it
        groupedAnagrams.addAll(hashmap.values());
        return groupedAnagrams;
    }

    public static void main (String[] args) {
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(a));
    }
}
