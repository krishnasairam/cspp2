import java.util.Scanner;
class InputValidator {
    /**
     * { var_description }.
     */
    public String data;
    /**
     * Constructs the object.
     *
     * @param      d    data.
     */
    public InputValidator (String d) {
    /**
     * InputValidator.
     */
    data = d;
    }
    final boolean validateData () {
        if (data.length() == 6) {
            return true;
        } else {
            return false;
        }
}
}
/**
 * { item_description }.
 */
public final class Solution
{
    public static void main(final String args[]) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);       
        System.out.println(i.validateData());

    }

}
