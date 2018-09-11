import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author : sairam.
 */
class SortedSetADT {
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
    SortedSetADT() {
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
     * intersection.
     *
     * @param      t     set.
     *
     * @return     intersection set.
     */
    public SortedSetADT intersection(final SortedSetADT t) {
        SortedSetADT intersection = new SortedSetADT();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < t.size(); j++) {
                if (set[i] == t.get(j)) {
                    intersection.add(set[i]);
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
    public SortedSetADT retainAll(final int[] array) {
        SortedSetADT retainAll = new SortedSetADT();
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
     * @param      t     set.
     *
     * @return     2d array.
     */

    public int[][] cartesianProduct(final SortedSetADT t) {
        if (size != 0 && t.size != 0) {
            int[][] carray = new int[size * t.size()][2];
            System.out.println(t.get(1));
            int s = 0;
            for (int i = 0; i < this.size(); i++) {
                for (int k = 0; k < t.size(); k++) {
                    carray[s][0] = set[i];
                    carray[s][1] = t.get(k);
                    s++;
                }
            } return carray;
        }
        return null;
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
    try {
        return set[size - 1];
    } catch (IndexOutOfBoundsException e) {
        System.out.println("Set Empty Exception");
    }
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
        SortedSetADT s = new SortedSetADT();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
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
                    SortedSetADT subset = new SortedSetADT();
                    subset.addAll(subarray);
                    if (subset != null) {
                        System.out.println(subset);
                    }
                }
                break;
            case "headSet":
                int[] headarray = s.headSet(Integer.parseInt(tokens[1]));
                    SortedSetADT headset = new SortedSetADT();
                headset.addAll(headarray);
                if (headset.size() != 0) {
                    System.out.println(headset);
                } else {
                    System.out.println("Set Empty Exception");
                }
                break;
            case "last":
                if (s.last() != -1) {
                    System.out.println(s.last());
                }
                break;
            case "intersection":
                s = new SortedSetADT();
                SortedSetADT t = new SortedSetADT();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new SortedSetADT();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new SortedSetADT();
                t = new SortedSetADT();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(Arrays.
                    deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
