import java.util.Scanner;
/**
 * class Solution.
 */
public final class Solution {
	private Solution() {
		// private class.
	}
/**
 * { function_description }
 *
 * @param      args  The arguments
 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reverseString(s);	
		System.out.println(reverse);	
	}
	public static String reverseString(String s) {
		String str1 = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			str1 += s.charAt(i);
		}
		return str1;
	}
   
}
