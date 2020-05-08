/** This question is from LeetCode
 *
 * You are given an array, coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 * Constraints:
 *      2 <= coordinates.length <= 1000
 *      coordinates[i].length == 2
 *      -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 *      coordinates contains no duplicate point.
 */

package arrays;

// Solution: Get the equation of a line using two points, then use the equation to determine if other points are collinear
public class CheckIfItIsAStraightLine {

    public static boolean checkStraightLine(int[][] coordinates) {

        // two points determine a line
        // if there are only two points, return true
        if (coordinates.length == 2) return true;

        // assume slope is defined (not undefined)
        boolean mUndefined = false;

        // if the difference between the first two x-coordinates is 0, the slope is undefined
        if (coordinates[1][0] - coordinates[0][0] == 0) {
            mUndefined = true;
        }

        for (int i = 2; i < coordinates.length; i++) {
            // if the slope is undefined, the line is vertical and all x-coordinates must be equivalent
            // if any of the other x-coordinates are not equal to the first x-coordinate, return false
            if (mUndefined) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
            // if the slope is defined, the coordinate must satisfy the equation of the line in slope-intercept form: y = mx + b
            } else {
                int m = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
                int b = coordinates[0][1] - m * coordinates[0][0];
                if (coordinates[i][1] != m * coordinates[i][0] + b) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coord1 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coord2 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(checkStraightLine(coord1)); // should output true
        System.out.println(checkStraightLine(coord2)); // should output false
    }
}
