import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { var_description }.
     */
    private String data;
    /**
     * Constructs the object.
     *
     * @param      d    data.
     */
    public InputValidator(final String d) {
        /**
         * InputValidator.
         */
        data = d;
    }
    /**
     * validateData.
     *
     * @return     boolean.
     */
    final boolean validateData() {
        final int a = 6;
        if (data.length() >= a) {
            return true;
        } else {
            return false;
        }
    }
}
/**
 * class solution.
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * @param args is the parameter for this method.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
