import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
             final int correctAnswer1, final int maxMarks1, final int penalty1) {
        questiontext = question1;
        choices = choices1;
        correctAnswer = correctAnswer1;
        maxMarks = maxMarks1;
        penalty = penalty1;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse() {
        return choices[correctAnswer - 1].equals(response);
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return Integer.toString(correctAnswer);
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[onehundred];
        size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    public int getSize() {
        return size;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        try {
            return (questions[index]);
        } catch (Exception e) {
        }
        return null;
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        return s;
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
    public static boolean exceptions(String[] token) {
        String[] choices = token[1].split(",");
        if (token[0] == "" || token[4] == "") {
            System.out.println("Error! Malformed question");
            return true;
        } else {
            if (Integer.parseInt(token[4]) > 0) {
                System.out.println("Invalid penalty for " + token[0]);
                return true;
            } else {
                if (Integer.parseInt(token[3]) < 0) {
                    System.out.println("Invalid max marks for " + token[0]);
                    return true;
                } else {
                    if (choices.length < 2) {
                        System.out.println(token[0] + " does not have enough answer choices");
                        return true;
                    } else {
                        if ((Integer.parseInt(token[2]) > 4)) {
                            System.out.println("Error! Correct answer choice number is out of range for question text 1");
                            return true;
                        }
                    }
                }
            }
        } return false;
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
                                     final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        int count = 0;
        if (q == 0) {
            System.out.println("Quiz does not have questions");
        } else {
            for (int i = 0; i < q; i++) {
                String new_line = scan.nextLine();
                String[] token = new_line.split(":");
                String[] choices = token[1].split(",");
                if (!exceptions(token)) {
                    try {
                        quiz.addQuestion(new Question(token[0], choices, Integer.parseInt(token[2])
                                                      , Integer.parseInt(token[3]), Integer.parseInt(token[4])));
                        count++;
                    } catch (Exception e) {
                        System.out.println("Error! Malformed question");
                        break;
                    }
                }
            }
            if (count == q) {
                System.out.println(Integer.toString(q) + " are added to the quiz");
            }
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
                                 final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        for (int qu = 0; qu < quiz.getSize(); qu++) {
            String new_line1 = scan.nextLine();
            (quiz.getQuestion(qu)).setResponse(new_line1);
            System.out.println((quiz.getQuestion(qu)).getQuestionText() + "(" + (quiz.getQuestion(qu)).getMaxMarks() + ")");
            String[] token2 = (quiz.getQuestion(qu)).getChoice();
            if (token2.length == 2) {
                System.out.println(token2[0] + "	" + token2[1]);
            } else if (token2.length == 3) {
                System.out.println(token2[0] + "	" + token2[1] + "	" + token2[2]);
            } else {
                System.out.println(token2[0] + "	" + token2[1] + "	" + token2[2] + "	" + token2[3]);
            }
            System.out.println();
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        if (quiz.getSize() != 0) {
            int totalscore = 0;
            for (int q = 0; q < quiz.getSize(); q++) {
                System.out.println((quiz.getQuestion(q)).getQuestionText());
                if ((quiz.getQuestion(q)).evaluateResponse()) {
                    System.out.println(" Correct Answer! - Marks Awarded: " + Integer.toString((quiz.getQuestion(q)).getMaxMarks()));
                    totalscore += quiz.getQuestion(q).getMaxMarks();
                } else {
                    System.out.println(" Wrong Answer! - Penalty: " + Integer.toString((quiz.getQuestion(q)).getPenalty()));
                    totalscore += quiz.getQuestion(q).getPenalty();
                }
            }
            System.out.println("Total Score: " + Integer.toString(totalscore));
        }
    }
}
