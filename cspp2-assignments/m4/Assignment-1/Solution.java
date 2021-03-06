import java.util.Scanner;
/**
 * Class for finding the largest number in array.
 */
public final class  Solution {
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
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int temp = 0;
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



