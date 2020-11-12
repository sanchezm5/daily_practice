/** This question is from Firecode.io
 *
 * Given a string, recursively compute a new string where the identical adjacent characters in the original string are
 * separated by a "*".
 *
 * Examples:
 *      insertPairStar("cac") ==> "cac"
 *      insertPairStar("cc") ==> "c*c"
 */

package strings;

public class InsertStars {

    // Recursive Solution
    public static String insertPairStarSoln1(String s) {
        // Error case
        if (s == null) {
           return null;
        // Base case for string with length of 1
        } else if (s.length() == 1) {
            return s;
        // Recursive case for matching adjacent characters
        } else if (s.substring(0,1).equals(s.substring(1,2))) {
            return s.substring(0,1) + "*" + insertPairStarSoln1(s.substring(1,s.length()));
        // Recursive case for non-matching adjacent characters
        } else {
            return s.substring(0,1) + insertPairStarSoln1(s.substring(1,s.length()));
        }
    }

    // Non-recursive Solution
    public static String insertPairStarSoln2(String s) {
        // Error case
        if (s == null) return null;

        StringBuilder str = new StringBuilder();

        // If current two adjacent characters are the same, insert a star
        // Otherwise add the current character to the resulting StringBuilder
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                str.append(s.charAt(i));
                str.append('*');
            } else {
                str.append(s.charAt(i));
            }
        }
        // Lastly, add the last character to the StringBuilder
        // Then, return the converted StringBuilder as a String
        str.append(s.charAt(s.length()-1));
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(insertPairStarSoln1("cacbb"));
        System.out.println(insertPairStarSoln1("cca"));
        System.out.println(insertPairStarSoln2("bbb"));
        System.out.print(insertPairStarSoln2("abba"));
    }
}

