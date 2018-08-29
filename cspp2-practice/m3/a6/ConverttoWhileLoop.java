    /**
     * Class for ConverttoWhileLoop.
     */
public final class ConverttoWhileLoop {
    /**
     * Constructs the object.
     */
    public static final int NUM1 = 10;
    /**
     * Constructs the object.
     */
    private ConverttoWhileLoop() {
        //Empty constructor
    }
    /**
     * { It is the main function }.
     *
     * @param args  The arguments.
     */
    public static void main(final String[] args) {
        int i = 2;
        while (i <= NUM1) {
        System.out.println(i);
        i = i + 2;
        }
        System.out.println("GoodBye!");
    }
}
