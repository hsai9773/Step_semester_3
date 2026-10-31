package datastructures.class_problem;

import java.util.*;

class Student {
    String rollNumber;
    String name;

    Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student other = (Student) obj;
        return rollNumber.equals(other.rollNumber);
    }

    public int hashCode() {
        return rollNumber.hashCode();
    }
}

public class StudentClubRegistrationManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Student> members = new HashSet<>();

        while (sc.hasNext()) {
            String operation = sc.next();

            if (operation.equals("ADD")) {
                Student s = new Student(sc.next(), sc.next());

                if (members.add(s)) {
                    System.out.println("Added");
                } else {
                    System.out.println("duplicate rejected");
                }

            } else if (operation.equals("CONTAINS")) {
                Student s = new Student(sc.next(), sc.next());
                System.out.println("contains: " + members.contains(s));
            }
        }

        System.out.println("member count " + members.size());
        sc.close();
    }
}
