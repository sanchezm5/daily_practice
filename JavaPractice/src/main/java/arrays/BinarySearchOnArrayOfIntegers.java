/** This question is from Firecode.io
 *
 * Write a method that searches an Array of integers for a given integer using theBinary Search Algorithm. If the input
 * integer is found in the array, return true. Otherwise, return false. You can assume that the given array of integers
 * is already sorted in ascending order.
 *
 * Examples:
 *      binarySearch({2,5,7,8,9},9) -> true
 *      binarySearch({2,8,9,12},6) -> false
 *      binarySearch({2},4) -> false
 *      binarySearch({},9) -> false
 *      {} -> [Empty] Array
 */

package arrays;

// Time: O(log(n)) | Space: O(1)
public class BinarySearchOnArrayOfIntegers {

    public static Boolean binarySearch(int[] arr, int n){
        if (arr.length < 1) return false;

        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (n == arr[mid]) {
                return true;
            } else if (n < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2,5,7,8,9};
        int[] b = {2,8,9,12};

        System.out.println(binarySearch(a, 9));
        System.out.println(binarySearch(b, 6));
    }
}
