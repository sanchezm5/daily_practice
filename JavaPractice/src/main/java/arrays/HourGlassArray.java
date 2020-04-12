/** This question is from HackerRank

 Given a 6x6 2D Array, arr:

 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0

 We define an hourglass in A to be a subset of values with indices falling in this pattern
 in arr's graphical representation:

 a b c
   d
 e f g

 There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass
 sum for every hourglass in arr, then print the maximum hourglass sum.

 Constraints: -9 <= arr[i][j] <= 9
               0 <= i, j <= 5

 Sample Input:          Sample Output: 19
     1 1 1 0 0 0        Explanation: The hourglass with the maximum sum (19) is:
     0 1 0 0 0 0                    2 4 4
     1 1 1 0 0 0                      2
     0 0 2 4 4 0                    1 2 4
     0 0 0 2 0 0
     0 0 1 2 4 0
*/

package arrays;

public class HourGlassArray {

    public static int hourglassSum(int[][] arr) {
        // if all of the values in the 2D array are -9, then the max sum would be -9 * 7
        int maxSum = -63;

        // find the sum of every hourglass
        // the 16th hourglass starts at arr[3][3]
        // compare the current hourglass sum with the max sum and update the max sum accordingly
        for (int i = 0; i < arr.length - 2; i ++) {
            for (int j = 0; j < arr.length - 2; j++) {
                int hourGlassSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                maxSum = Math.max(hourGlassSum, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0}
        };
        System.out.println("The maximum hourglass sum is : " + hourglassSum(a));
    }
}
