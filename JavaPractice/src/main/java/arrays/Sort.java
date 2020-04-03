/** This question is from CodingBat

 Return an array that contains the sorted values from the input array with duplicates removed.

 Input: []       Output: []
 Input: [1]      Output: [1]
 Input: [1,1]    Output: [1]
 Input: [1,1,2]  Output: [1,2]
 */

package arrays;

public class Sort {

    // Solution 1: Use multiple pointers and copy values into a new array
    public static int[] sortSoln1(int[] a) {
        // initialize j = 0 and a new array to hold the sorted integers without consecutive duplicates
        int j = 0;
        int[] newArr = new int[a.length];

        // if the input array is empty or has a length of 1, return the same array
        if (a.length < 2) return a;

        for (int i = 0; i < a.length - 1; i++) {
            // if the current value does not equal the next value, store the current value into the new array, then increment j
            if (a[i] != a[i + 1]) {
                newArr[j] = a[i];
                j++;
            }
        }
        // store the value of the last element of the original array into the newArray
        newArr[j] = a[a.length - 1];

        // initialize a final array to be returned with a size of j + 1
        int[] finalArr = new int[j + 1];

        for (int i = 0; i < j + 1; i++) {
            // copy each value in the new array into the final array up to the jth index
            finalArr[i] = newArr[i];
        }
        // return the final array with the correct size
        return finalArr;
    }


    // Solution 2: Use multiple pointers and sort array in-place
    public static int[] sortSoln2(int[] a) {
        // initialize j = 0
        int j = 0;

        // if the input array is empty or has a length of 1, return the same array
        if (a.length < 2) return a;

        for (int i = 0; i < a.length - 1; i++) {
            // if the current value does not equal the next value, replace a[j] with the current value, then increment j
            if (a[i] != a[i + 1]) {
                a[j] = a[i];
                j++;
            }
        }
        // replace a[j] with the last value of the original array
        a[j] = a[a.length - 1];

        // initialize a final array to be returned with a size of j + 1
        int[] finalArr = new int[j + 1];

        // copy each value in the modified array into the final array only up to the jth index
        // (in other words without the duplicates, if any)
        for (int i = 0; i < j + 1; i++) {
            finalArr[i] = a[i];
        }
        // return the final array with the correct size
        return finalArr;
    }
}
