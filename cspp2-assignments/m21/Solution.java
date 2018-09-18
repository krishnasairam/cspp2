import java.util.Scanner;
import java.util.ArrayList;
class Foodlog {
    private String nameoffood;
    private String quantity;
    private String date;
    private String time;
    Foodlog() {

    }
    Foodlog(String[] food) {
        nameoffood = food[0];
        quantity = food[1];
        date = food[2];
        time = food[3];
    }
    public String getdate() {
        return date;
    }
    public String toString() {
        String s = "Food" + "\n";
        s += "Date :" + date + "\n";
        s += "Time :" + time + "\n";
        s += "Name :" + nameoffood + "\n";
        s += "Quantity :" + quantity;
        return s;
    }
}
class Waterlog {
    private String quantity;
    private String date;
    private String time;
    Waterlog() {

    }
    Waterlog(String[] water) {
        quantity = water[0];
        date = water[1];
        time = water[2];
    }
    public String getdate() {
        return date;
    }
    public String toString() {
        String s = "Water" + "\n";
        s += "Date :" + date + "\n";
        s += "Quantity :" + quantity;
        return s;
    }
}
class PhysicalActivites {
    private String activity;
    private String date;
    private String starttime;
    private String endtime;
    private String notes;
    PhysicalActivites() {

    }
    PhysicalActivites(String[] activites) {
        activity = activites[0];
        notes = activites[1];
        date = activites[2];
        starttime = activites[3];
        endtime = activites[4];
    }
    public String getdate() {
        return date;
    }
    public String toString() {
        String s = "PhysicalActivity" + "\n";
        s += "Name :" + activity + "\n";
        s += "Note :" + notes + "\n";
        s += "Date :" + date + "\n";
        s += "Starttime :" + starttime + "\n";
        s += "Endtime :" + endtime;
        return s;
    }
}
class Weightlog {
    private String weight;
    private String fat;
    private String date;
    private String time;
    Weightlog() {

    }
    Weightlog(String[] mass) {
        date = mass[0];
        time = mass[1];
        weight = mass[2];
        fat = mass[3];
    }
    public String getdate() {
        return date;
    }
    public String toString() {
        String s = "Weight" + "\n";
        s += "Date :" + date + "\n";
        s += "Time :" + time + "\n";
        s += "Weight :" + weight + "\n";
        s += "Fat :" + fat;
        return s;
    }
}
class Sleeplog {
    private String date;
    private String starttime;
    private String endtime;
    Sleeplog() {

    }
    Sleeplog(String[] sleep) {
        date = sleep[0];
        starttime = sleep[1];
        endtime = sleep[2];
    }
    public String getdate() {
        return date;
    }
    public String toString() {
        String s = "Sleep" + "\n";
        s += "Date :" + date + "\n";
        s += "Starttime :" + starttime + "\n";
        s += "Endtime :" + endtime;
        return s;
    }
}
class Fitbyte {
    private ArrayList<Foodlog> food;
    private ArrayList<Waterlog> water;
    private ArrayList<PhysicalActivites> activites;
    private ArrayList<Weightlog> weight;
    private ArrayList<Sleeplog> sleep;
    Fitbyte() {
        food = new ArrayList<Foodlog>();
        water = new ArrayList<Waterlog>();
        activites = new ArrayList<PhysicalActivites>();
        weight = new ArrayList<Weightlog>();
        sleep = new ArrayList<Sleeplog>();
    }
    public void addfoodlog(Foodlog a) {
        food.add(a);

    }
    public void addwaterlog(Waterlog b) {
        water.add(b);
    }
    public void addactivites(PhysicalActivites c) {
        activites.add(c);
    }
    public void addweight(Weightlog d) {
        weight.add(d);
    }
    public void addsleep(Sleeplog e) {
        sleep.add(e);
    }
    public void printfoodlog() {
        for (Foodlog f : food) {
            System.out.println(f);
        }
    }
    public void printwaterlog() {
        for (Waterlog w : water) {
            System.out.println(w);
        }
    }
    public void printactivites() {
        for (PhysicalActivites p : activites) {
            System.out.println(p);
        }
    }
    public void printweight() {
        for (Weightlog e : weight) {
            System.out.println(e);
        }
    }
    public void printsleep() {
        for (Sleeplog s : sleep) {
            System.out.println(s);
        }
    }
    public void printall() {
        printfoodlog();
        printwaterlog();
        printactivites();
        printweight();
        printsleep();
    }
    public void summarydate(String date) {
        for (Foodlog f : food) {
            if (f.getdate().equals(date)) {
                System.out.println(f);
            }
        }
        for (Waterlog w : water) {
            if (w.getdate().equals(date)) {
                System.out.println(w);
            }
        }
        for (PhysicalActivites p : activites) {
            if (p.getdate().equals(date)) {
                System.out.println(p);
            }
        }
        for (Weightlog e : weight) {
            if (e.getdate().equals(date)) {
                System.out.println(e);
            }
        }
        for (Sleeplog s : sleep) {
            if (s.getdate().equals(date)) {
                System.out.println(s);
            }
        }
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
        Fitbyte q = new Fitbyte();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] tokens = line.split(" ");
            String[] token;
            switch (tokens[0]) {
            case "Food":
                token = tokens[1].split(",");
                Foodlog f = new Foodlog(token);
                q.addfoodlog(f);
                break;
            case "Water":
                token = tokens[1].split(",");
                Waterlog w = new Waterlog(token);
                q.addwaterlog(w);
                break;
            case "PhysicalActivity":
                token = tokens[1].split(",");
                PhysicalActivites p = new PhysicalActivites(token);
                q.addactivites(p);
                break;
            case "Weight":
                token = tokens[1].split(",");
                Weightlog e = new Weightlog(token);
                q.addweight(e);
                break;
            case "Sleep":
                token = tokens[1].split(",");
                Sleeplog sl = new Sleeplog(token);
                q.addsleep(sl);
                break;
            case "Foodlog":
                q.printfoodlog();
                System.out.println();
                break;
            case "Waterlog":
                q.printwaterlog();
                System.out.println();
                break;
            case "PhysicalActivites":
                q.printactivites();
                System.out.println();
                break;
            case "Weightlog":
                q.printweight();
                System.out.println();
                break;
            case "Sleeplog":
                q.printsleep();
                System.out.println();
                break;
            case "Summary":
                if (tokens.length == 2) {
                    q.summarydate(tokens[1]);
                } else {
                    q.printall();
                }
                break;
            default:
                break;
            }
        }
    }
}