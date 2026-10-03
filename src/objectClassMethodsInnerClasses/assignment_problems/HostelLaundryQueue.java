package objectClassMethodsInnerClasses.assignment_problems;

import java.util.*;

abstract class WashType {
    abstract int getDuration();
    abstract double getCharge();
    abstract String getName();
}

class QuickWash extends WashType {
    int getDuration() { return 30; }
    double getCharge() { return 20; }
    String getName() { return "Quick"; }
}

class NormalWash extends WashType {
    int getDuration() { return 45; }
    double getCharge() { return 30; }
    String getName() { return "Normal"; }
}

class HeavyWash extends WashType {
    int getDuration() { return 60; }
    double getCharge() { return 45; }
    String getName() { return "Heavy"; }
}

class Student {
    String name;
    Student(String name) { this.name = name; }
}

class WashCycle {
    Student student;
    WashingMachine machine;
    WashType type;

    WashCycle(Student s, WashingMachine m, WashType t) {
        student = s; machine = m; type = t;
    }
}

class WashingMachine {
    String id;
    private boolean free = true;
    WashCycle cycle;

    WashingMachine(String id) { this.id = id; }

    void startWash(Student s, WashType type) {
        if (!free) {
            System.out.println(id + " busy.");
            return;
        }
        cycle = new WashCycle(s, this, type);
        free = false;
        System.out.println(type.getName() + " wash started on " + id + " for " + s.name +
                " (" + type.getDuration() + " min). Charge ₹" + String.format("%.2f", type.getCharge()) + ".");
    }

    void completeWash() {
        if (!free) {
            System.out.println(id + " completed, now free.");
            free = true;
            cycle = null;
        }
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        Student asha = new Student("Asha"), ravi = new Student("Ravi"), neha = new Student("Neha");
        WashingMachine m1 = new WashingMachine("M1"), m2 = new WashingMachine("M2");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeWash();
        m1.startWash(neha, new NormalWash());
    }
}