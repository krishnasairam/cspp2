/**.
    * Date: 21-08-2018.
    * Name: Sai Ram.
    * Finding Quoitent and reminder of two numbers.
*/
import java.util.Scanner;
/**
    * QuotiendRemainder class.
*/
public final class QuoitentReminder {
    /**
        * QuoitentReminder of two numbers.
    */
    private QuoitentReminder() {
    /**
        * default constructor.
    */
    }
    /**
        * main function.
        * @param args is for commsnd line arguments.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter two numbers");
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println("Quoitent and reminder are");
        System.out.println(a / b);
        System.out.println(a % b);
    }
}
