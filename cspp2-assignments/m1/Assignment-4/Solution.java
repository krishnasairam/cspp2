import java.util.Scanner;
/**.
    * Date: 28-08-2018.
    * Name: Sai Ram.
    * Area of calculateFromDegreesToFarenheit.
*/
public final class Solution {
    /**
     * { var_description }.
     */
    static final double A = 1.8;
    /**
     * { var_description }.
     */
    static final double B = 32;
    /**
        * default constructor.
    */
    private Solution() {
    }
   /**
        * main function.
        * @param args is for commsnd line arguments.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        calculateFromDegreesToFarenheit(degreesCelsius);
    }
    /**
        * main function.
        * @param d is temperature in celsius.
    */
    public static void calculateFromDegreesToFarenheit(final double d) {
        System.out.println((d * A) + B);
    }
}
