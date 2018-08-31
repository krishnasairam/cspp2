import java.util.Scanner;
/**
 * Class for Concatinate.
 */
public final class Concatinate {
    /**
     * Constructs the object.
     */
    private Concatinate() {
        //Empty constructor
    }
    /**
     * { It is the main function }.
     *
     * @param args  The arguments
     */
    public static void main(final String[] args) {
      String s = "hello ";
      Scanner scan = new Scanner(System.in);
      String t = scan.next();
      String u = s.concat(t);
      System.out.println(u);
    }
}
