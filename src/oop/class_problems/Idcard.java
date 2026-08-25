package oop.class_problems;
public class Idcard {
    String name;
    int booksIssued;
    Idcard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
    public static void main(String[] args) {
        Idcard ravi = new Idcard("Ravi", 0);
        Idcard duplicate = ravi;
        duplicate.booksIssued = 3;
        Idcard separate = new Idcard("Ravi", 3);
        System.out.println(
                "Ravi's booksIssued (via first variable): "
                + ravi.booksIssued
        );
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}