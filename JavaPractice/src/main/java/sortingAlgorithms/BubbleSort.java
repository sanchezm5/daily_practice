/** This question is from Firecode.io
 *
 * Write a method that takes in an array of ints and uses the Bubble Sort algorithm to sort the array 'in place' in
 * ascending order. The method should return the same, in-place sorted array.
 *
 * Note: Bubble sort is one of the most inefficient ways to sort a large array of integers. Nevertheless, it is an
 * interview favorite. Bubble sort has a time complexity of O(n2). However, if the sample size is small, bubble sort
 * provides a simple implementation of a classic sorting algorithm.
 *
 * Examples:
 * bubbleSortArray({5,4,3}) -> {3,4,5}
 * bubbleSortArray({3}) -> {3}
 * bubbleSortArray({}) -> {}
 * {} -> [Empty] Array
 */
package sortingAlgorithms;

public class BubbleSort {

    public static int[] bubbleSortArray(int[] arr) {
        boolean isSorted = false;

        while(isSorted == false) {
            isSorted = true;
            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {4,2,5,1};

        for (int i = 0; i < bubbleSortArray(a).length; i++) {
            System.out.println(bubbleSortArray(a)[i]);
        } // output: 1, 2, 4, 5
    }
}
