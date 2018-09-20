import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;
class Socialnetwork {
	HashMap<String, ArrayList<String>> network = new HashMap<String, ArrayList<String>> ();
	Socialnetwork() {
	}
	public void addfollow(String name, String[] follow) {
		ArrayList<String> follows = new ArrayList<String>(Arrays.asList(follow));
		network.put(name, follows);
	}
	public void addf(String name, String follow) {
		if (network.containsKey(name)) {
			network.get(name).add(follow);
		}
	}
	public ArrayList<String> getconnection(String name) {
		if (network.containsKey(name)) {
			return network.get(name);
		}
		return null;

	}
	public ArrayList<String> getcommonconnection(String names1, String names2) {
		ArrayList<String> s1 = new ArrayList<String> ();
		for (String e : network.get(names1)) {
			if (network.get(names2).contains(e)) {
				s1.add(e);
			}
		}
		return s1;
	}
	public void network() {
		ArrayList<String> s2 = new ArrayList<String>(network.keySet());
		Collections.sort(s2);
		String s = "";
		for (String item : s2) {
			s += item + ":" + network.get(item) + ", ";
		}
		System.out.println(s.substring(0, s.length() - 2));
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
		// leave this blank
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Socialnetwork s = new Socialnetwork();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.replace(".", "").split(" is connected to ");
			if (tokens.length == 2) {
				String[] token = tokens[1].split(", ");
				s.addfollow(tokens[0], token);
			} else {
				String[] follow = line.split(" ");
				switch (follow[0]) {
				case "getConnections":
					if (s.getconnection(follow[1]) != null) {
						System.out.println(s.getconnection(follow[1]));
					} else {
						System.out.println("Not a user in Network");
					}
					break;
				case "addConnections":
					s.addf(follow[1], follow[2]);
					break;
				case "CommonConnections":
					if (s.getconnection(follow[1]) != null) {
					System.out.println(s.getcommonconnection(follow[1], follow[2]));
					} else {
						System.out.println("Not a user in Network");
					}
					break;
				case "Network":
					s.network();
					break;
				default	:
				break;
				}
			}
		}
	}
}

