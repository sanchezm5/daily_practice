/** This question is from LeetCode
 *
 *  73. Set Matrix Zeroes: Given an m x n matrix. If an element is 0, set its entire row and column to 0.
 *
 *  Examples:
 *      Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 *      Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 *      Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 *      Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *  Constraints:
 *      m == matrix.length
 *      n == matrix[0].length
 *      1 <= m, n <= 200
 *      -231 <= matrix[i][j] <= 231 - 1
 */

package arrays;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        // Use row and col arrays to store places where matrix has a zero
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Loop through each row and col arrays to see where zeroes are to be set in matrix
        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                setRowsToZeroes(matrix, i);
            }
        }

        for (int j = 0; j < col.length; j++) {
            if (col[j]) {
                setColsToZeroes(matrix, j);
            }
        }
    }

    // Setting rows and columns in the matrix to zeroes
    public static void setRowsToZeroes(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void setColsToZeroes(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] B = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(A);
        setZeroes(B);

        // Check Output for A
        System.out.println("---------OUTPUT FOR A---------");
        for (int i = 0; i < A.length; i++) {
            System.out.println();
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j]);
            }
        }

        // Check Output for B
        System.out.println("\n---------OUTPUT FOR B---------");
        for (int i = 0; i < B.length; i++) {
            System.out.println();
            for (int j = 0; j < B[0].length; j++) {
                System.out.print(B[i][j]);
            }
        }
    }
}
