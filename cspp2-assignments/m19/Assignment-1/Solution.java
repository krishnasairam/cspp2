import java.util.Scanner;
import java.util.ArrayList;
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
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static ArrayList<Quiz> quizs = new ArrayList<Quiz>();
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        System.out.println(Integer.toString(questionCount) + "are added to the quiz");
        for (int i = 0; i < questionCount; i++) {
            String new_line = s.nextLine();
            String[] token = new_line.split(":");
            quiz.setQuiz(token[0], token[1], Integer.parseInt(token[2])
                        , Integer.parseInt(token[3]), Integer.parseInt(token[4]));
            quizs.add(quiz);
        }
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        int j = 0;
        for (Quiz q : quizs) {
            if (j < answerCount) {
                String new_line1 = s.nextLine();
                String[] token1 = new_line1.split(" ");
                q.setcorrectanswer(Integer.parseInt(token1[1]));
                System.out.println(q.getquestion());
                System.out.println(q.getoptions());
                System.out.println();
                j++;
            }
        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        int totalscore = 0;
        for (Quiz q : quizs) {
            System.out.println(q.getquestion());
            if (q.getanswer() == q.getcorrectanswer()) {
                System.out.printf("Correct Answer! - Marks Awarded: " , q.getmarks());
                totalscore += q.getmarks();
            } else {
                System.out.printf("Wrong Answer! - Marks Awarded: " , q.getpenalty());
                totalscore += q.getpenalty();
            }
        }
        System.out.printf("Total Score: ", totalscore);
    }
    static class Quiz {
        private String question;
        private String options;
        private int answer;
        private int marks;
        private int penalty;
        private int correctanswer;
        public Quiz() {
            // empty constructor
        }
        public void setQuiz(String ques, String opt, int ans, int mark, int pena) {
            question = ques;
            options = opt;
            answer = ans;
            marks = mark;
            penalty = pena;
            correctanswer = 0;
        }
        public void setcorrectanswer(int correct) {
            correctanswer = correct;

        }
        public String getquestion() {
            return question;
        }
        public String getoptions() {
            return options;
        }
        public int getanswer() {
            return answer;
        }
        public int getmarks() {
            return marks;
        }
        public int getpenalty() {
            return penalty;
        }
        public int getcorrectanswer() {
            return correctanswer;
        }
    }

}


