import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    public static int binaryToDecimal(final String s) {
      int pow = s.length() - 1;
      int decimal = 0;
      for (int i = 0; i < s.length(); i++) {
        decimal += (Character.getNumericValue(s.charAt(i)) * Math.pow(2, pow));
        pow = pow - 1;
      }
      return decimal;
    }
}
