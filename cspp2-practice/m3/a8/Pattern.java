import java.util.Scanner;
/**
 * Class for Pattern.
 */
public final class Pattern {
    /**
     * Constructs the object.
     */
    private Pattern() {
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
      for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
              System.out.print(j +  " ");
            }
            System.out.println();
        }
    }
}
