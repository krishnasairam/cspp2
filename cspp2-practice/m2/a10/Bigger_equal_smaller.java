/**
 * Comparision.java.
 * Name sairam.
 */
import java.util.Scanner;
public final class Bigger_equal_smaller {
    /**
     * Empty Constructor.
     */
    private Bigger_equal_smaller() {
        //I am not using this constructor
    }
    /**
     * main function to compare two numbers.
     * @param args is the parameter for this function
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int varA = scan.nextInt();
        int varB = scan.nextInt();
        if (varA > varB) {
            System.out.println("Bigger");
        } else if (varA == varB) {
            System.out.println("Equal");
        } else {
            System.out.println("Smaller");
        }
    }
}
