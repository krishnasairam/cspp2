import java.io.BufferedInputStream;
import java.util.Scanner;
/**
* List of .
*/
class List {
    /**
    * list.
    */
    private int[] list;
    /**
    * size.
    */
    private int size;
    /**
     * magic number.
     */
    private final int x = 10;
    /**
     * Constructs the object.
     */
    List() {
        list = new int[x];
        size = 0;
    }
    /**
     * add.
     *
     * @param      item  The item.
     */
    public void add(final int item) {
        if (size == list.length) {
            resize();
        }
        list[size++] = item;
    }
    /**
     * resize.
     */
    public void resize() {
        int resizefactor = 2;
        int[] temp = new int[resizefactor * size];
        for (int i = 0; i < size; i++) {
            temp[i] = list[i];
        }
        list = temp;
    }
    /**
     * size.
     *
     * @return     { description_of_the_return_value }.
     */
    public int size() {
        return size;
    }
/**
 * remove.
 *
 * @param      index                      The index
 *
 * @throws     IndexOutOfBoundsException  { exception_description }
 */
    public void remove(final int index) throws IndexOutOfBoundsException {
        try {
            if (index >= 0 && index < size) {
                for (int i = index; i < size - 1; i++) {
                    list[i] = list[i + 1];
                }
                size--;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Position Exception");
        }
    }
    /**
     * get.
     *
     * @param      index  The index.
     *
     * @return     { description_of_the_return_value }.
     */
    public int get(final int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
    /**
     * contains.
     *
     * @param      item  The item,
     *
     * @return     { description_of_the_return_value }.
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item.
     *
     * @return     { description_of_the_return_value }.
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                return i;
            }
        } return -1;
    }
    /**
     * Adds all.
     *
     * @param      newArray  The new array.
     */
    public void addAll(final int[] newArray) {
        for (int a : newArray) {
            add(a);
        }
    }
    /**
     * Removes all.
     *
     * @param      newArray  The new array.
     */
    public void removeAll(final int[] newArray) {
        for (int each : newArray) {
            for (int i = 0; i < newArray.length; i++) {
                if (contains(each)) {
                    remove(indexOf(each));
                }
            }
        }

    }
/**
 * sublist.
 *
 * @param      start                      The start
 * @param      end                        The end
 *
 * @return     { description_of_the_return_value }
 *
 * @throws     IndexOutOfBoundsException  { exception_description }
 */
    public List subList(final int start, final int end)
     throws IndexOutOfBoundsException {
        // write the logic for subList
        //if (start >= 0 && start < size && end <= size
                //&& end >= 0 && start <= end) {
        try {
            if (start >= 0 && start < size && end <= size
                && end >= 0 && start <= end) {
                List lee = new List();
                for (int i = start; i < end; i++) {
                    lee.add(list[i]);
                } return lee;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Out of Bounds Exception");
            return null;
        }
    }
    /**
     * equals.
     *
     * @param      lis   The lis
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final List lis) {
        for (int i = 0; i < size; i++) {
            if (list[i] != lis.get(i)) {
                return false;
            }
        } return true;
    }
    /**
     * clear.
     */
    public void clear() {
        removeAll(list);
    }
    /**
     * count.
     *
     * @param      item     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final int item) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                count++;
            }
        } return count;
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
     * main.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        List l = new List();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "add":
                if (tokens.length == 2) {
                    String[] t = tokens[1].split(",");
                    if (t.length == 1) {
                        l.add(Integer.parseInt(tokens[1]));
                    }
                }
                break;
            case "size":
                System.out.println(l.size());
                break;
            case "print":
                System.out.println(l);
                break;
            case "remove":
                if (tokens.length == 2) {
                    l.remove(Integer.parseInt(tokens[1]));
                }
                break;
            case "indexOf":
                if (tokens.length == 2) {
                    System.out.println(l.indexOf(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "get":
                if (tokens.length == 2) {
                    System.out.println(l.get(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "contains":
                if (tokens.length == 2) {
                    System.out.println(l.contains(
                                           Integer.parseInt(tokens[1])));
                }
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    int[] temp = new int[t1.length];
                    for (int i = 0; i < temp.length; i++) {
                        temp[i] = Integer.parseInt(t1[i]);
                    }
                    l.addAll(temp);
                }
                break;
            case "removeAll":
                if (tokens.length == 2) {
                    String[] t2 = tokens[1].split(",");
                    int[] a = new int[t2.length];
                    for (int i = 0; i < t2.length; i++) {
                        a[i] = Integer.parseInt(t2[i]);
                    }
                    l.removeAll(a);
                }
                break;
            case "subList":
                if (tokens.length != 2) {
                    break;
                }
                String[] arrstring3 = tokens[1].split(",");
                List object = l.subList(Integer.parseInt(arrstring3[0]),
                                        Integer.parseInt(arrstring3[1]));
                if (object != null) {
                    System.out.println(object);
                }
                break;
            case "equals":
                if (tokens.length == 2) {
                    String[] lt = tokens[1].split(",");
                    List l2 = new List();
                    for (int k = 0; k < lt.length; k++) {
                        l2.add(Integer.parseInt(lt[k]));
                    }
                    System.out.println(l.equals(l2));
                }
                break;
            case "clear":
                l.clear();
                break;
            case "count":
                System.out.println(l.count(Integer.parseInt(tokens[1])));
                break;
            default:
                break;
            }
        }
    }
}

