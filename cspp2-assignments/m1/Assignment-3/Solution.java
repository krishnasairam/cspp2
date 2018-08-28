import java.util.Scanner;
/**.
    * Date: 28-08-2018.
    * Name: Sai Ram.
    * Area of the trian.
*/
public final class Solution {
    /**
        * main function.
        * @param args is for commsnd line arguments.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Solution sol = new Solution();
        double base = scan.nextDouble();
        double height = scan.nextDouble();
        sol.areaOfTriangle(base, height);
    }
    /**
        * area of triangle function.
        * @param b is breadth.
      *   @param h is height.
    */
        public void areaOfTriangle(final double b, final double h) {
        System.out.println((b * h) / 2);
    }
    /*
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
