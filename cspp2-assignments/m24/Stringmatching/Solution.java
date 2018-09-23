import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
/**
 * Class for plagiarism.
 */
class Plagiarism {
    /**
     * lss.
     */
    private ArrayList<String> lss;
    /**
    * Constructs the object.
    */
    Plagiarism() {
        lss = new ArrayList<String>();
    }
    /**
     * loadlss.
     *
     * @param      text  The text.
     */
    public void loadlss(final String text) {
        lss.add(text);
    }
    /**
     * longestsubstring.
     */
    public void longestsubstring() {
        System.out.print("      " + "\t\t");
        for (int m = 1; m <= lss.size(); m++) {
            System.out.print("File");
            System.out.print(m);
            System.out.print(".txt");
            System.out.print("\t");
        }
        System.out.println();
        ArrayList<Long> listsub = new ArrayList<Long>();
        int x = 1;
        int[] z = new int[1 + 2];
        for (String i : lss) {
            String s = "File" + Integer.toString(x) + ".txt";
            int y = 1;
            System.out.print(s + "\t");
            for (String j : lss) {
                String sub = "";
                for (int k = 0; k < j.length();) {
                    if (i.length() == 0) {
                        break;
                    }
                    for (int l = k; l < j.length(); l++) {
                        if ((i.contains(j.substring(k, l + 1))
                         && sub.length() <= j.substring(k, l).length())) {
                            sub = j.substring(k, l + 1);
                        }
                    }
                    k += sub.length();
                }
                final int number = 100;
                double a = sub.length();
                double b = i.length();
                double c = j.length();
                double d = (double) (Math.round((a * 2 / (b + c)) * number));
                if (z[0] < (int) d && (int) d != number) {
                    z[0] = (int) d;
                    z[1] = x;
                    z[2] = y;
                }
                if (i.equals(j)) {
                    System.out.print((double) number);
                } else {
                    System.out.print(d);
                }
                System.out.print("\t\t");
                y++;
            }
            System.out.println();
            x++;
        }
        if (z[1] != 0) {
            System.out.println("Maximum similarity is between file"
 + Integer.toString(z[1]) + ".txt and file" + Integer.toString(z[2]) + ".txt");
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        //Empty.
    }

    /**
    * {Main method}.
    *
    * @param      args       The arguments
    *
    * @throws     Exception  {Exception class}
    */
    public static void main(final String[] args) throws Exception {
        Plagiarism pl = new Plagiarism();
        Scanner scan = new Scanner(System.in);
        try {
            File folder = new File(scan.next());
            File[] listOfFiles = folder.listFiles();
            for (File i : listOfFiles) {
                FileReader fr = new FileReader(i);
                BufferedReader br = new BufferedReader(fr);
                String buffer = "";
                String s;
                while (((s = br.readLine()) != null)) {
                    buffer += s;
                }
                Pattern p = Pattern.compile("[^a-z A-Z 0-9]");
                Matcher m = p.matcher(buffer);
                String words = m.replaceAll("").replace(".", " ").toLowerCase();
                br.close();
                fr.close();
                pl.loadlss(words);
            }
        } catch (Exception e) {
            System.out.println("Empty Directory");
        }
        pl.longestsubstring();
    }
}




