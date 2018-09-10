import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author : sairam.
 */
class Set {
    /**
     * set.
     */
    private int[] set;
    /**
     * size.
     */
    private int size;
    /**
     * magicnumber.
     */
    private final int x = 10;
    /**
     * Constructs the object.
     */
    Set() {
        set = new int[x];
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
    public boolean contains(final int item) {
        boolean checkFlag = false;
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
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
    public void addAll(final int[] newArray) {
        for (int a : newArray) {
            add(a);
        }
        set = Arrays.copyOf(set, size);
        Arrays.sort(set);
    }
    /**
     * add.
     *
     * @param      item  The item.
     */
    public void add(final int item) {
        if (!contains(item)) {
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
     * subset.
     *
     * @param      fromElement  The from element.
     * @param      toElement    To element.
     *
     * @return     { description_of_the_return_value }.
     */
    public int[] subSet(final int fromElement, final  int toElement) {
        int[] temp = new int[x];
        int s = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] >= fromElement && set[i] < toElement) {
                temp[s++] = set[i];
            }
        }
        temp = Arrays.copyOf(temp, s);
        return temp;
    }
    /**
     * headset.
     *
     * @param      toElement  To element.
     *
     * @return     { description_of_the_return_value }.
     */
    public int[] headSet(final int toElement) {
        int[] temp = new int[x];
        int s = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] < toElement) {
                temp[s++] = set[i];
            }
        }
        temp = Arrays.copyOf(temp, s);
        return temp;
    }
    /**
     * last.
     *
     * @return     last value.
     */
    public int last() {
    if (size != 0) {
        return set[size - 1];
    }
    System.out.println("Set Empty Exception");
    return -1;
    }
}
    /**
     * sorted set.
     */
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
            // based on the list operation
            // invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.
                    contains(Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.addAll(intArray);
                }
                break;
            case "subSet":
                String[] arrstring = tokens[1].split(",");
                if (Integer.parseInt(arrstring[0])
                      > Integer.parseInt(arrstring[1])) {
                    System.out.println("Invalid Arguments to Subset Exception");
                } else {
                    int[] subarray = s.subSet(Integer.parseInt(arrstring[0]),
                            Integer.parseInt(arrstring[1]));
                    Set subset = new Set();
                    subset.addAll(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                }
                break;
            case "headSet":
                int[] headarray = s.headSet(Integer.parseInt(tokens[1]));
                Set headset = new Set();
                headset.addAll(headarray);
                if (headset != null) {
                    System.out.println(headset);
                }
                break;
            case "last":
                System.out.println(s.last());
                break;
            default:
                break;
            }
        }
    }
}
