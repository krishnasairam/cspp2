import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : sairam.
 */
final class Solution {
/**
 * @param X value.
 */
    static final int X = 50;
/**
 * @param Y value.
 */
    static final int Y = 100;
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
static int[][] roundHundred(final int[][] a, final int rows,
                                       final int columns) {
    int[][] rs = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = X; k < a[i][j] + X; k = k + Y) {
                    if (a[i][j] < X) {
                       rs[i][j] = 0;
                    } else if (k < a[i][j] && a[i][j] < k + Y) {
                        rs[i][j] = k + X;
                    }
                }
            }
    } return rs;
}
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
