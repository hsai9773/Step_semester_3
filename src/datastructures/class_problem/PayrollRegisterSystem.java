package datastructures.class_problem;

import java.util.*;

class Payslip {
    String name;
    String type;
    int pay;

    Payslip(String name, String type, int pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    public String toString() {
        return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay + "]";
    }
}

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Payslip> slips = new ArrayList<>();

        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();
            int pay;

            if (type.equals("FullTime")) {
                pay = sc.nextInt();
            } else if (type.equals("PartTime")) {
                int hours = sc.nextInt();
                int rate = sc.nextInt();
                pay = hours * rate;
            } else {
                pay = sc.nextInt();
            }

            slips.add(new Payslip(name, type, pay));
        }

        int total = 0;
        Payslip topper = slips.get(0);

        for (Payslip p : slips) {
            System.out.println(p);
            total += p.pay;

            if (p.pay > topper.pay) {
                topper = p;
            }
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + topper.name);

        sc.close();
    }
}