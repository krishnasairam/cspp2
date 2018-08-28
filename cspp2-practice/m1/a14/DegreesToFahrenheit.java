/**.
    * Date: 28-08-2018.
    * Name: Sai Ram.
    * Finding Quoitent and reminder of two numbers.
*/
import java.util.Scanner;
/**
    * DegreesToFahrenheit class.
*/
public final class DegreesToFahrenheit {
    /**
        * DegreesToFahrenheit of two numbers.
    */
    private DegreesToFahrenheit() {
    /**
        * default constructor.
    */
    }
    /**
        * main function.
        * @param args is for command line arguments.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter temperature in Degrees:");
        int tc = scan.nextInt();
        System.out.println("temperature in Fahrenheit is :");
        System.out.println((tc * 1.8) + 32);
    }
}
