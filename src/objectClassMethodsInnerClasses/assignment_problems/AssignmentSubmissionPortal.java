package objectClassMethodsInnerClasses.assignment_problems;

import java.time.*;
import java.util.*;

abstract class Assignment {
    String title;
    double maxMarks;
    LocalDate dueDate;

    Assignment(String title, double maxMarks, LocalDate dueDate) {
        this.title = title; this.maxMarks = maxMarks; this.dueDate = dueDate;
    }

    abstract double penalty(int daysLate);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String t, double m, LocalDate d) { super(t, m, d); }
    double penalty(int daysLate) { return daysLate * 0.10; }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String t, double m, LocalDate d) { super(t, m, d); }
    double penalty(int daysLate) { return daysLate * 0.20; }
}

class Student {
    String name;
    Student(String name) { this.name = name; }
}

class Submission {
    Student student;
    Assignment assignment;
    LocalDate date;
    String status = "Submitted";
    double marks;

    Submission(Student s, Assignment a, LocalDate d) {
        student = s; assignment = a; date = d;
    }

    void grade(double awarded) {
        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade again.");
            return;
        }

        long late = Math.max(0, java.time.temporal.ChronoUnit.DAYS.between(assignment.dueDate, date));
        marks = awarded * (1 - assignment.penalty((int) late));
        status = "Graded";

        System.out.println(student.name + " graded " + String.format("%.0f", marks) + "/" +
                String.format("%.0f", assignment.maxMarks) + " after " + late + " day(s) late, Graded.");
    }

    void resubmit() {
        if (status.equals("Graded"))
            System.out.println("Cannot resubmit because already graded.");
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Student asha = new Student("Asha"), ravi = new Student("Ravi");

        Assignment coding = new CodingAssignment("Linked List Lab", 50, LocalDate.of(2026, 3, 10));
        Assignment written = new WrittenAssignment("Design Essay", 50, LocalDate.of(2026, 3, 12));

        Submission s1 = new Submission(asha, coding, LocalDate.of(2026, 3, 10));
        Submission s2 = new Submission(ravi, written, LocalDate.of(2026, 3, 14));

        System.out.println("Asha received on time, Submitted.\nRavi 2 days late, Submitted.");
        s1.grade(45);
        s2.grade(40);
        s1.resubmit();
    }
}