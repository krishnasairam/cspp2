import java.util.Scanner;
/**
	*class solution.
*/
public class Solution {
  /**
  * Constructs the object.
  */
    private Solution() {
      /**
      * Empty constructor.
      */
    }
     /**
     * @param args  The arguments.
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        for (int i = 1;i <= n;i++) {
        	if ((i % 10) == 7) {
        		count = count + 1;
        	}
        	if ((i / 10) == 7) {
        		count++;
        	}
        }
       System.out.println(count); 
    }
}