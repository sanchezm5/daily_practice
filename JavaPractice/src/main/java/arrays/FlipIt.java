/** This question is from Firecode.io
 *
 * You are given an m x n 2D image matrix where each integer represents a pixel. Flip it in-place along its vertical axis.
 *
 * Example:
 * Input image :            Modified to :
 *               1 0                      0 1
 *               1 0                      0 1
 */
package arrays;

public class FlipIt {

    public static void flipItVerticalAxis(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - 1 - j];
                matrix[i][cols - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,0},{1,0}};
        flipItVerticalAxis(a);
        // a becomes: {{0,1},{0,1}}
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.println(a[i][j]);
            }
        }
    }
}

