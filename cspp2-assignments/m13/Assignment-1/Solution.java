import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : sairam.
 */
class Set {
	private int[] set;
	private int size;
	/**
	 * Constructs the object.
	 */
	public Set() {
		set = new int[10];
		size = 0;
	}
	/**
	 * size.
	 *
	 * @return     int size.
	 */
	public int size() {
		return size;
	}
	/**
	 * contains.
	 *
	 * @param      item  The item.
	 *
	 * @return     true or false.
	 */
	public boolean contains(int item) {
		boolean checkFlag = false;
		for (int i = 0; i < size; i++) {
			if (set [i] == item) {
				checkFlag = true;
			}
		}
		return checkFlag;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		if (size == 0) {
			return "{}";
		}
		String str = "{";
		int i = 0;
		for (i = 0; i < size - 1; i++) {
			str = str + set[i] + ", ";
		}
		str = str + set[i] + "}";
		return str;
	}
	/**
	 * add.
	 *
	 * @param      newArray  The new array.
	 */
	public void add(int[] newArray) {
		for (int a : newArray) {
			add(a);
		}
	}
	/**
	 * add.
	 *
	 * @param      item  The item.
	 */
	public void add(int item) {
		if (contains(item) == false) {
			if (size == set.length) {
				resize();
			}
			set[size++] = item;
		}
	}
	/**
	 * resize.
	 */
	public void resize() {
		int resizefactor = 2;
		int[] temp = new int[resizefactor * size];
		for (int i = 0; i < size; i++) {
			temp[i] = set[i];
		}
		set = temp;
	}
	/**
	 * get.
	 *
	 * @param      index  The index.
	 *
	 * @return     item.
	 */
	public int get(final int index) {
		return set[index];
	}
	/**
	 * intersection.
	 *
	 * @param      t     set.
	 *
	 * @return     intersection set.
	 */
	public Set intersection(Set t) {
		Set intersection = new Set();
		for (int i = 0; i < t.size(); i++) {
			for (int j = 0; j < size; j++) {
				if (set[j] == t.get(i)) {
					intersection.add(set[j]);
				}
			}
		} return intersection;
	}
	/**
	 * retainAll.
	 *
	 * @param      array  The array.
	 *
	 * @return     retainAll set.
	 */
	public Set retainAll(int[] array) {
		Set retainAll = new Set();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < array.length; j++) {
				if (set[i] == array[j]) {
					retainAll.add(set[i]);
				}
			}
		} return retainAll;
	}
	/**
	 * cartesianProduct.
	 *
	 * @param      u     set.
	 *
	 * @return     2d array.
	 */
	public int[][] cartesianProduct(Set u) {
		int[][] array = new int[size][2];
		for (int i = 0; i < size; i++) {
			array[i][0] = set[i];
			array[i][1] = u.get(i);
		} return array;
	}
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * helper function to convert string input to int array.
	 *
	 * @param      s     { string input from test case file }
	 *
	 * @return     { int array from the given string }
	 */
	public static int[] intArray(final String s) {
		String input = s;
		if (input.equals("[]")) {
			return new int[0];
		}
		if (s.contains("[")) {
			input = s.substring(1, s.length() - 1);
		}
		return Arrays.stream(input.split(","))
		       .mapToInt(Integer::parseInt)
		       .toArray();
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this set
		Set s = new Set();
		// code to read the test cases input file
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		// check if there is one more line to process
		while (stdin.hasNext()) {
			// read the line
			String line = stdin.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "size":
				System.out.println(s.size());
				break;
			case "contains":
				System.out.println(s.contains(Integer.parseInt(tokens[1])));
				break;
			case "print":
				System.out.println(s);
				break;
			case "add":
				int[] intArray = intArray(tokens[1]);
				if (intArray.length == 1) {
					s.add(intArray[0]);
				} else {
					s.add(intArray);
				}
				break;
			case "intersection":
				s = new Set();
				Set t = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				t.add(intArray);
				System.out.println(s.intersection(t));
				break;
			case "retainAll":
				s = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				System.out.println(s.retainAll(intArray));
				break;
			case "cartesianProduct":
				s = new Set();
				t = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				t.add(intArray);
				System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
				break;
			default:
				break;
			}
		}
	}
}
