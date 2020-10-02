/** This question is from LeetCode

 Given a matrix A, return the transpose of A.
 The transpose of a matrix is the matrix flipped over it's main diagonal,
 switching the row and column indices of the matrix.

 Input: [[1,2,3],[4,5,6],[7,8,9]]         Output: [[1,4,7],[2,5,8],[3,6,9]]

 Input: [[1,2,3],[4,5,6]]                 Output: [[1,4],[2,5],[3,6]]

 Note:
     1 <= A.length <= 1000
     1 <= A[0].length <= 1000
 */

package arrays;

public class TransposeMatrix {

    public static int[][] transpose(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] B = {{1,2,3},{4,5,6}};
        transpose(A);
        transpose(B);
    }
}
