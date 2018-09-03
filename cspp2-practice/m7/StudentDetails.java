/**
 * Class for student details.
 */
class StudentDetails{
    /**
     * Constructs the object.
     */
    public String name , number;
    public double m1, m2 , m3;

    public StudentDetails(String n, String num, double x1, double x2, double x3) {
        name = n;
        number = num;
        m1 = x1;
        m2 = x2;
        m3 = x3;
    }
    float gpa () {
        return (float) (m1 + m2 + m3) / 3;
    }
    public static void main(String[] args) {
        StudentDetails s1 = new StudentDetails("Sangay", "IT201985001", 7.5, 7.0, 8.0);
        StudentDetails s2 = new StudentDetails("Bidhya", "IT201985003", 8.5, 6.0, 7.5);
        StudentDetails s3 = new StudentDetails("Kelzang", "IT201985065", 7.5, 8.0, 9.0);
        System.out.printf("%.1f\n",s1.gpa());
        System.out.printf("%.1f\n",s2.gpa());
        System.out.printf("%.1f\n",s3.gpa());
    }
}