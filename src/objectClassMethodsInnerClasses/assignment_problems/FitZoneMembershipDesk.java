package objectClassMethodsInnerClasses.assignment_problems;
interface MembershipPlan {
    double calculateFee();
    int getMonths();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() { return 1000; }
    public int getMonths() { return 1; }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() { return 1000 * 3 * 0.90; }
    public int getMonths() { return 3; }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() { return 1000 * 12 * 0.75; }
    public int getMonths() { return 12; }
}

class Member {
    String name;
    Member(String name) { this.name = name; }
}

class Membership {
    Member member;
    MembershipPlan plan;
    private String status = "Active";

    Membership(Member m, MembershipPlan p) {
        member = m; plan = p;
        System.out.println(member.name + " fee ₹" + String.format("%.0f", plan.calculateFee()) + " Active.");
    }

    void checkIn() {
        if (status.equals("Active"))
            System.out.println(member.name + " checked in.");
        else
            System.out.println("Check-in denied because " + status + ".");
    }

    void freeze() {
        if (status.equals("Expired"))
            System.out.println("Cannot freeze Expired.");
        else {
            status = "Frozen";
            System.out.println(member.name + " frozen.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member.name + " unfrozen.");
        }
    }

    void expire() {
        status = "Expired";
        System.out.println(member.name + " expired.");
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        Member asha = new Member("Asha"), ravi = new Member("Ravi");
        Membership a = new Membership(asha, new QuarterlyPlan());
        Membership r = new Membership(ravi, new MonthlyPlan());

        a.checkIn();
        a.freeze();
        a.checkIn();
        r.expire();
        r.freeze();
    }
}