/**.
    * Date: 21-08-2018.
    * Name: Sai Ram.
    * Swaping 2 numbers.
*/
public final class swap {

    /**
        * default constructor.
    */
    private swap() {
        // unused
    }

    /**
        * main function.
        * @param args is for commsnd line arguments.
    */
    public static void main(final String[] args) {
        int a = 2, b = 3, t;
        t = a;
        a = b;
        b = t;
        System.out.println(a);
        System.out.println(b);
    }
}
