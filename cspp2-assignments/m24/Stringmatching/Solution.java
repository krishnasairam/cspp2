import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
class Plagiarism {
    private ArrayList<HashMap> textlist;
    private ArrayList<String> lss;
    Plagiarism() {
        textlist = new ArrayList<HashMap> ();
        lss = new ArrayList<String> ();
    }
    public void loadlss(String text) {
        lss.add(text);
    }
    public void longestsubstring() {
        List<Long> listsub = new ArrayList<Long>();
        //System.out.println(lss);
        for (String i : lss) {
            for (String j : lss) {
                String sub = "";
                for (int k = 0; k < j.length();) {
                    for (int l = k ; l < j.length(); l++) {
                        if (i.contains(j.substring(k, l + 1)) && sub.length() < j.substring(k, l).length()) {
                            sub = j.substring(k, l + 1);
                        } else {
                            break;
                        }
                    }
                    k += sub.length();
                }
                double a = sub.length();
                double b = i.length();
                double c = j.length();
                System.out.println(Math.round((a * 2 / (b + c)) * 100));
            }
        }
    }
}
public class Solution {
    public static void main(String[] args) throws Exception {
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
