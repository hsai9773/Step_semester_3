package inheritance_polymorphism.class_problems;



import java.util.Arrays;

class LibraryMember3 {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    public LibraryMember3(
            String memberId,
            int borrowLimit) {

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    protected void chargeFine(int amount) {

        if (fineCount < fineHistory.length) {

            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }

    public int[] getFineHistory() {

        return Arrays.copyOf(
            fineHistory,
            fineCount
        );
    }

    public int getTotalFine() {

        int total = 0;

        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }

        return total;
    }
}

class StudentMember3 extends LibraryMember3 {

    private String course;

    public StudentMember3(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {

        super.chargeFine(amount / 2);
    }
}

public class FineLedger {

    public static void main(String[] args) {

        StudentMember3 s =
                new StudentMember3(
                    "STU5",
                    3,
                    "CSE"
                );

        s.chargeFine(100);

        System.out.println(
            s.getTotalFine()
        );

        int[] history = s.getFineHistory();

        history[0] = 999;

        System.out.println(
            Arrays.toString(
                s.getFineHistory()
            )
        );
    }
}