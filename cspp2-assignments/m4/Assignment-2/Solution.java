import java.util.Scanner;

public final class Solution {
	/**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * { It is the main function }.
     *
     * @param args  The arguments.
     */
	public static void main(final String[] args) {
	  Scanner scan = new Scanner(System.in);
	  
      int[][] x1 = read();
      // x1 = read(row1, col1);
      // int row2 = scan.nextInt();
      // int col2 = scan.nextInt();
      // scan.nextLine();
      int[][] x2 = read();
      // x2 = read(row2, col2);
      int[][] a = madd(x1, x2);
      for(int i = 0; i < x1.length; i++ ) {
      	for(int j =0; j < x1[0].length; j++) {
      		System.out.print(a[i][j]);
      	}
      	System.out.println();
      }
      	
  }
    public static int[][] read() {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();
		scan.nextLine();
		int[][] arr = new int[row][col];
        // System.out.println("enter elements");
        for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
	            // arr[i][j] = scan.nextInt();
	            System.out.println(scan.nextInt());
	        }scan.nextLine();
        }
        return arr;
    }

    public static int[][] madd(int[][] m1, int[][] m2) {
    	int[][] rs = m1;
    	int row = m1.length;
    	int col = m1[0].length;
    	for (int i = 0; i < row; i++) {
    	  for (int j = 0; j < col; j++) {
    	  rs[i][j] = m1[i][j] + m2[i][j];
    	}
      }
    return rs;
	}
}
