import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : 
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static int oddComposites(final int n) {
    for (int j = 3; j < n; j++)	{
    int count = 0;	
		for (int i = 3; i < j; i++) {
			if (i % 2 != 0 && j % 2!= 0) {
				if (j % i == 0) {
					count = count + 1; 
				}
			}
		}
		if (count > 0) {
			System.out.println(j);
		}
    } return n;
}    
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

