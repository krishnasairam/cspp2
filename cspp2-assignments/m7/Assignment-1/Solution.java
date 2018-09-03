import java.util.*;
class InputValidator {
	public String data;
	public InputValidator (String d) {
    data = d; 
	}
	boolean validateData () {
	if (data.length() == 6) {
		return true;
	} else {
		return false;
	}
}
}
public class Solution
{
	public static void main(String args[])
    {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
