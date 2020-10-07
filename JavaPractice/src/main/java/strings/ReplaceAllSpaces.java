/** This question is from Firecode.io
 *
 * Write a method to replace all spaces in a string with a given replacement string.
 *
 * Input: replace("This is a test","/")         Output: "This/is/a/test"
 *
 * Note: Avoid using the in-built String.replaceAll() method.
 */
package strings;

public class ReplaceAllSpaces {

    public static String replace(String a, String b) {

        StringBuilder finalString = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == ' ') {
                finalString.append(b);
            } else {
                finalString.append(a.charAt(i));
            }
        }
        return finalString.toString();
    }

    public static void main(String[] args) {
        String a = "This is a test";
        String b = "/";
        System.out.println(replace(a, b));
    }
}

