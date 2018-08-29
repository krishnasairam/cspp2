/**
 * AreaofCircle.java.
 * Name sairam.
 */
import java.util.Scanner;
public final class Area_of_Circle {
    /**
     * variable PIVALUE.
     */
    private static final double PIVALUE = 22 / 7.0;
    /**
     * Empty Constructor.
     */
    private Area_of_Circle() {
        //I am not using this constructor
    }
    /**
    * method to pi value.
    * @return double value
    */
    public static double pi() {
        return PIVALUE;
    }
    /**
     * main function to print area of circle.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int radius = scan.nextInt();
        System.out.println(area(radius));
    }
    /**
     * method to print area of circle.
     * @param radius is the parameter for this function
     * @return double value of the area of the circle
     */
    public static double area(final int radius) {
        double area = pi() * (radius * radius);
        return area;
    }
}