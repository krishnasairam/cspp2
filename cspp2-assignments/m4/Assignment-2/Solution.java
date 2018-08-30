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
	  int row1 = scan.nextInt();
      int col1 = scan.nextInt();
      scan.nextLine();
      int[][] x1 = new int[row1][col1];
      for (int i = 0; i < row1; i++) {
          for (int j = 0; j < col1; j++) {
            x1[i][j] = scan.nextInt();
        }scan.nextLine();
        }
      int row2 = scan.nextInt();
      int col2 = scan.nextInt();
      scan.nextLine();
      int[][] x2 = new int[row2][col2];
      for (int i = 0; i < row2; i++) {
          for (int j = 0; j < col2; j++) {
            x2[i][j] = scan.nextInt();
        }scan.nextLine();
        }
      int[][] rs = x1;
    	int row = x1.length;
    	int col = x1[0].length;
    	for (int i = 0; i < row; i++) {
    	  for (int j = 0; j < col; j++) {
    	  rs[i][j] = x1[i][j] + x2[i][j];
    	}
      }
      for(int i = 0; i < row1; i++ ) {
      	for(int j =0; j < col1; j++) {
      		System.out.print(rs[i][j]);
      	}System.out.println();
      }   	
  }
}
