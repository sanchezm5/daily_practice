/** This question is from Cracking the Coding Interview
 *
 *  1.6 String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 *  For example, the string "aabcccccaaa" would become "a2b1c5a3". If the "compressed" string would not become smaller
 *  than the original string, your method should return the original string. You can assume the string has only uppercase
 *  and lowercase letters (a - z).
 */

package strings;

public class StringCompression {

    public static String compressString(String inputString) {
        String ignoreCases = inputString.toLowerCase();

        StringBuilder sb = new StringBuilder();
        int counter = 1;

        for (int i = 1; i < ignoreCases.length(); i++) {

            if (ignoreCases.charAt(i) == ignoreCases.charAt(i - 1)) {
                counter++;
            } else {
                sb.append(ignoreCases.charAt(i-1));
                sb.append(counter);
                counter = 1;
            }
        }
        // For the last char in string and its count
        sb.append(ignoreCases.charAt(ignoreCases.length()-1));
        sb.append(counter);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }
}
