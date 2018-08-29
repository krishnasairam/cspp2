/**
 * Factorial.java.
 * name Sairam.
 */
import java.util.Scanner;
public final class Factorial {
	/**
     * Empty Constructor.
     */
	private Factorial() {
		//I am not using this constructor
	}
	/**
     * main function to find the factorial of a given number.
     * @param args is the parameter for this function
     */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int fact = scan.nextInt();
		System.out.println(factorial(fact));
	}
	public static int factorial(int fact) {
		if (fact == 0 || fact == 1) {
			return 1;
		} else {
			return fact * factorial(fact - 1);
		}
	}
}