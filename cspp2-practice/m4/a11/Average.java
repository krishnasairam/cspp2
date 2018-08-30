import java.util.Scanner;
/**
 * Class for Average.
 */
public final class Average {
    /**
     * Constructs the object.
     */
    private Average() {
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
      int sum = 0;
        System.out.println("enter elements");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        for (int element : arr) {
          sum = sum + element;
        }
        System.out.println(sum / n);
        }
    }
