/** This question is from Firecode.io
 *
 * You are given an m x n 2D image matrix where each integer represents a pixel.
 * Flip it in-place along its horizontal axis.
 *
 * Example:
 *      Input image:  1 1           Modified to:  0 0
 *                    0 0                         1 1
 */

package arrays;

public class HorizontalFlip {

    public static void flipHorizontalAxis(int[][] matrix) {
        int[] temp;
        int j = matrix.length - 1;
        // Run a for loop and swap each array with the last, then second-to-last, etc.
        for (int i = 0; i < matrix.length / 2; i++) {
            temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            j--;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{0,0},{1,1}};
        flipHorizontalAxis(a);
    }
}
