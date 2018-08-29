import java.util.Scanner;
/**
  *class solution.
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
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
          String string = String.valueOf(i);
          char[] character = string.toCharArray();
          char seven = '7';
          for (char a : character) {
            if (a == seven) {
              count++;
            }
          }
       }
       System.out.println(count);
    }
}


