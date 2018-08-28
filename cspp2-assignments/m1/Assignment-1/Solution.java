import java.util.Scanner;
/**
    * Date: 28-08-2018.
    * Name: Sai Ram.
    * print your Name, Roll number.
*/
public final class Solution {
    /**
        * name and rollnumber class.
    */
    private Solution() {
    /**
        * default constructor.
    */
    }
    /**
        * main function.
        * @param args is for command line arguments.
    */
    public static void main(final String[] args) {
        System.out.println("enter name and rollnumber");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String rollnumber = scan.nextLine();
        System.out.print("Name :" + name + "\n"
        + "Roll Number : " + rollnumber);
    }
}
