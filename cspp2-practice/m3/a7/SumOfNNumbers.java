import java.util.Scanner;
    /**
     * Class for SumOfNNumbers.
     */
public final class SumOfNNumbers {
    /*
    Do not modify this main function.
    */

    /**
     * Constructs the object.
     */
    private SumOfNNumbers() {
        //Empty constructor
    }
    /**
     * { It is the main function }.
     *
     * @param args  The arguments
     */
    public static void main(final String[] args) {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int sum = 0;
      for (int i = n; i >= 1; i--) {
        sum = sum + i;
      }
      System.out.println(sum);
    }
}
