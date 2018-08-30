import java.util.Scanner;
/**
 * Class for FirstLast6.
 */
public final class FirstLast6 {
    /**
     * { var_description }.
     */
    public static final int NUM1 = 6;
    /**
     * Constructs the object.
     */
    private FirstLast6() {
        //Empty constructor.
    }
    /**
     * { It is the main function }.
     *
     * @param args  The arguments.
     */
    public static void main(final String[] args) {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int[] arr = new int[n];
        System.out.println("enter elements");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
          int a = NUM1;
          if (arr[0] == a || arr[n - 1] == a) {
            System.out.println("true");
          } else {
            System.out.println("false");
          }
        }
    }
