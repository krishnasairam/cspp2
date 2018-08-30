import java.util.*;
/**
 * Class for finding the largest number in array.
 */
public class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        //Empty constructor.
    }
    /**
     * { It is the main function }.
     * @param args  The arguments.
     */
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int[] arr = new int[n];
        int temp = 0;
        System.out.println("enter elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int element : arr) {
        	if (element > temp) {
        		temp = element;
        	}
        }
        System.out.println(temp);
	}
}
