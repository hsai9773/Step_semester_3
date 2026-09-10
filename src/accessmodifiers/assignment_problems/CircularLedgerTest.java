package accessmodifiers.assignment_problems;

public class CircularLedgerTest {

    public static void main(String[] args) {

        String[] books1 = {"B101", "B102"};
        String[] books2 = {"B201"};

        LoanReceipt regularReceipt = new LoanReceipt("M101", books1);

        ReferenceOnlyLoanReceipt referenceReceipt =
                new ReferenceOnlyLoanReceipt("M102", books2, "R101");

        LoanReceipt[] receipts = {
            regularReceipt,
            null,
            referenceReceipt
        };

        System.out.println(CirculationLedger.processNightlyCirculation(receipts));
    }
}