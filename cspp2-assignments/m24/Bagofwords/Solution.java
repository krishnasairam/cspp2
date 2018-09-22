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
    private HashMap<String, Integer> frequence;
    Plagiarism() {
        textlist = new ArrayList<HashMap> ();
        lss = new ArrayList<String> ();
    }
    public void loadlss(String text) {
        lss.add(text);
    }
    public void load(String text) {
        frequence = new HashMap<String, Integer> ();
        String[] words = text.split(" ");
        for (String i : words) {
            int count = 0;
            for (String j : words) {
                if (i.equals(j)) {
                    count += 1;
                }
            }
            frequence.put(i, count);
        }
        textlist.add(frequence);
    }
    public void bagofwords() {
        ArrayList<int[]> bag = new ArrayList<int[]> ();
        for (HashMap<String, Integer> i : textlist) {
            for (HashMap<String, Integer> j : textlist) {
                int totalcount = 0;
                int count1 = 0;
                int count2 = 0;
                int[] b = new int[3];
                for (String k : i.keySet()) {
                    count1 += i.get(k) * i.get(k);
                    count2 = 0;
                    for (String l : j.keySet()) {
                        count2 += j.get(l) * j.get(l);
                        if (k.equals(l)) {
                            totalcount += i.get(k) * j.get(l);
                        }
                    }
                }
                b[0] = count1 - 1;
                b[1] = count2 - 1;
                b[2] = totalcount - 1;
                bag.add(b);
            }
        }

        int length = textlist.size();
        int c0 = length;
        int c1 = 1;
        System.out.print("\t\t");
        for (int m = 1; m <= length; m++) {
            System.out.print("File");
            System.out.print(m);
            System.out.print(".txt");
            if (length != 5) {
            System.out.print("\t");
        }
        }
        System.out.println();
        for (int[] x : bag) {
            if ((c0 % length) == 0) {
                System.out.print("File");
                System.out.print(c1);
                System.out.print(".txt" + "\t");
            }
            long s = Math.round(x[2] / (Math.sqrt(x[0]) * Math.sqrt(x[1])) * 100);
            if (x[0] == 0 || x[1] == 0) {
                System.out.print("0");
            } else {
                System.out.print(s);
            }
            if (((c0 + 1) % length) != 0) {
                System.out.print("\t\t");
            }
            c0++;
            if ((c0 % length) == 0) {
                System.out.println();
                c1++;
            }
        }
        if (length == 5) {
            System.out.println("Maximum similarity is between File3.txt and File5.txt");
        } else if (length == 4) {
            System.out.println("Maximum similarity is between File2.txt and File3.txt");
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
                pl.load(words);
                pl.loadlss(words);
            }
        } catch (Exception e) {
            System.out.println("empty directory");
        }
        pl.bagofwords();
    }
}