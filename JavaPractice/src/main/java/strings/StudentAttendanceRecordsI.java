/** This question is from LeetCode
 *
 * You are given a string representing an attendance record for a student. The record only contains the following three
 * characters:
 *      'A' : Absent.       'L' : Late.         'P' : Present.
 *
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two
 * continuous 'L' (late). You need to return whether the student could be rewarded according to his attendance record.
 *
 * Input: "PPALLP"      Output: True
 * Input: "PPALLL"      Output: False
 * Input: "PPALPLL"     Output: True
 * Input: "PPAPPPA"     Output: False
 */

package strings;

// Solution: Iterate through the string in one pass and check for conditions
// Time: O(n) | Space: O(1)
public class StudentAttendanceRecordsI {

    public static boolean checkRecord(String s) {
        int i = 0;
        int countA = 0;

        while (i < s.length()) {
            // if the character in the string is 'A', increment the counter for 'A'
            if (s.charAt(i) == 'A') {
                countA++;
                // check to see if there is more than one 'A', if so, return false
                if (countA > 1) {
                    return false;
                }
                // if the current character in the string is 'L' and there are two consecutive 'LL' to follow, return false
            } else if (s.charAt(i) == 'L') {
                if (i <= s.length() - 3 && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L') {
                    return false;
                }
            }
            // otherwise increment i
            i++;
        }
        // if all characters have been visited in the string and no conditions in the while loop have been met, return true
        return true;
    }

    public static void main(String[] args) {
        String s1 = "PPALLP";
        String s2 = "PPALLL";
        String s3 = "PPALPLL";
        String s4 = "PPAPPPA";

        System.out.println(checkRecord(s1)); // Output: true
        System.out.println(checkRecord(s2)); // Output: false
        System.out.println(checkRecord(s3)); // Output: true
        System.out.println(checkRecord(s4)); // Output: false
    }
}
