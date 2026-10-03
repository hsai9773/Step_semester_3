package objectClassMethodsInnerClasses.class_problems;

import java.util.*;

abstract class Question {

    protected int questionNumber;
    protected String questionText;
    protected int marks;

    public Question(int questionNumber,
                    String questionText,
                    int marks) {

        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.marks = marks;
    }

    public abstract boolean evaluate(String answer);

    public int getMarks() {
        return marks;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void display() {
        System.out.println(
            questionNumber + ". " + questionText
        );
    }
}

class MultipleChoiceQuestion extends Question {

    private String correctAnswer;

    public MultipleChoiceQuestion(
            int questionNumber,
            String questionText,
            int marks,
            String correctAnswer) {

        super(questionNumber, questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class TrueFalseQuestion extends Question {

    private String correctAnswer;

    public TrueFalseQuestion(
            int questionNumber,
            String questionText,
            int marks,
            String correctAnswer) {

        super(questionNumber, questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class ShortAnswerQuestion extends Question {

    private String correctAnswer;

    public ShortAnswerQuestion(
            int questionNumber,
            String questionText,
            int marks,
            String correctAnswer) {

        super(questionNumber, questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Attempt {

    private Student student;
    private Examination examination;

    private HashMap<Integer, String> answers;

    private boolean submitted;

    public Attempt(Student student, Examination examination) {

        this.student = student;
        this.examination = examination;

        answers = new HashMap<>();
        submitted = false;
    }

    public void recordAnswer(int questionNumber,
                             String answer) {

        if (submitted) {
            System.out.println(
                "Cannot change answers for a submitted examination."
            );
            return;
        }

        answers.put(questionNumber, answer);

        System.out.println(
            "Answer recorded for Question "
            + questionNumber
        );
    }

    public void submit() {

        if (submitted) {
            System.out.println("Examination already submitted.");
            return;
        }

        submitted = true;

        System.out.println(
            "\nExam submitted by " + student.getName()
        );

        calculateResult();
    }

    private void calculateResult() {

        int totalScore = 0;
        int totalMarks = 0;

        System.out.println("\nResult:");

        for (Question question : examination.getQuestions()) {

            totalMarks += question.getMarks();

            String answer =
                answers.get(question.getQuestionNumber());

            if (answer != null &&
                question.evaluate(answer)) {

                totalScore += question.getMarks();

                System.out.println(
                    "Question "
                    + question.getQuestionNumber()
                    + ": Correct ("
                    + question.getMarks()
                    + " points)"
                );

            } else {

                System.out.println(
                    "Question "
                    + question.getQuestionNumber()
                    + ": Incorrect (0 points)"
                );
            }
        }

        System.out.println(
            "Total Score: "
            + totalScore
            + "/"
            + totalMarks
        );
    }
}

class Examination {

    private String examName;
    private ArrayList<Question> questions;

    public Examination(String examName) {

        this.examName = examName;
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void displayQuestions() {

        System.out.println("\n" + examName);

        for (Question question : questions) {
            question.display();
        }
    }
}

public class OnlineExaminationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        Student student = new Student(sc.nextLine());

        Examination exam =
            new Examination("Java OOP Examination");

        exam.addQuestion(
            new MultipleChoiceQuestion(
                1,
                "Which concept allows one interface with many implementations?",
                5,
                "C"
            )
        );

        exam.addQuestion(
            new TrueFalseQuestion(
                2,
                "Java supports inheritance.",
                5,
                "True"
            )
        );

        exam.addQuestion(
            new ShortAnswerQuestion(
                3,
                "Which keyword is used to inherit a class in Java?",
                5,
                "extends"
            )
        );

        System.out.println(
            "\nExam started by " + student.getName()
        );

        exam.displayQuestions();

        Attempt attempt =
            new Attempt(student, exam);

        System.out.print("\nEnter answer for Question 1: ");
        String answer1 = sc.nextLine();

        attempt.recordAnswer(1, answer1);

        System.out.print("Enter answer for Question 2: ");
        String answer2 = sc.nextLine();

        attempt.recordAnswer(2, answer2);

        System.out.print("Enter answer for Question 3: ");
        String answer3 = sc.nextLine();

        attempt.recordAnswer(3, answer3);

        attempt.submit();

        System.out.println(
            "\nAttempting to change Question 1..."
        );

        attempt.recordAnswer(1, "A");

        sc.close();
    }
}