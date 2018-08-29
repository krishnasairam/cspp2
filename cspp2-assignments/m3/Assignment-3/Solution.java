import java.util.Scanner;
/**
*Do not modify this main function.
*/
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
      /**
      * Empty constructor.
      */
    }
     /**
     * @param args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = gcd(n1, n2);
        System.out.println(gcd);
    }
     /**
      * @param      n1    The n 1.
      * @param      n2    The n 2.
      * @return     { description_of_the_return_value }.
      */
    static int gcd(final int n1, final int n2) {
        if (n2 != 0) {
            return gcd(n2, n1 % n2);
        } else {
            return n1;
        }
    }
 }


